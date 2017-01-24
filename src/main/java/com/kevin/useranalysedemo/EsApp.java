package com.kevin.useranalysedemo;

import java.util.UUID;

import org.apache.commons.lang3.RandomUtils;

import com.kevin.useranalysedemo.model.User;
import com.kevin.useranalysedemo.utils.generator.ChineseIDCardNumberGenerator;
import com.kevin.useranalysedemo.utils.generator.ChineseMobileNumberGenerator;
import com.kevin.useranalysedemo.utils.generator.ChineseNameGenerator;
import com.kevin.useranalysedemo.utils.generator.DateGenerator;
import com.kevin.useranalysedemo.utils.generator.EventIdGenerator;
import com.kevin.useranalysedemo.utils.generator.ProvinceIdGenerator;


public class EsApp 
{
    public static void main( String[] args )
    {
    	ChineseNameGenerator nameGenerator = ChineseNameGenerator.getInstance();
		ChineseMobileNumberGenerator mobileNumberGenerator = ChineseMobileNumberGenerator.getInstance();
		ChineseIDCardNumberGenerator idCardNumberGenerator = (ChineseIDCardNumberGenerator) ChineseIDCardNumberGenerator.getInstance();
		ProvinceIdGenerator provinceIdGenerator = ProvinceIdGenerator.getInstance();
		EventIdGenerator eventIdGenerator = EventIdGenerator.getInstance();
		DateGenerator dateGenerator = DateGenerator.getInstance();
    	
		//设定月份
		String monthRange = "2016-12";
    	
    	//设定月活的数量，循环多少个userId 
    	int mau = 10000;
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
    		
    		System.out.println( user.toString() 
    				+"\n\t活跃的日数activeDayNum="+activeDayNum + "天");
    		
    		
    	}
    	    	
    }
}
