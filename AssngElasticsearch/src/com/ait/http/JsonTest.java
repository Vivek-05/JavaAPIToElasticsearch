package com.ait.http;

import java.io.*;

import com.fasterxml.jackson.databind.*;

public class JsonTest {
	
    public static void main(String[] args) {
        String logFilename = "C://Users/Vivek/Desktop/Copy.log";
        String line, json = "";
       
        try (BufferedReader br = new BufferedReader(new FileReader(logFilename))) {
        	
            while ((line = br.readLine()) != null) {
            	
                //if (isLogLine(line)) {
                	
                    if (!json.isEmpty()) {
                        parseJson(json);
                        json = "";
                        System.out.println(line);
                    }
                 /*else {
                    json += line;
                }*/
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isLogLine(String line) {
        return line.matches(" ");
    }

    public static void parseJson(String json) throws Exception {
        if (!json.startsWith("{") && !json.endsWith("}")) json = "{" + json + "}";
        ObjectMapper om = new ObjectMapper();
        System.out.println(om.readValue(fixJson(json), Object.class));
    }
    public static String fixJson(String json) {
        return "{" + json.replace("}]", "}}]") + "}";
    }
}