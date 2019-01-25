package com.crystalark.librarymicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
public class ZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulApiGatewayApplication.class, args);
		
		/*
		 * new URLs through API Gateway would be: 
		 * http://localhost:8765/{application-name}/{uri}
		 * http://localhost:8765/library-service/library-service/login
		*/	
		
		}

}

