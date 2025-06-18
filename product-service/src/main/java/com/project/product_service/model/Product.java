package com.project.product_service.model;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents a Product entity stored in the MongoDB database.
 * 
 * This class is annotated with Spring Data and Lombok annotations to reduce
 * boilerplate code and enable easy mapping to the MongoDB collection.
 * 
 * MongoDB Collection: "product"
 */
@Document(value = "product") // Maps this class to the "product" collection in MongoDB
@AllArgsConstructor // Generates a constructor with all fields
@NoArgsConstructor // Generates a no-argument constructor
@Builder // Enables the Builder pattern for object creation
@Data // Generates getters, setters, toString, equals, and hashCode methods
public class Product {

    /**
     * Unique identifier for the product.
     * Marked as @Id so Spring Data MongoDB treats it as the primary key.
     */
    @Id
    private String id;

    /**
     * Name of the product.
     */
    private String name;

    /**
     * Detailed description of the product.
     */
    private String description;

    /**
     * Price of the product represented using BigDecimal for precision.
     */
    private BigDecimal price;
}
