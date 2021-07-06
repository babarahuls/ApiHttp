package com.qa.test;

import java.io.IOException;

import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class FindPetStatus 
{
	
    @Test
       public void get() throws ClientProtocolException, IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://petstore.swagger.io/v2/pet/9");
        CloseableHttpResponse closeableHttpResponse = httpClient.execute(httpGet);
        
        System.out.println("***********FindByPetMethod*****************");

        //Validating the Status Code
        int statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
        System.out.println("Status Code is:" + statusCode);
        
        //Validating the Status Line
        
        StatusLine line = closeableHttpResponse.getStatusLine();
        System.out.println("Status Line:" + line);
        
        //Validating the Total no.of pets
    
        String responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
        
        JSONObject jsonobj=new JSONObject(responseString);
       System.out.println("Total Pets : " + jsonobj.length());

     }
}














