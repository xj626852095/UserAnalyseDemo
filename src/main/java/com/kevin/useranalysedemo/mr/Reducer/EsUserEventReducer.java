package com.kevin.useranalysedemo.mr.Reducer;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class EsUserEventReducer extends Reducer<Text, Text, Text, Text> {

	public void reduce(Text key, Iterable<Text> values, Reducer<Text, Text, Text, Text>.Context context) throws IOException, InterruptedException {
        
		long count = 0;
		Text eventId = new Text("-1");
		for(Text value : values) {
            count++;
            eventId = value;
        }
		context.write(key, new Text(eventId + " " + count));
    }
	
}
