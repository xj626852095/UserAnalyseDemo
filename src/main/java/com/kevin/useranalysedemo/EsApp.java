package com.kevin.useranalysedemo;

import java.util.UUID;

import com.kevin.useranalysedemo.utils.generator.ChineseIDCardNumberGenerator;
import com.kevin.useranalysedemo.utils.generator.ChineseMobileNumberGenerator;
import com.kevin.useranalysedemo.utils.generator.ChineseNameGenerator;
import com.kevin.useranalysedemo.utils.generator.DateGenerator;
import com.kevin.useranalysedemo.utils.generator.EventIdGenerator;
import com.kevin.useranalysedemo.utils.generator.ProvinceIdGenerator;

/**
 * Hello world!
 *
 */
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
    	
    	
    	//设定月活的数量，循环多少个userId 
    	int mau = 100000;
    	for(int i=0; i<mau; i++){
    		String userId = UUID.randomUUID().toString();
    		String userName = nameGenerator.generate();
    		    		
    	}
    	    	
    }
}
