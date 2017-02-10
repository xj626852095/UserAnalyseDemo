package com.kevin.useranalysedemo.junittest;

import org.apache.velocity.VelocityContext;

import com.kevin.useranalysedemo.utils.VelocityUtils;

public class VelocityTest {
	
	
	public static void main(String[] args) {
	    
		//取得velocity上下文  
        VelocityContext context = new VelocityContext();  
        context.put("name", "向杰");          
        
        System.out.println( VelocityUtils.getContent("velocity_vm/hello.vm", null) );
		
	}
	
	
}
