package com.kevin.useranalysedemo.utils;

import java.io.FileInputStream;
import java.net.URLDecoder;
import java.util.Properties;

public class PropertyUtil {
		
	/** The config. */
	private static Properties config = null;
	
	/** The property file name .*/
	private static final String PROPERTYIES_NAME = "conf.properties";
	
	private PropertyUtil(){
		config = new Properties();
        try{
        	String path = this.getClass().getClassLoader().getResource("").getPath();//得到工程名WEB-INF/classes/路径
        	path=URLDecoder.decode(path,"utf-8");//中文转码
        	config.load(new FileInputStream(path + PROPERTYIES_NAME ));
	      }catch(Exception e){
	    	  System.out.println("加载配置文件[radar.properties]错误!" + e.toString());
	      }
	}
	
	/**
	 * The Class LazyHolder.
	 */
	private static class LazyHolder {
		
		/** The INSTANCE. */
		private static PropertyUtil INSTANCE = new PropertyUtil();
	}

	/**
	 * Gets the single instance of PropertyConfig.
	 *
	 * @return single instance of PropertyConfig
	 */
	public static PropertyUtil getInstance() {
		return LazyHolder.INSTANCE;
	}

	/**
	 * Gets the string.
	 *
	 * @param key the key
	 * @return the string
	 */
	public String getString(String key) {
		return config.getProperty(key);
	}
	

}