/**
 * ProductController.java
 * Fields: productRepository
 * Methods: getAllProducts, createProduct, getProductById, updateProduct, deleteProduct
 * @author Rono
 * @version 1.0
 * @since 2025-07-07
 */

package dev.rono.shopkeeper.controller;

import dev.rono.shopkeeper.model.Product;
import dev.rono.shopkeeper.repository.ProductRepository;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * This class is part of the Shopkeeper application, which is an inventory management system.
 * It provides functionality to manage products, including adding, updating, and retrieving product details.
 * The ProductController class is annotated with @RestController to indicate that it handles HTTP requests.
 * It uses @RequestMapping to define the base URL for all endpoints in this controller.
 * The controller interacts with the ProductRepository to perform CRUD operations on Product entities.
 */
@RestController
@RequestMapping("/api/products")
@Tag(name = "Products", description = "Endpoints for managing products")
public class ProductController {


    /**
    * Repository for product data access
    *  This repository is used to perform CRUD operations on Product entities.
    *  It is injected into the controller via constructor injection.
    */
    private final ProductRepository productRepository;

    /**
     * Constructor for ProductController.
     * Initializes the controller with the ProductRepository.
     * @param productRepository Repository for product data access
     */
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Endpoint to get all products in the inventory.
     * This method retrieves a list of all products stored in the database.
     * @return List of all products
     */
    @GetMapping
    @Operation(summary = "Get all products", description = "Returns a list of all products in the inventory")
    @ApiResponse(responseCode = "200", description = "List of products returned")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    /**
     * Endpoint to create a new product.
     * This method saves a new product to the inventory.
     * It accepts a Product object in the request body and returns the created product.
     * @param product The product to be created
     * @return The created product with status 201 Created
     */
    @PostMapping
    @Operation(summary = "Add a new product", description = "Creates a new product and saves it to the inventory")
    @ApiResponse(responseCode = "201", description = "Product successfully created")
    public ResponseEntity<Product> createProduct(@Valid @RequestBody Product product) { // Endpoint to create a new product
        Product savedProduct = productRepository.save(product);
        return ResponseEntity.status(201).body(savedProduct);
    }

    /**
     * Endpoint to retrieve a product by its ID.
     * This method fetches a specific product from the inventory based on its ID.
     * It returns the product if found, or a 404 Not Found response if it does not exist.
     * @param id The ID of the product to retrieve
     * @return The product with the specified ID, or 404 Not Found if it does not exist
     */
    @GetMapping("/{id}")
    @Operation(summary = "Get a product by ID", description = "Retrieves a specific product by its ID")
    @ApiResponse(responseCode = "200", description = "Product found")
    @ApiResponse(responseCode = "404", description = "Product not found")
    public ResponseEntity<Product> getProductById(@PathVariable Long id) { // Endpoint to retrieve a product by its ID
        Optional<Product> product = productRepository.findById(id);
        return product.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    /**
     * Endpoint to update an existing product.
     * This method updates the details of a product identified by its ID.
     * It accepts a Product object in the request body and returns the updated product.
     * @param id The ID of the product to update
     * @param updatedProduct The updated product details
     * @return The updated product with status 200 OK, or 404 Not Found if the product does not exist
     */
    @PutMapping("/{id}")
    @Operation(summary = "Update a product", description = "Updates an existing product by ID")
    @ApiResponse(responseCode = "200", description = "Product successfully updated")
    @ApiResponse(responseCode = "404", description = "Product not found")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @Valid @RequestBody Product updatedProduct) { // Endpoint to update an existing product
        return productRepository.findById(id).map(existingProduct -> {
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setQuantity(updatedProduct.getQuantity());
            productRepository.save(existingProduct);
            return ResponseEntity.ok(existingProduct);
        }).orElse(ResponseEntity.notFound().build());
    }

    /**
     * Endpoint to delete a product by its ID.
     * This method removes a product from the inventory based on its ID.
     * It returns a 204 No Content response if the deletion is successful, or a 404 Not Found if the product does not exist.
     * @param id The ID of the product to delete
     * @return 204 No Content if deleted successfully, or 404 Not Found if the product does not exist
     */
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a product", description = "Deletes a product by its ID")
    @ApiResponse(responseCode = "204", description = "Product successfully deleted")
    @ApiResponse(responseCode = "404", description = "Product not found")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<ResponseEntity<Void>> response = productRepository.findById(id)
                .map(product -> {
                    productRepository.delete(product);
                    return ResponseEntity.noContent().build();
                });

        return response.orElse(ResponseEntity.notFound().build());
    }
}
