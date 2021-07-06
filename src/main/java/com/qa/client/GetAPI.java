package com.qa.client;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class GetAPI 
{
	
	//Get Method
		public void get(String url) throws ClientProtocolException, IOException
		{
			CloseableHttpClient httpClient=HttpClients.createDefault();
			HttpGet  httpget=new HttpGet(url); //http get request
			CloseableHttpResponse closeableHttpResponse=httpClient.execute(httpget); //hit the GET url
			
			//a.Status code
			int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
			System.out.println("StatusCode"+ statusCode );
			
			//b.json String
			String responseString= EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			JSONObject responseJson=new JSONObject(responseString);
			System.out.println("Response JSON from API"+ responseJson );
			
	
			
		}

}
