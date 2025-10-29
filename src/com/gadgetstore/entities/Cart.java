package com.gadgetstore.entities;

import java.util.ArrayList;
import java.util.List;

/** Cart class to store items temporarily */

public class Cart {
    private String cartId;
    private List<CartItem> cartItems = new ArrayList<>();

    // Constructor (default)
    public Cart() {}

    // Constructor (creation)
    public Cart(String cartId) {
        this.cartId = cartId;
    }

    public String getCartId() { return cartId; }
    public void setCartId(String cartId) { this.cartId = cartId; }

    public List<CartItem> getCartItems() { return cartItems; }
    public void setCartItems(List<CartItem> cartItems) { this.cartItems = cartItems; }

    public void addItem(String productId, int quantity) {}
    public void removeItem(String cartItemId) {}
    public double calculateTotal() { return 0; }
    public void reviewCart() {}
    public void clearCart() {}
}

