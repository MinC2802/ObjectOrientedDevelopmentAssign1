package com.gadgetstore.services;

import java.util.*;
import java.util.stream.Collectors;
import com.gadgetstore.entities.*;

public class CustomerManagement {
    private Map<String, Customer> customers;
    private Map<String, Product> products;
    
    public CustomerManagement() {
        this.customers = new HashMap<>();
        this.products = new HashMap<>();
    }
    
    // Customer CRUD operations
    public void addCustomer(Customer customer) {
        //TODO : implement logic to add customer
    }
    
    public void Customer(String userId) {
        //TODO : logic for system to find customer
    }
    
    public void updateCustomer(String userId, Customer updatedCustomer) {
        //TODO : logic for system to update customer details
    }
    
    public void removeCustomer(String userId) {
        //TODO : logic for system to update customer details
    }
    
    // Product management
    public void addProduct(Product product) {
        //TODO : logic for system to add product
    }
    
    public void Product(String productId) {
        //TODO : logic for system to edit product
    }
    
    // Order management
    public void placeOrder(String customerId) {
       //TODO : logic for making an order for customer
    }
}