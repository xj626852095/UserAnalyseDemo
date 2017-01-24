package com.kevin.useranalysedemo.utils.generator;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.RandomUtils;

public class DateGenerator {
	private static DateGenerator instance = new DateGenerator();
	private DateGenerator() {
    }

    public static DateGenerator getInstance() {
        return instance;
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
