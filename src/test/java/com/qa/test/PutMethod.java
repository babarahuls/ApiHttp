package com.qa.test;

import java.io.IOException;

import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class PutMethod 
{
	private static String REQUEST_PAYLOAD = "{\"id\": 10,\"category\": {\"id\":20,\"name\": \"rahul1\"},\"name\": \"doggie\",\"photoUrls\": [\"string\"],\"tags\": [{\"id\": 0,\"name\": \"string\"}],\"status\": \"available\"}";

	@Test
	public void put() throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpPut httpput = new HttpPut("https://petstore.swagger.io/v2/pet");
		httpput.setEntity(new StringEntity(REQUEST_PAYLOAD)); // for payload               
		httpput.addHeader("Content-Type", "application/json");
		CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpput);

		System.out.println("***********Update Method*****************");

		//Validating status code 

		int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
		System.out.println("status code is: " + statusCode);

		//Validating status line

		StatusLine line=closeableHttpResponse.getStatusLine();
		System.out.println("status line:"+line);

		//Validating response body

		String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
		JSONObject responseJson = new JSONObject(responseString);
		System.out.println("Response body"+responseJson);



	}

}














