package com.ece.doxa_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.ece.doxa_backend.repositories")
@SpringBootApplication
public class BackSkeletonApplication {

	public static void main(final String[] args) {
		SpringApplication.run(BackSkeletonApplication.class, args);
	}

}
