package com.project.product_service.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.project.product_service.dto.ProductRequest;
import com.project.product_service.dto.ProductResponse;
import com.project.product_service.service.ProductService;

import lombok.RequiredArgsConstructor;

/**
 * REST controller for managing product-related operations.
 * 
 * Exposes endpoints for creating and retrieving product data.
 * Routes all requests under "/api/product".
 */
@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor // Lombok: Injects final fields via constructor
public class ProductController {

    /**
     * Service layer to handle business logic related to products.
     */
    private final ProductService productService;

    /**
     * Endpoint to create a new product.
     * 
     * @param productRequest - DTO containing product details from client.
     * @return void (HTTP 201 Created on success)
     */
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    /**
     * Endpoint to fetch all available products.
     * 
     * @return List of ProductResponse objects.
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductResponse> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * (Optional / Commented)
     * Endpoint to fetch a single product by its ID.
     * 
     * @param id - The ID of the product to retrieve.
     * @return ProductResponse containing product details.
     */
    // @GetMapping("/{id}")
    // @ResponseStatus(HttpStatus.OK)
    // public ProductResponse getProductById(@PathVariable String id) {
    // return productService.getProductById(id);
    // }
}
