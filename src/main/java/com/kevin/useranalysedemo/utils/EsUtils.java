package com.kevin.useranalysedemo.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.plugins.Plugin;
import org.elasticsearch.transport.Netty3Plugin;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.elasticsearch.xpack.client.PreBuiltXPackTransportClient;


public class EsUtils {
	
	public static final String INDEX_NAME = "user_analysys";
	public static final String TYPE_NAME = "user_event";
	//public static final String CLUSTER_NAME = "es_cluster_jf9599";
	public static final String CLUSTER_NAME = "elasticsearch";
	public static final String ES_SERVER_HOST = "localhost";
	public static final int ES_SERVER_PORT = 9300;
	
	private static TransportClient  client;
	
	public static TransportClient  getEsClient(){		
		Settings settings = Settings.builder()
		        .put("cluster.name", CLUSTER_NAME)//指定集群名称
		        .put("client.transport.sniff", true)//探测集群中机器状态
		        //.put("xpack.security.user","elastic:changeme")
		        .build();		
		//client = new PreBuiltXPackTransportClient(settings);
		client = new PreBuiltTransportClient(settings);
		
		try {
			client.addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName(ES_SERVER_HOST), ES_SERVER_PORT));
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return client;
	}
	
	public static void closeClient(){
		if(client!=null)
			client.close();
	}
	
	public static String getIndexName() {
		return INDEX_NAME;
	}
	public static String getTypeName() {
		return TYPE_NAME;
	}
	
	
	
	
	
}
