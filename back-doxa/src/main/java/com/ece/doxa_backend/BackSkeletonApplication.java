package com.ece.doxa_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.ece.doxa_backend.DAO")
@EntityScan("com.ece.doxa_backend.models")
@ComponentScan("com.ece.doxa_backend.services")
public class BackSkeletonApplication {

	public static void main(final String[] args) {
		SpringApplication.run(BackSkeletonApplication.class, args);
	}

}
