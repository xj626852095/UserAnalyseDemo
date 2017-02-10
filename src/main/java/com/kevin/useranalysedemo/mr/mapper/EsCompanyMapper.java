package com.kevin.useranalysedemo.mr.mapper;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Mapper;
import org.elasticsearch.hadoop.mr.LinkedMapWritable;

public class EsCompanyMapper extends Mapper<Writable, Writable, Text, Text> {
	
	@Override
    public void map(Writable key, Writable value, Mapper<Writable, Writable, Text, Text>.Context context) throws IOException, InterruptedException {                
		Text keyText = new Text(key.toString());
		Text valueText = new Text(value.toString());
		context.write(keyText, valueText);
		System.out.println("mapper key: " + keyText.toString());
		System.out.println("mapper value: " + valueText.toString());
    }
	
}
