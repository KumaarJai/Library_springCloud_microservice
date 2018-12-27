package com.crystalark.librarymicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class LibraryCloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryCloudConfigServerApplication.class, args);
	}

}

