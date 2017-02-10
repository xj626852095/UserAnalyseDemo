package com.kevin.useranalysedemo.mr.mapper;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class UserIntersectionMapper extends Mapper<LongWritable, Text, Text, Text> {
	
	@Override
	protected void map(LongWritable key, Text value, Mapper<LongWritable, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
			
		System.out.println(key.toString());
		System.out.println(value.toString());
		
		context.write(new Text(key.toString()), value);
	}

}
