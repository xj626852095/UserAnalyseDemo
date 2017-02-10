package com.kevin.useranalysedemo.mr.Reducer;

import java.io.IOException;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
import org.elasticsearch.hadoop.mr.LinkedMapWritable;

public class EsCompanyReducer extends Reducer<Text, LinkedMapWritable, Text, LinkedMapWritable> {
	
	public void reduce(Text key, Iterable<LinkedMapWritable> values,
            Reducer<Text, LinkedMapWritable, Text, LinkedMapWritable>.Context context)
            throws IOException, InterruptedException {
        for (LinkedMapWritable value : values) {
            context.write(key, value);
        }
    }
	
}
