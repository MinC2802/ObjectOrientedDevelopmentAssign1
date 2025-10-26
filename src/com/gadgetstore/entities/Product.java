package com.gadgetstore.entities;

/**
 * Product class representing gadgets in the store
 * Demonstrates encapsulation
 */
public class Product {
    private String productId;
    private String name;
    private String description;
    private double price;
    private int stockQuantity;
    private String category;
    private String brand;
    
    public Product(String productId, String name, String description, double price, 
                  int stockQuantity, String category, String brand) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
        this.brand = brand;
    }
    
    // Getters and setters with validation
    public String getProductId() { return productId; }
    
    public String getName() { return name; }
    public void setName(String name) { 
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        this.name = name; 
    }
    
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { 
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price; 
    }
    
    public int getStockQuantity() { return stockQuantity; }
    public void setStockQuantity(int stockQuantity) { 
        if (stockQuantity < 0) {
            throw new IllegalArgumentException("Stock quantity cannot be negative");
        }
        this.stockQuantity = stockQuantity; 
    }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }
    
    // Business methods
    public void reduceStock(int quantity) {
        if (quantity > stockQuantity) {
            throw new IllegalArgumentException("Insufficient stock");
        }
        stockQuantity -= quantity;
    }
    
    public void addStock(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity to add cannot be negative");
        }
        stockQuantity += quantity;
    }
    
    public boolean isInStock() {
        return stockQuantity > 0;
    }
    
    @Override
    public String toString() {
        return String.format("Product{id='%s', name='%s', brand='%s', price=%.2f, stock=%d}", 
                           productId, name, brand, price, stockQuantity);
    }
    
    public String getDetailedInfo() {
        return String.format(
            "Product ID: %s\nName: %s\nBrand: %s\nCategory: %s\nPrice: $%.2f\nStock: %d\nDescription: %s",
            productId, name, brand, category, price, stockQuantity, description
        );
    }
}