package com.project.product_service.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for sending product details in API responses.
 * 
 * This class is typically returned by the service/controller layer to the
 * client,
 * representing the product data in a safe, consistent, and formatted structure.
 * It avoids exposing internal entity details directly.
 */
@Data // Lombok: auto-generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Lombok: generates a no-argument constructor
@AllArgsConstructor // Lombok: generates a constructor with all fields
@Builder // Lombok: enables fluent builder-style object creation
public class ProductResponse {

    /**
     * Unique identifier of the product.
     */
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
     * Price of the product.
     * BigDecimal is used for accuracy in monetary values.
     */
    private BigDecimal price;
}
