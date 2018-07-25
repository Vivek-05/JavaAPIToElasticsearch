package com.ait.http;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ParseJson {
	
	public static void readLine(File inputfile, File outputfile) throws IOException {
		int counter=1;
		FileReader file=new FileReader(inputfile);
		PrintWriter pw=new PrintWriter(outputfile);
		BufferedReader br= new BufferedReader(file);
		String line;
		while((line=br.readLine())!=null){
			Scanner sc=new Scanner(line);
			pw.print("{");
			pw.print("id:"+counter+",");
			pw.print("Level:"+"\""+sc.next()+"\""+",");
			pw.print("Package:"+"\""+sc.next()+"\""+",");
			String temp="";
			while(sc.hasNext())                                    // only for message
			{
				temp=temp+sc.next()+" ";
			}
			//temp = temp.substring(0, temp.length());
			pw.print("Message:"+"\""+temp+"\"");
			pw.print("}");
			pw.println();
			counter++;
			sc.close();
		}
		file.close();
		br.close();
		pw.close();
	}
	
	public static void main(String[] args) {
		File inputfile=new File("D:\\Copy.log");
		File outputfile=new File("D:\\OutputLog.log");
		try {
			readLine(inputfile,outputfile);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}