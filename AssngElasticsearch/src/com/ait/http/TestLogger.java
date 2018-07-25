package com.ait.http;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class TestLogger {
	
		 public static void main(String[] args) throws Exception {

		FileInputStream f = new FileInputStream("C:\\Users\\Vivek\\Desktop\\Copy.txt");

		BufferedReader b = new BufferedReader(new InputStreamReader(f));

		String str;

		while((str=b.readLine())!=null)
		{

			f.close();
		}	
		/*CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		
		try {
		    HttpPost req = new HttpPost("http://10.162.205.175:9200/data_upload_assignment/_PUT");
		    
		    StringEntity params = new StringEntity(str);
		    
		    req.addHeader("content-type", "application/json");
		    
		    req.setEntity(params);
		    
		    httpClient.execute(req);*/
		    System.out.println(str);
		} 
	}