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
    
    // Getters and Setters
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public String getCustomerId() { return customerId; }
    public void setCustomerId(String customerId) { this.customerId = customerId; }

    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }

    public OrderStatus getStatus() { return status; }
    public void setStatus(OrderStatus status) { this.status = status; }

    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    // Placeholder methods (no functionality)
    public void addItem(Product product, int quantity) {
        // Adds an item to the order
    }

    public void removeItem(String productId) {
        // Removes an item from the order
    }

    public void updateStatus(OrderStatus newStatus) {
        // Updates the order status
    }

    private void recalculateTotal() {
        // Recalculates the total amount of the order
    }

    public String getOrderSummary() {
        // Returns a formatted summary of the order
        return null;
    }

    public void displayOrderDetails() {
        // Displays detailed order information
    }
}