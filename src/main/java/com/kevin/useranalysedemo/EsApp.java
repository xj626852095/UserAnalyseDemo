package com.kevin.useranalysedemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.RandomUtils;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.client.transport.TransportClient;
import com.kevin.useranalysedemo.model.User;
import com.kevin.useranalysedemo.model.UserEvent;
import com.kevin.useranalysedemo.utils.EsUtils;
import com.kevin.useranalysedemo.utils.JsonUtils;
import com.kevin.useranalysedemo.utils.PropertyUtil;
import com.kevin.useranalysedemo.utils.SimpleSysout;
import com.kevin.useranalysedemo.utils.generator.ChineseIDCardNumberGenerator;
import com.kevin.useranalysedemo.utils.generator.ChineseMobileNumberGenerator;
import com.kevin.useranalysedemo.utils.generator.ChineseNameGenerator;
import com.kevin.useranalysedemo.utils.generator.DateGenerator;
import com.kevin.useranalysedemo.utils.generator.EventIdGenerator;
import com.kevin.useranalysedemo.utils.generator.ProductNameGenerator;
import com.kevin.useranalysedemo.utils.generator.ProvinceIdGenerator;


public class EsApp 
{
	
	static public int esBulkCommitCnt = 0;
	
    public static void main( String[] args ) throws ParseException
    {

    	
    	
    	//设定月份
    	Integer year = Integer.parseInt( PropertyUtil.getInstance().getString("user.analysys.year") );
    	Integer month = Integer.parseInt( PropertyUtil.getInstance().getString("user.analysys.month") );
    	//设定月活的数量，循环多少个userId 
    	Integer mau = Integer.parseInt( PropertyUtil.getInstance().getString("user.analysys.mau") );
    	//es批量提交设置
    	String esDefaultIndexName = PropertyUtil.getInstance().getString("es.default.index.name");
    	String esUserTypeName = PropertyUtil.getInstance().getString("es.user.type.name");
    	String esUserEventTypeName = PropertyUtil.getInstance().getString("es.userevent.type.name");
    	Integer esBulkActionSize = Integer.parseInt( PropertyUtil.getInstance().getString("es.bulk.action.size") );
    	Integer esBulkMSize = Integer.parseInt( PropertyUtil.getInstance().getString("es.bulk.m.size") );    	
    	Integer esBulkFlushInterval = Integer.parseInt( PropertyUtil.getInstance().getString("es.bulk.flush.interval") );
    	Integer esBulkConcurrentRequests = Integer.parseInt( PropertyUtil.getInstance().getString("es.bulk.concurrent.requests") );
    	
    	SimpleSysout.isdisplay = true;
    	
    	//初始化随机生成器    	    	
    	ChineseNameGenerator nameGenerator = ChineseNameGenerator.getInstance();
		ChineseMobileNumberGenerator mobileNumberGenerator = ChineseMobileNumberGenerator.getInstance();
		ChineseIDCardNumberGenerator idCardNumberGenerator = (ChineseIDCardNumberGenerator) ChineseIDCardNumberGenerator.getInstance();
		ProvinceIdGenerator provinceIdGenerator = ProvinceIdGenerator.getInstance();
		EventIdGenerator eventIdGenerator = EventIdGenerator.getInstance();
		DateGenerator dateGenerator = DateGenerator.getInstance();
		ProductNameGenerator productNameGenerator = ProductNameGenerator.getInstance();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
		TransportClient  client = EsUtils.getEsClient();		
		
    	BulkProcessor bulkProcessor = BulkProcessor.builder(client, new BulkProcessor.Listener() {			
			@Override
			public void beforeBulk(long arg0, BulkRequest arg1) {
			}			
			@Override
			public void afterBulk(long arg0, BulkRequest arg1, Throwable arg2) {
			}
			@Override
			public void afterBulk(long arg0, BulkRequest arg1, BulkResponse arg2) {
				esBulkCommitCnt = esBulkCommitCnt + 1;
				SimpleSysout.println("esBulk进行了 ["+esBulkCommitCnt+"] 次批量提交");
			}
		})
    	.setBulkActions(esBulkActionSize)
        .setConcurrentRequests(esBulkConcurrentRequests) 
    	.build();
    	    	
		
    	for(int i=0; i<mau; i++){
    		String userId = UUID.randomUUID().toString();
    		String userName = nameGenerator.generate();
    		String provinceStr = provinceIdGenerator.generate();
    		int provinceId = Integer.parseInt( provinceStr.split(":")[0] );
    		String provinceName = provinceStr.split(":")[1];
    		int age = RandomUtils.nextInt(18, 75);
    		User user = new User(userId, userName, provinceId, provinceName, age);
    		
    		//将user加入es索引
    		IndexRequest userIr = new IndexRequest(esDefaultIndexName, esUserTypeName).source(JsonUtils.toJson(user));
			bulkProcessor.add(userIr);
    		
    		//随机生成一个月活跃的日数 
    		int activeDayNum = RandomUtils.nextInt(12, 28);
    		String [] activeDayDates = dateGenerator.generateDays(year, month, activeDayNum);
    		Arrays.sort(activeDayDates);
    		
//    		SimpleSysout.println( user.toString() 
//    				+"\n\t活跃的日数activeDayNum="+activeDayNum + "天"
//    				+"\n\t具体活跃日期activeDayDates="+Arrays.toString(activeDayDates));
    		
    		for(String activeDayDate : activeDayDates){
    			String[] eventIds = eventIdGenerator.generate();
    			String[] eventStatDates = dateGenerator.generateStatDate(eventIds.length, activeDayDate);
    			String productName = productNameGenerator.generate();
    			
//    			SimpleSysout.println("\t\t日期["+activeDayDate+"] 用户随机事件eventIds="+Arrays.toString(eventIds)
//    					+"\n\t\t 事件统计时间eventStatDates="+Arrays.toString(eventStatDates));
    			
    			for(int j=0; j<eventIds.length; j++){
    				int eventId = Integer.parseInt( eventIds[j].split(":")[0] );
    				String eventName = eventIds[j].split(":")[1]; 
    				Date statDate = sf.parse(eventStatDates[j]);
    				UserEvent userEvent = new UserEvent(userId, userName, provinceId, provinceName, age, eventId, eventName, statDate, productName);    				
//    				SimpleSysout.println("\t\t\t"+userEvent.toString());
    				
    				//将userEvent加入es索引
    				IndexRequest ir = new IndexRequest(esDefaultIndexName, esUserEventTypeName).source(JsonUtils.toJson(userEvent));
    				bulkProcessor.add(ir);
    				
    			}    			 
    		}    		    	
    	}
    			
    	bulkProcessor.flush();    	
    	bulkProcessor.close();
		EsUtils.closeClient();
    	
    	
    	    	
    }
}
