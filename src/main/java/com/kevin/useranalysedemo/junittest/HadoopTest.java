package com.kevin.useranalysedemo.junittest;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;
import org.junit.Before;
import org.junit.Test;

public class HadoopTest {
	
	private FileSystem fs = null;  
    private String BASE_DIR= "hdfs://192.168.200.95:9000/";  
	
    @Before  
    public void getFs() throws IOException{  
          
        //get a configuration object  
        Configuration conf = new Configuration();  
        //to set a parameter, figure out the filesystem is hdfs  
        conf.set("fs.defaultFS", BASE_DIR);  
        conf.set("dfs.replication","1");  
          
        //get a instance of HDFS FileSystem Client  
        fs = FileSystem.get(conf);  
          
    }  
    
    @Test  
    public void testListFiles() throws FileNotFoundException, IllegalArgumentException, IOException{  
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);  
        while(listFiles.hasNext()){  
            LocatedFileStatus file = listFiles.next();  
            System.out.println(file.getPath().getName());  
        }  
        System.out.println("--------------------------------------------");  
        FileStatus[] status = fs.listStatus(new Path("/"));  
        for(FileStatus file: status){             
            System.out.println(file.getPath().getName() + "   " + (file.isDirectory()?"d":"f"));           
        }  
    }
    	
}
