package com.kevin.useranalysedemo.utils.generator;

import java.util.Arrays;

import org.apache.commons.lang3.RandomUtils;

import com.kevin.useranalysedemo.utils.generator.base.GenericGenerator;

public class ProductNameGenerator extends GenericGenerator {
	private static ProductNameGenerator instance = new ProductNameGenerator();
	
	private static String[] productNames = { "iPhone6","iPhone6 Plus","iPhone原装数据线","iPhone正品钢化膜","OPPO R7 Plus","vivo Xplay 5S","华为荣耀7","华为荣耀灵犀一指专用膜","快速充电器","魅族MX5","魅族移动电源","三星Galaxy S6","小米note","小米插线板","小米移动电源" };
	
    private ProductNameGenerator() {
    }

    public static ProductNameGenerator getInstance() {
        return instance;
    }
		
	@Override
	public String generate() {
		int num = RandomUtils.nextInt(1 , productNames.length-1);		
		return productNames[num];		
	}	

}
