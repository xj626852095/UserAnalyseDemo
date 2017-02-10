package com.kevin.useranalysedemo.mr.mapper;

import java.io.IOException;
import java.util.Set;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.Writable;
import org.apache.hadoop.mapreduce.Mapper;
import org.elasticsearch.hadoop.mr.LinkedMapWritable;

public class EsUserEventMapper extends Mapper<Text, LinkedMapWritable, Text, Text> {
	
	@Override
    public void map(Text key, LinkedMapWritable value, Mapper<Text, LinkedMapWritable, Text, Text>.Context context) throws IOException, InterruptedException {                		

		Writable userId = value.get(new Text("userId"));
		Writable eventId = value.get(new Text("eventId"));
		if(userId==null || eventId==null){
			return ;
		}
			
		context.write(new Text(userId.toString()), new Text(eventId.toString()));
    }
	
}
