package com.kevin.useranalysedemo.junittest;

import org.junit.Test;

import com.kevin.useranalysedemo.utils.generator.ChineseIDCardNumberGenerator;
import com.kevin.useranalysedemo.utils.generator.ChineseMobileNumberGenerator;
import com.kevin.useranalysedemo.utils.generator.ChineseNameGenerator;
import com.kevin.useranalysedemo.utils.generator.ProvinceIdGenerator;

public class GeneratorTest {
	
	@Test
	public void test1(){
		ChineseNameGenerator nameGenerator = ChineseNameGenerator.getInstance();
		ChineseMobileNumberGenerator mobileNumberGenerator = ChineseMobileNumberGenerator.getInstance();
		ChineseIDCardNumberGenerator idCardNumberGenerator = (ChineseIDCardNumberGenerator) ChineseIDCardNumberGenerator.getInstance();
		ProvinceIdGenerator provinceIdGenerator = ProvinceIdGenerator.getInstance();
		for(int i=0; i<10; i++){
			System.out.println("生成随机名字 "+i + " " + nameGenerator.generate() );
			System.out.println("生成随机手机号码 "+i + " " + mobileNumberGenerator.generate() );
			System.out.println("生成随机身份证号码"+i + " " + idCardNumberGenerator.generate() );
			System.out.println("生成随机省份"+i + " " + provinceIdGenerator.generate() );
		}		
	}	
	
}
