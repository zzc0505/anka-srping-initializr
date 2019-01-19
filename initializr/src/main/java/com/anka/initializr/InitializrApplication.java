package com.anka.initializr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.spring.initializr.metadata.InitializrMetadata;
import io.spring.initializr.metadata.InitializrMetadataBuilder;
import io.spring.initializr.metadata.InitializrMetadataProvider;
import io.spring.initializr.metadata.InitializrProperties;
import io.spring.initializr.metadata.SimpleInitializrMetadataProvider;

@SpringBootApplication
public class InitializrApplication {

	public static void main(String[] args) {
		SpringApplication.run(InitializrApplication.class, args);
	}

	/**
     * 去除自动去spring-boot官网拉取最新版本
     */
    @Bean
    public InitializrMetadataProvider initializrMetadataProvider(
            InitializrProperties properties) {
        InitializrMetadata metadata = InitializrMetadataBuilder
                .fromInitializrProperties(properties).build();
        return new SimpleInitializrMetadataProvider(metadata);
    }
}

