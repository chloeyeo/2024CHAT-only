package com.project.mhnbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.project.mhnbackend.repository")
@EnableMongoRepositories(basePackages = "com.project.mhnbackend.mongo.repository")
@EntityScan(basePackages = "com.project.mhnbackend.domain")
public class MhnbackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MhnbackendApplication.class, args);
	}

}
