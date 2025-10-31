package com.gadgetstore.entities;

// Represents a single product entry within a Cart.

public class CartItem {
    // attributes : productId, quantity
    private String productId;
    private int quantity;

    // Constructor
    public CartItem() {}

    public CartItem(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    // Getters and Setter
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    // Business Methods
    public void updateQuantity(int newQuantity) {}
    public double calculateSubtotal(int quantity, double price) { return quantity * price; }
}
