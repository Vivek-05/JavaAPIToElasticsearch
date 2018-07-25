package com.ait.http;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

public class PostMethodClass {

	public static void main(String[] args) {
		String output = getUrlContents("http://10.162.205.175:9200/data_upload_assignment/_search");
		System.out.println(output);
	}

	private static String getUrlContents(String theUrl) {
		StringBuilder content = new StringBuilder();
		try {

			URL url = new URL("http://10.162.205.175:9200/data_upload_assignment/assignment/1");

			URLConnection urlConnection = url.openConnection();

			FileInputStream f = new FileInputStream("C:\\Users\\Vivek\\Desktop\\Copy.txt");

			@SuppressWarnings({ "unused", "resource" })
			BufferedReader b = new BufferedReader(new InputStreamReader(f));

			urlConnection.setDoOutput(true);


			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

			String line;

			while ((line = bufferedReader.readLine()) != null) {
				content.append(line + "\n");
				
				OutputStreamWriter wr = new OutputStreamWriter(urlConnection.getOutputStream());
				wr.write(line);
				wr.flush();
			}
			bufferedReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content.toString();
	}
}
