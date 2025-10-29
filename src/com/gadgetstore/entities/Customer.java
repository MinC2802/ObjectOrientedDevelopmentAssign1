package com.gadgetstore.entities;

import java.util.ArrayList;
import java.util.List;

/** Customer class extending User */
public class Customer extends User {
    private String phoneNumber;
    private String address;
    private List<Order> orderHistory;
    
    // Constructor
    public Customer(String name, String email, String password, String phoneNumber, String address) {
        
        super(name, email, password);
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.orderHistory = new ArrayList<>();
    }
    
    @Override
    public String getRole() {
        return "CUSTOMER";
    }
    
    // Getters and setters
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    
    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }
    
    public List<Order> getOrderHistory() { return new ArrayList<>(orderHistory); } // Defensive copy
    
    // Business methods
    public void addOrder(Order order) {
        if (order != null) {
            orderHistory.add(order);
        }
    }
    
    public void viewOrderHistory() {
        if (orderHistory.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }
        
        System.out.println("\n=== ORDER HISTORY ===");
        for (int i = 0; i < orderHistory.size(); i++) {
            System.out.println((i + 1) + ". " + orderHistory.get(i).getOrderSummary());
        }
    }
    
    @Override
    public String toString() {
        return String.format("Customer{userId='%s', name='%s', email='%s', phone='%s', orders=%d}", userId, name, email, phoneNumber, orderHistory.size());
    }
}