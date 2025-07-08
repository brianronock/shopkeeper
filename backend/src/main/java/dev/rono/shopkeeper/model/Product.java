/**
 * Product.java
 * Fields: id, name, price, quantity
 * Methods: getId, setId, getName, setName, getPrice, setPrice, getQuantity, setQuantity
 * @author Rono
 * @version 1.0
 * @since 2025-07-07
 */

package dev.rono.shopkeeper.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Product.java
 * This class represents a product entity in the Shopkeeper application.
 * It contains fields for product details such as ID, name, price, and quantity.
 * The class is annotated with JPA annotations for persistence and validation annotations for data integrity.
 */

@Entity
@Table(name = "products")
@Schema(description = "Product entity representing an item in inventory")
public class Product {

    @Id // Primary key for the product
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-generated ID
    @Schema(description = "Unique ID of the product", example = "1", hidden = true) // Swagger documentation
    private Long id; // Unique identifier for the product

    @NotBlank(message = "Product name is required") // Ensures the name is not empty
    @Size(max = 100, message = "Name must be less than 100 characters") // Limits the name length
    @Schema(description = "Name of the product", example = "Wireless Mouse") // Swagger documentation
    private String name; // Name of the product

    @NotNull(message = "Price is required") // Ensures the price is not null
    @Positive(message = "Price must be greater than 0") // Ensures the price is positive
    @Schema(description = "Price in EUR", example = "24.99")
    private Double price; // Price of the product in EUR

    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity cannot be negative")
    @Schema(description = "Stock count", example = "25")
    private Integer quantity; // Quantity of the product in stock

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
