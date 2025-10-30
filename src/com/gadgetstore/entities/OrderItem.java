package com.gadgetstore.entities;

/**
 * Represents an individual item in an order.
 * Demonstrates composition and encapsulation.
 */
public class OrderItem {
    private Product product;
    private int quantity;

    // Constructors
    public OrderItem() {}

    public OrderItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters and Setters
    public Product getProduct() { return product; }
    public void setProduct(Product product) { this.product = product; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    // Placeholder methods
    public double getItemTotal() {
        // Returns total price for this item
        return 0;
    }

    @Override
    public String toString() {
        // Returns formatted string of product info
        return null;
    }
}