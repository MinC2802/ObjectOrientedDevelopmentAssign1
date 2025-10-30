package com.gadgetstore.entities;

public class Product {

    // Product attributes (id, name, desc, price, stock, category)
    protected String productId;
    protected String name;
    protected String description;
    protected double price;
    protected int stock;
    protected String category;

    /** 
     * Constructor (default) with attributes productId, name, description, price, stock, category
     */

    public Product(String productId, String name, String description, double price, int stock, String category) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.category = category;
    }
    
    /**Getters and setters with validation
     * 
     */
    
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
    
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
    
    public int getStock() { return stock; }
    public void setStock(int stock) { 
        if (stock < 0) {
            throw new IllegalArgumentException("Stock quantity cannot be negative");
        }
        this.stock = stock; 
    }
    
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    
    public boolean checkStock() {
        return stock > 0;
    }
    
    @Override
    public String toString() {
        return String.format("Product{id='%s', name='%s', price=%.2f, stock=%d}",
                             productId, name, price, stock);
    }
    
    public String getDetails() {
        return String.format(
            "Product ID: %s\nName: %s\nCategory: %s\nPrice: $%.2f\nStock: %d\nDescription: %s",
            productId, name, category, price, stock, description
        );
    }
}