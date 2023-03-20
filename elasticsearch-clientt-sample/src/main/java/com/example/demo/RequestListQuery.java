package com.example.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.ElasticsearchException;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch._types.query_dsl.RangeQuery;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.SearchTemplateResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import co.elastic.clients.json.JsonData;
import co.elastic.clients.json.jackson.JacksonJsonpMapper;
import co.elastic.clients.transport.ElasticsearchTransport;
import co.elastic.clients.transport.rest_client.RestClientTransport;
import hone.admin.online.server.monitor.dto.elasticsearch.EsRequestLog;
public class RequestListQuery {

	public static void main(String[] args) throws ElasticsearchException, IOException  {
		testt2();
	}


	public static void testt1() throws ElasticsearchException, IOException  {
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

		String queryString = "{" +
				"  \"from\" : {{from}}," +
				"  \"size\" : {{size}}," +
				"  \"query\": { " +
				"    \"bool\" : {" +
				"        \"must\" :{" +
				"          \"match\": { " +
				"              \"marker\": \"FRT.TX_END\"" +
				"           }" +
				"        }" +
				"        ," +
				"          \"filter\" : {" +
				"            \"range\" : {" +
				"                \"ts\": {" +
				"                   \"gt\" : \"{{startTime}}\"," +
				"                   \"lt\" : \"{{endTime}}\" " +
				"                } " +
				"            }" +
				"          }" +
				"      }" +
				"    }" +
				"    ,\"sort\": [" +
				"        {\"ts\": \"asc\"}" +
				"    ]" +
				"}";


		esClient.putScript(r -> r
				.id("query-script")
				.script(s -> s
						.lang("mustache")
						.source(queryString)
						));

		SearchTemplateResponse<HashMap> search = esClient.searchTemplate(s -> s
				.index("airlee-*")
				.id("query-script")
				.params("from", JsonData.of("0"))
				.params("size", JsonData.of("10"))
				.params("startTime", JsonData.of("2023-02-28T04:55:22"))
				.params("endTime", JsonData.of("2023-02-28T17:55:22"))  ,
				//startTime	"2023-02-28T15:55:22" (id=262)
				// endTime	"2023-02-28T16:55:22" (id=263)

				HashMap.class);

		HashMap hm = null;
		for (Hit<HashMap> hit : search.hits().hits()) {
			hm = hit.source();
			EsRequestLog log = objectMapper.convertValue(hm, EsRequestLog.class);
			System.out.println(log.getHost().get("name"));
			System.out.println(log);

		}
		System.out.println(search.hits().total().value());
	}
	public static void testt2() throws ElasticsearchException, IOException  {
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


		// Search by marker": "FRT.TX_END"
		Query byMarker = MatchQuery.of(m -> m
		    .field("marker")
		    .query("FRT.TX_END")
		)._toQuery();

		// Search by max price
		Query byTs = RangeQuery.of(r -> r
		    .field("ts")
		    .gte(JsonData.of("2023-03-01T00:00:22"))
		    .lt(JsonData.of("2023-03-02T23:00:22"))
		)._toQuery();

		List<Query> nestedQuery = new ArrayList<>();

		Query byGuid = MatchQuery.of(m -> m
				.field("guid")
				.query("cop332037129002202302201214102405977")
				//.query("")
				)._toQuery();

		Query byUserId = MatchQuery.of(m -> m
				.field("userId")
				.query("1234567")
				)._toQuery();

		Query byResuleCode = MatchQuery.of(m -> m
				.field("resultCode")
				.query("1")
				)._toQuery();
		nestedQuery.add(byGuid);

		// Combine name and price queries to search the product index
		SearchResponse<HashMap> response = esClient.search(s -> s
			.index("airlee-*")
			.from(0)
			.size(10)
		    .query(q -> q
		        .bool(b -> b
		            .must(byMarker)
		            .must(nestedQuery)
		            .filter(byTs)
		        )
		    ),
		    HashMap.class
		);



		HashMap hm = null;
		for (Hit<HashMap> hit : response.hits().hits()) {
			hm = hit.source();
			EsRequestLog log = objectMapper.convertValue(hm, EsRequestLog.class);
			System.out.println(log.getHost().get("name"));
			System.out.println(log);

		}
		System.out.println(response.hits().total().value());
	}



}
