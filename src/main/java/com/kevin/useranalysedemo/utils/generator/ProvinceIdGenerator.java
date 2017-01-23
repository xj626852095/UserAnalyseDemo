package com.kevin.useranalysedemo.utils.generator;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;

import com.kevin.useranalysedemo.utils.generator.base.GenericGenerator;

public class ProvinceIdGenerator extends GenericGenerator {
	private static ProvinceIdGenerator instance = new ProvinceIdGenerator();
	private static List<String> provinces = new ArrayList<String>();
	
    private ProvinceIdGenerator() {
    }

    public static ProvinceIdGenerator getInstance() {
        return instance;
    }
		
	@Override
	public String generate() {
		return provinces.get( RandomUtils.nextInt(0 , provinces.size()) );		
	}
		
	static{
		provinces.add("2:北京");
		provinces.add("3:天津");
		provinces.add("4:河北");
		provinces.add("5:山西");
		provinces.add("6:内蒙古");
		provinces.add("7:辽宁");
		provinces.add("8:吉林");
		provinces.add("9:黑龙江");
		provinces.add("10:上海");
		provinces.add("11:江苏");
		provinces.add("12:浙江");
		provinces.add("13:安徽");
		provinces.add("14:福建");
		provinces.add("15:江西");
		provinces.add("16:山东");
		provinces.add("17:河南");
		provinces.add("18:湖北");
		provinces.add("19:湖南");
		provinces.add("20:广东");
		provinces.add("21:广西");
		provinces.add("22:海南");
		provinces.add("23:重庆");
		provinces.add("24:四川");
		provinces.add("25:贵州");
		provinces.add("26:云南");
		provinces.add("27:西藏");
		provinces.add("28:陕西");
		provinces.add("29:甘肃");
		provinces.add("30:青海");
		provinces.add("31:宁夏回族自治区");
		provinces.add("32:新疆");
	}
	

}
