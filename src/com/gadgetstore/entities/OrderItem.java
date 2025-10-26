package com.gadgetstore.entities;

/**
 * OrderItem class representing individual items in an order
 * Demonstrates composition
 */
public class OrderItem {
    private Product product;
    private int quantity;
    
    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    // Getters and setters with validation
    public Product getProduct() { return product; }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { 
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        this.quantity = quantity; 
    }
    
    public double getItemTotal() {
        return product.getPrice() * quantity;
    }
    
    @Override
    public String toString() {
        return String.format("%s x%d - $%.2f", product.getName(), quantity, getItemTotal());
    }
}