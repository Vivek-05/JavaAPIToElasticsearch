package com.ait.http;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.logging.Logger;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.log4j.BasicConfigurator;

public class HttpResponse {

	public static Logger log = Logger.getAnonymousLogger();

	public static void main(String[] args) throws Exception {

		BasicConfigurator.configure();

		FileInputStream f = new FileInputStream("C:\\Users\\Vivek\\Desktop\\outputLog.json");       // search and open a file 

		BufferedReader b = new BufferedReader(new InputStreamReader(f));                         //read a file line by line
		
		HttpClient httpClient = HttpClientBuilder.create().build();                            //create the connection
		
		HttpPost request = new HttpPost("http://10.162.205.175:9200/data_upload_assignment/assignment/_bulk");
		
		StringBuilder sb = new StringBuilder();                                          // create a builder to store 
		
		for (String line = b.readLine(); line != null; line = b.readLine()) 
		{
		
			sb.append(line+"\n");		
			
		}
		
		String str = sb.toString();
		
		StringEntity params = new StringEntity(str);

		request.addHeader("content-type", "application/json");

		request.setEntity(params);
		
		org.apache.http.HttpResponse response = httpClient.execute(request);
		
		System.out.println("RESP----" + response);
		
		f.close();
	}
}