package com.ece.doxa_backend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.ece.doxa_backend.repositories")
public class JpaConfig {
}
