package com.kevin.useranalysedemo.utils.generator;

import java.util.Arrays;

import org.apache.commons.lang3.RandomUtils;

import com.kevin.useranalysedemo.utils.generator.base.GenericGenerator;

public class EventIdGenerator extends GenericGenerator {
	private static EventIdGenerator instance = new EventIdGenerator();
	
	private static String[] events = {"1:ViewHomePage", "2:Login", "3:SearchProduct","4:ViewProduct","5:Order","6:PayOrder" };
	
    private EventIdGenerator() {
    }

    public static EventIdGenerator getInstance() {
        return instance;
    }
		
	@Override
	public String[] generate() {
		int num = RandomUtils.nextInt(1 , events.length);		
		return Arrays.copyOfRange( events , 0 , num );		
	}	

}
