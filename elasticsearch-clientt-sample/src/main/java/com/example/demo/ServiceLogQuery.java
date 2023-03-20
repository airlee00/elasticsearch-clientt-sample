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
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.SearchTemplateResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import hone.admin.online.server.monitor.dto.elasticsearch.EsRequestLog;
public class ServiceLogQuery {

    public static String queryString = "{\n" +
    		"  \"query\": {\n" +
    		"    \"match\": {\n" +
    		"      \"guid\": \"{{guid}}\"\n" +
    		"    }\n" +
    		"  }\n" +
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
        		    .id("service-query-script")
        		    .script(s -> s
        		        .lang("mustache")
        		        .source(queryString)
        		    ));

//
//         SearchTemplateResponse<HashMap> search = esClient.searchTemplate(s -> s
//			    .index("airlee-*")
//			    .id("service-query-script")
//			    .params("guid", JsonData.of("cop222037129002202302201214102405977"))
//			    ,
//			    HashMap.class);

 		SearchResponse<HashMap> search = esClient.search(s -> s
				.index("airlee-*")
				.from(0)
				.size(10000)
			    .query(q -> q
			            .match(t -> t
			                    .field("guid")
			                    .query("cop442037129002202302201214102405977")
			                )
			    ),
			    HashMap.class
			);
         	HashMap hm = null;
			for (Hit<HashMap> hit: search.hits().hits()) {
				hm = hit.source();
				System.out.println(hm);
				EsRequestLog log = objectMapper.convertValue(hm, EsRequestLog.class);
			    System.out.println(log);

			}
			System.out.println(search.hits().total().value());
	}



}
