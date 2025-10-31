package com.gadgetstore.services;

import java.util.*;
import com.gadgetstore.entities.*;

public class CustomerManagement {
    private Map<String, Customer> customers;
    private Map<String, Product> products;
    
    public CustomerManagement() {
        this.customers = new HashMap<>();
        this.products = new HashMap<>();
    }
    
    
    // Product management
    public void addProduct(Product product) {
        //TODO : logic for system to add product
    }
    
    public void editProduct(String productId) {
        //TODO : logic for system to edit product
    }
    
    // Order management
    public void placeOrder(String customerId) {
       //TODO : logic for making an order for customer
    }

    public void viewOrder(String customerId) {
       //TODO : logic for viewing an order for customer
    }
}