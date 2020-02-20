package com.yogesh.eurekaservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServiceApplication {

	private static final Logger logger = LoggerFactory.getLogger(EurekaServiceApplication.class);

	public static void main(String[] args) {
		logger.info("eureka-service Starting ");
		SpringApplication.run(EurekaServiceApplication.class, args);
	}

}
