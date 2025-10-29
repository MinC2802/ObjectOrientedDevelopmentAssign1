package com.gadgetstore.services;

import com.gadgetstore.entities.Order;
import com.gadgetstore.entities.Product;
import com.gadgetstore.exceptions.InsufficientStockException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * OrderService managing customer orders
 * Demonstrates service layer pattern
 */
public class OrderService {
    private static OrderService instance;
    private Map<String, Order> orders;
    private InventoryService inventoryService;
    private int orderCounter;
    
    private OrderService() {
        orders = new HashMap<>();
        inventoryService = InventoryService.getInstance();
        orderCounter = 1;
    }
    
    public static synchronized OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }
    
    public Order createOrder(String customerId) {
        String orderId = "ORD" + String.format("%06d", orderCounter++);
        Order order = new Order(orderId, customerId);
        orders.put(orderId, order);
        return order;
    }
    
    public void addItemToOrder(Order order, String productId, int quantity) 
            throws InsufficientStockException {
        
        Product product = inventoryService.getProduct(productId);
        if (product == null) {
            throw new IllegalArgumentException("Product not found: " + productId);
        }
        
        if (!inventoryService.checkStock(productId, quantity)) {
            throw new InsufficientStockException(
                String.format("Insufficient stock for %s. Available: %d, Requested: %d",
                            product.getName(), product.getStock(), quantity)
            );
        }
        
        // Add to order and reduce stock
        order.addItem(product, quantity);
        inventoryService.updateStock(productId, -quantity);
    }
    
    public void processOrder(Order order) {
        order.updateStatus(Order.OrderStatus.CONFIRMED);
        System.out.println("Order processed successfully: " + order.getOrderId());
    }
    
    public void cancelOrder(Order order) {
        // Restore stock for cancelled order
        order.getItems().forEach(item -> {
            try {
                inventoryService.updateStock(item.getProduct().getProductId(), item.getQuantity());
            } catch (InsufficientStockException e) {
                // This shouldn't happen for cancellation, but handle gracefully
                System.err.println("Error restoring stock: " + e.getMessage());
            }
        });
        
        order.updateStatus(Order.OrderStatus.CANCELLED);
    }
    
    public Order getOrder(String orderId) {
        return orders.get(orderId);
    }
    
    public List<Order> getCustomerOrders(String customerId) {
        return orders.values().stream()
                .filter(order -> order.getCustomerId().equals(customerId))
                .toList();
    }
}