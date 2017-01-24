package com.kevin.useranalysedemo.utils.generator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import org.apache.commons.lang3.RandomUtils;

public class DateGenerator {
	private static DateGenerator instance = new DateGenerator();	
	private DateGenerator() {
    }

    public static DateGenerator getInstance() {
        return instance;
    }
    
    private Integer[] day31 = {1,3,5,7,8,10,12};
    private Integer[] day30 = {4,6,9,11};
    private Integer[] day28 = {2};
    
    /**
     * @param year 年
     * @param month 月
     * @param cnt 需要产生随机日数的个数
     * @return 返回一个string[] 装 cnt个 yyyy-MM-dd格式的日期
     */
    public String[] generateDays(int year, int month, int cnt){
    	List<Integer> allDayNums = new ArrayList<>();
    	int daySize = 0;
    	if( Arrays.asList(day31).contains(month) )
    		daySize = 31;
    	else if( Arrays.asList(day30).contains(month) )
    		daySize = 30;
    	else if( Arrays.asList(day28).contains(month) )
    		daySize = 28;
    	for( int i=1; i<=daySize; i++ ){
    		allDayNums.add(i);
    	}
    	    	
    	String[] result = new String[cnt];
    	//随机取一天， 取一天后删除
    	for( int i=0; i<cnt; i++ ){
    		int tmpIndex = RandomUtils.nextInt(0, allDayNums.size());
    		int day = allDayNums.get(tmpIndex);
    		allDayNums.remove(tmpIndex);
    		result[i] = year+"-"+month+"-"+day;
    	}
    	    	
    	return result;
    }
    
    
    /**
     * cnt 为返回的个数
     * startDate 为年月日
     * @return 返回 cnt 个统计时间， 而且时间为递增的
     */
    public String[] generateStatDate(int cnt, String dateStr) { 
    	int hour =  RandomUtils.nextInt(8, 15);    	
    	//每次递增的秒数    	
    	SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	Date startDate = null; 
    	try {
    		startDate = sf.parse(dateStr+" " + hour+":00:00" );
		} catch (ParseException e) {
			e.printStackTrace();
		}
    	
    	String[] result = new String[cnt];
    	for(int i=0; i<cnt; i++){
    		startDate = new Date( startDate.getTime()+ RandomUtils.nextInt(100, 800)*1000);
    		result[i] = sf.format(startDate);
    	}
    	
    	return result;
    }    
}
