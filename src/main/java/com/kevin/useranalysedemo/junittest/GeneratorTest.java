package com.kevin.useranalysedemo.junittest;

import java.util.Arrays;
import java.util.UUID;

import org.junit.Test;

import com.kevin.useranalysedemo.utils.generator.ChineseIDCardNumberGenerator;
import com.kevin.useranalysedemo.utils.generator.ChineseMobileNumberGenerator;
import com.kevin.useranalysedemo.utils.generator.ChineseNameGenerator;
import com.kevin.useranalysedemo.utils.generator.DateGenerator;
import com.kevin.useranalysedemo.utils.generator.EventIdGenerator;
import com.kevin.useranalysedemo.utils.generator.ProductNameGenerator;
import com.kevin.useranalysedemo.utils.generator.ProvinceIdGenerator;

public class GeneratorTest {
	
	@Test
	public void test1(){
		ChineseNameGenerator nameGenerator = ChineseNameGenerator.getInstance();
		ChineseMobileNumberGenerator mobileNumberGenerator = ChineseMobileNumberGenerator.getInstance();
		ChineseIDCardNumberGenerator idCardNumberGenerator = (ChineseIDCardNumberGenerator) ChineseIDCardNumberGenerator.getInstance();
		ProvinceIdGenerator provinceIdGenerator = ProvinceIdGenerator.getInstance();
		EventIdGenerator eventIdGenerator = EventIdGenerator.getInstance();
		DateGenerator dateGenerator = DateGenerator.getInstance();
		ProductNameGenerator productNameGenerator = ProductNameGenerator.getInstance();
		 
		for(int i=0; i<10; i++){
//			System.out.println("生成随机UUID "+i + " " + UUID.randomUUID() );
//			System.out.println("生成随机名字 "+i + " " + nameGenerator.generate() );
//			System.out.println("生成随机手机号码 "+i + " " + mobileNumberGenerator.generate() );
//			System.out.println("生成随机身份证号码"+i + " " + idCardNumberGenerator.generate() );
//			System.out.println("生成随机省份"+i + " " + provinceIdGenerator.generate() );
//			System.out.println("生成随机事件"+i + " " + Arrays.toString( eventIdGenerator.generate() )  );
			
//			String [] tmp = dateGenerator.generateDays(2016, 12, 31);
//			Arrays.sort(tmp);
//			System.out.println("生成随机时间"+i + " " + Arrays.toString( tmp ) );
			
			System.out.println( productNameGenerator.generate() );
		}		
	}	
	
}
