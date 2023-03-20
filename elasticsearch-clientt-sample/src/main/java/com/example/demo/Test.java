package com.example.demo;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.SearchTemplateResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import hone.admin.online.server.monitor.dto.RequestLog;
import hone.bom.util.date.DateUtils;
import co.elastic.clients.json.JsonData;
public class Test {

	public static void main(String[] args) throws ElasticsearchException, IOException  {
		long a =1677565019000l;
		System.out.println(a);
		System.out.println(new Date().getTime());
		System.out.println(System.currentTimeMillis());

		String d = DateUtils.formatDate(a, "yyyy-MM-dd'T'HH:mm:ss");
		System.out.println(d);

	}



}
