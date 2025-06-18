package com.project.product_service.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.project.product_service.model.Product;

/**
 * Repository interface for performing CRUD operations on Product documents.
 * 
 * This interface extends Spring Data's {@link MongoRepository}, giving access
 * to common MongoDB operations like save, findAll, findById, deleteById, etc.
 * 
 * The two generic parameters:
 * - Product: The type of the domain/entity to manage.
 * - String: The type of the ID field (which is String in the Product model).
 */
public interface ProductRepository extends MongoRepository<Product, String> {

    // You can define custom query methods here if needed, for example:
    // List<Product> findByName(String name);
}
