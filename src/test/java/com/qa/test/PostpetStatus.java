package com.qa.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.Header;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostpetStatus 
{



	//private static String REQUEST_PAYLOAD = "{\"id\": 204,\"category\": {\"id\": 12,\"name\": \"boobo\"},\"name\": \"rathi\",\"photoUrls\": [\"string\"],\"tags\": [{\"id\": 0,\"name\": \"tagName\"}],\"status\": \"sold\"}";

	private static String REQUEST_PAYLOAD = "{\"id\": 204,\"category\": {\"id\": 12,\"name\": \"boobo\"},\"name\": \"rahul\",\"photoUrls\": [\"string\"],\"tags\": [{\"id\": 0,\"name\": \"tagName\"}],\"status\": \"available\"}";
	@Test
	public void get() throws ClientProtocolException, IOException {

		CloseableHttpClient httpClient  = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost("https://petstore.swagger.io/v2/pet");
		httpPost.setEntity(new StringEntity(REQUEST_PAYLOAD));
		httpPost.addHeader("Content-Type","application/json");
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpPost);
		System.out.println("*****ADD Post Method******");

		//Status Code

		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("Status code is " +statusCode);
		Assert.assertEquals(statusCode, 200);

		//Status Line

		StatusLine line = closeableHttpResponse.getStatusLine();
		System.out.println("StatusLine:" +line);


		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("ResponseJSON" +responseJson);


	}
}

