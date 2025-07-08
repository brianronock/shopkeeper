/**
 * ProductRepository.java
 * Fields: None
 * Methods: None
 * @author Rono
 * @version 1.0
 * @since 2025-07-07
 */

package dev.rono.shopkeeper.repository;

import dev.rono.shopkeeper.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/** This interface is part of the Shopkeeper application, which is an inventory management system.
 * It provides functionality to manage products, including adding, updating, and retrieving product details.
 * The ProductRepository interface is annotated with @Repository to indicate that it is a Spring Data repository.
 * It extends JpaRepository, which provides methods for standard CRUD operations.
 */
@Repository // Indicates that this interface is a Spring Data repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
