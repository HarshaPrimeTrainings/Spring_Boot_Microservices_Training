package com.training.erurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class ErurekaserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ErurekaserviceApplication.class, args);
	}

}
