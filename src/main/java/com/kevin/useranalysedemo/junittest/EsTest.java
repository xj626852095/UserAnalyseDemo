package com.kevin.useranalysedemo.junittest;

import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.junit.Test;

import com.kevin.useranalysedemo.utils.EsUtils;

public class EsTest {
	
	private TransportClient  client;
	
	//查询
	@Test
	public void query(){
		client = EsUtils.getEsClient();
		GetResponse getResponse = client.prepareGet()
				.setIndex(EsUtils.getIndexName())
				.setType(EsUtils.getTypeName())
				.setId("1")
				.execute()
				.actionGet();
		System.out.println("get="+getResponse.getSourceAsString());
		EsUtils.closeClient();		
	}
	
}
