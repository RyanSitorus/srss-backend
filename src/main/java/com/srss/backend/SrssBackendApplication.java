package com.srss.backend;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SrssBackendApplication {
	private final static Logger log = LoggerFactory.getLogger(SrssBackendApplication.class);	

	public static void main(String[] args) {
		SpringApplication.run(SrssBackendApplication.class, args);
	}

}
