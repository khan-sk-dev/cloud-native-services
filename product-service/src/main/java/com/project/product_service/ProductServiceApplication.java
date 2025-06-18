package com.project.product_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point for the Product Service Spring Boot application.
 * 
 * The @SpringBootApplication annotation enables:
 * - Component scanning (@Component, @Service, @Repository, etc.)
 * - Auto-configuration
 * - Spring Boot configuration features
 */
@SpringBootApplication
public class ProductServiceApplication {

	/**
	 * The main method that launches the Spring Boot application.
	 *
	 * @param args Command-line arguments passed at runtime.
	 */
	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}
}
