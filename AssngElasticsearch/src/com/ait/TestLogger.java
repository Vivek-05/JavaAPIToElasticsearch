package com.ait;

import org.apache.log4j.BasicConfigurator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TestLogger {		
	
	 private static final Logger logger = LogManager.getLogger("Test");
	    
	    public static void main(String[] args) {
	    	
	    	BasicConfigurator.configure();
	        
	        logger.info("Hello ElasticSearch !");
	        
	    }
	}