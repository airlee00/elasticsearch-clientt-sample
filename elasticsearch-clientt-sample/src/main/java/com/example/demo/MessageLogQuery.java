package com.example.demo;

import java.io.IOException;
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
import co.elastic.clients.elasticsearch.core.SearchTemplateResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import hone.admin.online.server.monitor.dto.elasticsearch.EsRequestLog;
public class MessageLogQuery {

    public static String queryString = "{\n" +
    		"  \"from\": 0,\n" +
    		"  \"size\": 10,\n" +
    		"  \"query\": {\n" +
    		"    \"bool\": {\n" +
    		"      \"must\": [\n" +
    		"        {\n" +
    		"          \"match\": {\n" +
    		"            \"marker\": \"FRT.REQ_MESSAGE FRT.RES_MESSAGE\"\n" +
    		"          }\n" +
    		"        },\n" +
    		"        {\n" +
    		"          \"match\": {\n" +
    		"            \"requestId\": \"{{requestId}}\"\n" +
    		"          }\n" +
    		"        }\n" +
    		"      ]\n" +
    		"    }\n" +
    		"  },\n" +
    		"  \"sort\": [\n" +
    		"    {\n" +
    		"      \"ts\": \"asc\"\n" +
    		"    }\n" +
    		"  ]\n" +
    		"}";

	public static void main(String[] args) throws ElasticsearchException, IOException  {
		//SpringApplication.run(Demo1Application.class, args);
		// Create the low-level client
		RestClient restClient = RestClient.builder(
		    new HttpHost("10.211.55.4", 9200)).build();

		// Create the transport with a Jackson mapper
		ElasticsearchTransport transport = new RestClientTransport(
		    restClient, new JacksonJsonpMapper());

		// And create the API client
		ElasticsearchClient esClient = new ElasticsearchClient(transport);


         ObjectMapper objectMapper = new ObjectMapper();
         objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
         objectMapper.configure(MapperFeature.ACCEPT_CASE_INSENSITIVE_PROPERTIES, true);
         objectMapper.configure(JsonGenerator.Feature.WRITE_BIGDECIMAL_AS_PLAIN, true);
         objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);



         esClient.putScript(r -> r
        		    .id("message-query-script")
        		    .script(s -> s
        		        .lang("mustache")
        		        .source(queryString)
        		    ));


         SearchTemplateResponse<HashMap> search = esClient.searchTemplate(s -> s
			    .index("airlee-*")
			    .id("message-query-script")
			    .params("requestId", JsonData.of("exm192168176120202302241419518772472"))
			    ,
			    HashMap.class);

         String msg;
			for (Hit<HashMap> hit: search.hits().hits()) {
				System.out.println(hit.source().get("marker"));
				msg = hit.source().get("msg").toString();
				System.out.println(msg.substring(msg.indexOf("data=")));

			}
			System.out.println(search.hits().total().value());
	}



}
