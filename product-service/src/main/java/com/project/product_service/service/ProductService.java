package com.project.product_service.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.product_service.dto.ProductRequest;
import com.project.product_service.dto.ProductResponse;
import com.project.product_service.model.Product;
import com.project.product_service.repository.ProductRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Service layer class responsible for handling business logic
 * related to product operations.
 * 
 * This class interacts with the ProductRepository to perform
 * CRUD operations and maps entities to DTOs.
 */
@Service
@RequiredArgsConstructor // Lombok: generates constructor for final fields
@Slf4j // Lombok: enables logging via SLF4J
public class ProductService {

    private final ProductRepository productRepository;

    /**
     * Creates and saves a new product using the data provided
     * in the ProductRequest DTO.
     *
     * @param productRequest The incoming product details from the client.
     */
    public void createProduct(ProductRequest productRequest) {
        // Map request DTO to Product entity
        Product product = Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();

        // Save product to the database
        productRepository.save(product);

        // Log the operation
        log.info("Product {} is saved", product.getId());
    }

    /**
     * Retrieves all products from the database and maps them to ProductResponse
     * DTOs.
     *
     * @return List of ProductResponse representing all stored products.
     */
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();

        // Convert each Product entity to a ProductResponse DTO
        return products.stream()
                .map(this::mapToProductResponse)
                .toList();
    }

    /**
     * Helper method to map a Product entity to a ProductResponse DTO.
     *
     * @param product The Product entity to convert.
     * @return A ProductResponse DTO with mapped fields.
     */
    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
