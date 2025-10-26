package com.gadgetstore.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Order class representing customer orders
 * Demonstrates composition and aggregation
 */
public class Order {
    private String orderId;
    private String customerId;
    private LocalDateTime orderDate;
    private OrderStatus status;
    private List<OrderItem> items;
    private double totalAmount;
    
    public enum OrderStatus {
        PENDING, CONFIRMED, SHIPPED, DELIVERED, CANCELLED
    }
    
    public Order(String orderId, String customerId) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.orderDate = LocalDateTime.now();
        this.status = OrderStatus.PENDING;
        this.items = new ArrayList<>();
        this.totalAmount = 0.0;
    }
    
    // Getters
    public String getOrderId() { return orderId; }
    public String getCustomerId() { return customerId; }
    public LocalDateTime getOrderDate() { return orderDate; }
    public OrderStatus getStatus() { return status; }
    public List<OrderItem> getItems() { return new ArrayList<>(items); } // Defensive copy
    public double getTotalAmount() { return totalAmount; }
    
    // Business methods
    public void addItem(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        
        // Check if product already exists in order
        for (OrderItem item : items) {
            if (item.getProduct().getProductId().equals(product.getProductId())) {
                item.setQuantity(item.getQuantity() + quantity);
                recalculateTotal();
                return;
            }
        }
        
        // Add new item
        OrderItem newItem = new OrderItem(product, quantity);
        items.add(newItem);
        recalculateTotal();
    }
    
    public void removeItem(String productId) {
        items.removeIf(item -> item.getProduct().getProductId().equals(productId));
        recalculateTotal();
    }
    
    public void updateStatus(OrderStatus newStatus) {
        this.status = newStatus;
    }
    
    private void recalculateTotal() {
        totalAmount = items.stream()
                .mapToDouble(OrderItem::getItemTotal)
                .sum();
    }
    
    public String getOrderSummary() {
        return String.format("Order#%s | Date: %s | Status: %s | Total: $%.2f | Items: %d",
                           orderId, orderDate.toLocalDate(), status, totalAmount, items.size());
    }
    
    public void displayOrderDetails() {
        System.out.println("\n=== ORDER DETAILS ===");
        System.out.println("Order ID: " + orderId);
        System.out.println("Date: " + orderDate);
        System.out.println("Status: " + status);
        System.out.println("Items:");
        
        for (int i = 0; i < items.size(); i++) {
            System.out.println("  " + (i + 1) + ". " + items.get(i));
        }
        
        System.out.println("Total Amount: $" + String.format("%.2f", totalAmount));
    }
}