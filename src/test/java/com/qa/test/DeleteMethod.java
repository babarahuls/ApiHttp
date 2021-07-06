package com.qa.test;

import java.io.IOException;

import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

public class DeleteMethod 
{
	
	 @Test
	    public void delete() throws ClientProtocolException, IOException {
	        
	        CloseableHttpClient httpClient = HttpClients.createDefault();
	        HttpDelete httpdelete = new HttpDelete("https://petstore.swagger.io/v2/pet/10");
	        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpdelete);        
	        EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
	        
	        System.out.println("***********Delete Method*****************");
	        
	        //Validating status Code
	        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
	        System.out.println("status code is: " + statusCode);
	        
	        //Validating Status line
	        StatusLine line=closeableHttpResponse.getStatusLine();
	        System.out.println("status line:"+line);
	        
	      
	    }

}
