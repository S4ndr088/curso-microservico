package com.curso.hreurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class HrEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrEurekaServiceApplication.class, args);
	}

}
