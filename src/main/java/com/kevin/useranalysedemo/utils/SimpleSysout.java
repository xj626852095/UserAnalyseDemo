package com.kevin.useranalysedemo.utils;

public class SimpleSysout {
	
	public static boolean isdisplay = true;
	
	public static void println(String content){
		if(isdisplay){
			System.out.println(content);
		}
	} 
	
}
