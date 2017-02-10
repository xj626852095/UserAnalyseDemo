package com.kevin.useranalysedemo.junittest;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.elasticsearch.hadoop.mr.EsInputFormat;
import org.elasticsearch.hadoop.mr.EsOutputFormat;
import org.elasticsearch.hadoop.mr.LinkedMapWritable;

import com.kevin.useranalysedemo.mr.mapper.EsCompanyMapper;
import com.kevin.useranalysedemo.mr.mapper.EsCompanyReducer;

public class EsHadoopTest {
	
	
	public static void main(String[] args) throws Exception{
		
        long start_time = System.currentTimeMillis();
        Configuration conf = new Configuration();
        conf.set("es.nodes", "192.168.200.95:9200");
        conf.set("es.resource.read", "company/info");
        conf.set("es.resource.write", "company_new/info");
        conf.set("es.net.http.auth.user","elastic");
        conf.set("es.net.http.auth.pass","changeme");
        conf.set("es.input.json", "yes");
        conf.set("es.query", "{\"size\":1,\"query\":{},\"_source\":[\"name\"],\"aggs\":{\"group_province\":{\"terms\":{\"field\":\"registered_date\"}}}}");
        

        Job job = Job.getInstance(conf,"hadoop elasticsearch");

        // 指定自定义的Mapper阶段的任务处理类
        job.setMapperClass(EsCompanyMapper.class);
        //job.setReducerClass(EsCompanyReducer.class);
        // 设置map输出格式
        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(Text.class);
        // 设置输入格式
        job.setInputFormatClass(EsInputFormat.class);
        //job.setOutputFormatClass(EsOutputFormat.class);
        // 设置输出路径
        //FileOutputFormat.setOutputPath(job, new Path("hdfs://localhost:9000/es_output_company _info"));
        FileOutputFormat.setOutputPath(job, new Path("F:/mr-fs/es-out"));
        
        // 运行MR程序
        job.waitForCompletion(true);
        System.out.println(System.currentTimeMillis()-start_time);
		
	}
}
