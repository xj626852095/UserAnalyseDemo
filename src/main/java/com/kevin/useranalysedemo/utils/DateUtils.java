package com.kevin.useranalysedemo.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
	
	public static String getNowStr (String dateFormat){
		if(dateFormat==null){
			dateFormat = "yyyyMMddHHmmss";
		}
		SimpleDateFormat sf = new SimpleDateFormat(dateFormat);
		Date now = new Date();
		return  sf.format(now);
	}
	
}
