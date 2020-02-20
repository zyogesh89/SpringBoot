package com.yogesh.storeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class YStoreServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(YStoreServiceApplication.class);

	public static void main(String[] args) {
		logger.info("store-service Starting");
		SpringApplication.run(YStoreServiceApplication.class, args);
	}

}
