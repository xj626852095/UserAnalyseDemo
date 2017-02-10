package com.kevin.useranalysedemo.mr.Reducer;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class UserIntersectionReducer extends Reducer<Text, Text, Text, Text> {

	@Override
	protected void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context)
			throws IOException, InterruptedException {
		
		Text oneValue = new Text();
		for(Text value : values){
			oneValue = value;
		}
		
		context.write(key, oneValue);
		
	}
	
}
