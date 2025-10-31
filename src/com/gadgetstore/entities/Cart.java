package com.gadgetstore.entities;

import java.util.ArrayList;
import java.util.List;

// Represents a shopping cart containing multiple CartItems.

public class Cart {
    // attributes : cartId, cartItems
    private String cartId;
    private List<CartItem> cartItems = new ArrayList<>();

    // Constructor (default)
    public Cart() {}

    // Constructor (creation)
    public Cart(String cartId) { this.cartId = cartId; }

    // Getter and Setter
    public String getCartId() { return cartId; }
    public void setCartId(String cartId) { this.cartId = cartId; }

    public List<CartItem> getCartItems() { return cartItems; }
    public void setCartItems(List<CartItem> cartItems) { this.cartItems = cartItems; }

    // Business Methods
    public void addItem(String productId, int quantity) {}
    //TODO : include logic for add item

    public void removeItem(String cartItemId) {}
    //TODO : include logic for remove item
    
    public double calculateTotal() { return 0; }
    //TODO : include logic to calculate total
    
    public void reviewCart() {}
    //TODO : include logic to review cart details
    
    public void clearCart() {}
    //TODO : include logic to remove all cart items
    
}

