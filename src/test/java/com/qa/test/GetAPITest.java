package com.qa.test;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.Testbase;
import com.qa.client.GetAPI;


public class GetAPITest extends Testbase
{
	 Testbase  testbase;
	 String serviceurl;
	 String apiurl;
	 String url;
	 GetAPI  getAPI;
	
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException
	{
		 testbase=new  Testbase();
		 serviceurl=prop.getProperty("url");
		 apiurl=prop.getProperty("serviceurl");
		 
		 url=serviceurl + apiurl;
		 
	}
	
	@Test
	public void getAPITest() throws ClientProtocolException, IOException
	{
		 getAPI = new  GetAPI();
		 getAPI.get(url);
		
		
	}
	

}
