package com.project.product_service.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Builder;

/**
 * Data Transfer Object (DTO) used to receive product creation or update
 * requests.
 * 
 * This class is typically used in API request bodies when creating a new
 * product
 * or updating an existing one. It is decoupled from the internal database
 * entity (`Product`)
 * for better abstraction and API layer flexibility.
 */
@Data // Lombok: generates getters, setters, toString, equals, and hashCode methods
@AllArgsConstructor // Lombok: generates a constructor with all fields
@NoArgsConstructor // Lombok: generates a no-argument constructor
@Builder
public class ProductRequest {

    /**
     * Name of the product to be created or updated.
     */
    private String name;

    /**
     * Description providing details about the product.
     */
    private String description;

    /**
     * Price of the product.
     * BigDecimal is used for accurate financial calculations.
     */
    private BigDecimal price;

}
