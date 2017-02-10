package com.kevin.useranalysedemo.utils;

import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.app.VelocityEngine;

public class VelocityUtils {
	
	static public VelocityEngine velocityEngine = null;
	static {
		Properties properties=new Properties();
	    properties.setProperty("resource.loader", "class");
	    properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
	    properties.setProperty(Velocity.ENCODING_DEFAULT, "UTF-8");
	    properties.setProperty(Velocity.INPUT_ENCODING, "UTF-8");
	    properties.setProperty(Velocity.OUTPUT_ENCODING, "UTF-8");
	    properties.setProperty(Velocity.FILE_RESOURCE_LOADER_CACHE, "true");
	    velocityEngine = new VelocityEngine(properties);
	}
	
	public static String getContent(String vmPath, VelocityContext context){
		StringWriter sw = new StringWriter();
		if(context==null)
			context = new VelocityContext(); 
        velocityEngine.mergeTemplate(vmPath, "utf-8", context, sw);
        String content = sw.toString();
        try{
        	sw.close();
        }catch(Exception e){
        	e.printStackTrace();
        }
        return content;
	}
}
