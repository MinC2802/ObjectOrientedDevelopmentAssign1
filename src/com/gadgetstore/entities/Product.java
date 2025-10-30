package com.gadgetstore.entities;

public class Product {

    // Private attributes (id, name, desc, price, stock, category)
    protected String productId;
    protected String name;
    protected String description;
    protected double price;
    protected int stock;
    protected String category;

    // Constructor (default)

    public Product(String productId, String name, String description, double price, int stock, String category) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }
    
    // Getters and setters with validation
    public String getProductId() { return productId; }
    public synchronized void setProductId(String productId) { this.productId = productId; }
    
    public String getName() { return name; }
    public synchronized void setName(String name) { 
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        this.name = name; 
    }
    
    public String getDescription() { return description; }
    public  synchronized void setDescription(String description) { this.description = description; }
    
    public double getPrice() { return price; }
    public synchronized void setPrice(double price) { 
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        this.price = price; 
    }
    
    public int getstock() { return stock; }
    public synchronized void setstock(int stock) { 
        if (stock < 0) {
            throw new IllegalArgumentException("Stock quantity cannot be negative");
        }
        this.stock = stock; 
    }
    
    public String getCategory() { return category; }
    public synchronized void setCategory(String category) { this.category = category; }
    
    // Business methods
    public synchronized void reduceStock(int quantity) {
        if (quantity > stock) {
            throw new IllegalArgumentException("Insufficient stock");
        }
        stock -= quantity;
    }

    public synchronized void addStock(int quantity) {
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity to add cannot be negative");
        }
        stock += quantity;
    }
    
    public boolean isInStock() {
        return stock > 0;
    }
    
    @Override
    public String toString() {
        return String.format("Product{id='%s', name='%s', price=%.2f, stock=%d}",
                             productId, name, price, stock);
    }
    
    public String getDetailedInfo() {
        return String.format(
            "Product ID: %s\nName: %s\nCategory: %s\nPrice: $%.2f\nStock: %d\nDescription: %s",
            productId, name, category, price, stock, description
        );
    }
}