package com.gadgetstore.entities;

/**
 * Represents a single product entry within a Cart.
 * Demonstrates composition and encapsulation.
 */
public class CartItem {
    private Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }

    public void setQuantity(int newQuantity) {
        if (newQuantity > 0) this.quantity = newQuantity;
    }

    public double getSubtotal() {
        return quantity * product.getPrice();
    }

    @Override
    public String toString() {
        return product.getName() + " x" + quantity + " ($" + String.format("%.2f", getSubtotal()) + ")";
    }
}
