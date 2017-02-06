package com.kevin.useranalysedemo.utils;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;

public class JsonUtils {
	
	public static ObjectMapper mapper = new ObjectMapper();
	
	public static String toJson(Object o){
		try{
			ObjectWriter writer = mapper.writerWithDefaultPrettyPrinter();
			return writer.writeValueAsString(o);
		}catch(Exception e){
			e.printStackTrace();
			return "转换发生异常";
		}
	} 
}
