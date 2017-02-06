package com.kevin.useranalysedemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.UUID;

import org.apache.commons.lang3.RandomUtils;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.index.IndexRequestBuilder;
import org.elasticsearch.client.transport.TransportClient;

import com.kevin.useranalysedemo.model.UserEvent;
import com.kevin.useranalysedemo.model.User;
import com.kevin.useranalysedemo.utils.EsUtils;
import com.kevin.useranalysedemo.utils.JsonUtils;
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
    public static void main( String[] args ) throws ParseException
    {
    	TransportClient  client = EsUtils.getEsClient();
    	BulkRequestBuilder bulkRequest = client.prepareBulk();
    	
    	SimpleSysout.isdisplay = true;
    	
    	ChineseNameGenerator nameGenerator = ChineseNameGenerator.getInstance();
		ChineseMobileNumberGenerator mobileNumberGenerator = ChineseMobileNumberGenerator.getInstance();
		ChineseIDCardNumberGenerator idCardNumberGenerator = (ChineseIDCardNumberGenerator) ChineseIDCardNumberGenerator.getInstance();
		ProvinceIdGenerator provinceIdGenerator = ProvinceIdGenerator.getInstance();
		EventIdGenerator eventIdGenerator = EventIdGenerator.getInstance();
		DateGenerator dateGenerator = DateGenerator.getInstance();
		ProductNameGenerator productNameGenerator = ProductNameGenerator.getInstance();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		//设定月份
		Integer year = 2016;
		Integer month = 12;
    	
    	//设定月活的数量，循环多少个userId 
    	int mau = 100;
    	for(int i=0; i<mau; i++){
    		String userId = UUID.randomUUID().toString();
    		String userName = nameGenerator.generate();
    		String provinceStr = provinceIdGenerator.generate();
    		int provinceId = Integer.parseInt( provinceStr.split(":")[0] );
    		String provinceName = provinceStr.split(":")[1];
    		int age = RandomUtils.nextInt(18, 75);
    		User user = new User(userId, userName, provinceId, provinceName, age);
    		    		
    		//随机生成一个月活跃的日数 
    		int activeDayNum = RandomUtils.nextInt(12, 28);
    		String [] activeDayDates = dateGenerator.generateDays(year, month, activeDayNum);
    		Arrays.sort(activeDayDates);
    		
    		SimpleSysout.println( user.toString() 
    				+"\n\t活跃的日数activeDayNum="+activeDayNum + "天"
    				+"\n\t具体活跃日期activeDayDates="+Arrays.toString(activeDayDates));
    		
    		for(String activeDayDate : activeDayDates){
    			String[] eventIds = eventIdGenerator.generate();
    			String[] eventStatDates = dateGenerator.generateStatDate(eventIds.length, activeDayDate);
    			String productName = productNameGenerator.generate();
    			
    			SimpleSysout.println("\t\t日期["+activeDayDate+"] 用户随机事件eventIds="+Arrays.toString(eventIds)
    					+"\n\t\t 事件统计时间eventStatDates="+Arrays.toString(eventStatDates));
    			
    			for(int j=0; j<eventIds.length; j++){
    				int eventId = Integer.parseInt( eventIds[j].split(":")[0] );
    				String eventName = eventIds[j].split(":")[1]; 
    				Date statDate = sf.parse(eventStatDates[j]);
    				UserEvent userEvent = new UserEvent(userId, userName, provinceId, provinceName, age, eventId, eventName, statDate, productName);
    				
    				SimpleSysout.println("\t\t\t"+userEvent.toString());
    				
    				IndexRequestBuilder ir = client.prepareIndex()
    						.setIndex("user_analysys")
    						.setType("user_event")
    						//.setId(""+i)
    						.setSource( JsonUtils.toJson(userEvent) );
    				bulkRequest.add(ir);
    			}
    			 
    		}
    		
    		
    	}
    	
    	BulkResponse bulkResponse = bulkRequest.execute().actionGet();
		if(!bulkResponse.hasFailures()){
			System.out.println("全部插入成功");
		}
		
		EsUtils.closeClient();
    	
    	
    	    	
    }
}
