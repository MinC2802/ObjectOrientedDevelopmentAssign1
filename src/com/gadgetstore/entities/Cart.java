package com.gadgetstore.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a shopping cart containing multiple CartItems.
 * Demonstrates composition and encapsulation.
 */
public class Cart {
    private String cartId;
    private List<CartItem> cartItems;

    public Cart(String cartId) {
        this.cartId = cartId;
        this.cartItems = new ArrayList<>();
    }

    public String getCartId() { return cartId; }
    public List<CartItem> getCartItems() { return new ArrayList<>(cartItems); }

    public void addItem(Product product, int quantity) {
        if (product == null || quantity <= 0) return;
        for (CartItem item : cartItems) {
            if (item.getProduct().getProductId().equals(product.getProductId())) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        cartItems.add(new CartItem(product, quantity));
    }

    public void removeItem(String productId) {
        cartItems.removeIf(item -> item.getProduct().getProductId().equals(productId));
    }

    public void clearCart() {
        cartItems.clear();
    }

    public double calculateTotal() {
        return cartItems.stream()
                .mapToDouble(CartItem::getSubtotal)
                .sum();
    }

    public void reviewCart() {
        System.out.println("\n=== CART CONTENTS ===");
        for (int i = 0; i < cartItems.size(); i++) {
            System.out.println((i + 1) + ". " + cartItems.get(i));
        }
        System.out.println("Total: $" + String.format("%.2f", calculateTotal()));
    }
}
