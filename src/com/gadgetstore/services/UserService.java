package com.gadgetstore.services;

import com.gadgetstore.entities.Admin;
import com.gadgetstore.entities.Customer;
import com.gadgetstore.entities.User;
import com.gadgetstore.exceptions.AuthenticationException;
import java.util.HashMap;
import java.util.Map;

/**
 * UserService managing user authentication and registration
 */
public class UserService {
    private static UserService instance;
    private Map<String, User> users; // Key: email, Value: User object
    private User currentUser;
    
    private UserService() {
        users = new HashMap<>();
        initializeSampleUsers();
    }
    
    public static synchronized UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }
    
    private void initializeSampleUsers() {
        // Add sample admin
        Admin admin = new Admin("System Admin", "admin@gadgetstore.com", "admin123", "Super");
        users.put(admin.getEmail(), admin);
        
        // Add sample customers
        Customer customer1 = new Customer("John Doe", "john@email.com", "password123", "123-456-7890", "123 Main St");
        Customer customer2 = new Customer("Jane Smith", "jane@email.com", "password456", "098-765-4321", "456 Oak Ave");
        
        users.put(customer1.getEmail(), customer1);
        users.put(customer2.getEmail(), customer2);
    }
    
    public User registerCustomer(String name, String email, String password, 
                               String phoneNumber, String address) {
        
        if (users.containsKey(email)) {
            throw new IllegalArgumentException("Email already registered: " + email);
        }
        
        Customer customer = new Customer(name, email, password, phoneNumber, address);
        users.put(email, customer);
        return customer;
    }
    
    public User login(String email, String password) throws AuthenticationException {
        User user = users.get(email);
        if (user == null) {
            throw new AuthenticationException("User not found with email: " + email);
        }
        
        if (!user.validatePassword(password)) {
            throw new AuthenticationException("Invalid password");
        }
        
        currentUser = user;
        return user;
    }
    
    public void logout() {
        currentUser = null;
    }
    
    public User getCurrentUser() {
        return currentUser;
    }
    
    public boolean isLoggedIn() {
        return currentUser != null;
    }
    
    public boolean isAdmin() {
        return currentUser instanceof Admin;
    }
    
    public boolean isCustomer() {
        return currentUser instanceof Customer;
    }
    
    public Customer getCurrentCustomer() {
        return isCustomer() ? (Customer) currentUser : null;
    }
    
    public void updateUserProfile(String name, String email, String phoneNumber, String address) {
        if (!isLoggedIn()) {
            throw new IllegalStateException("No user logged in");
        }
        
        if (name != null && !name.trim().isEmpty()) {
            currentUser.setName(name);
        }
        
        if (email != null && !email.trim().isEmpty()) {
            currentUser.setEmail(email);
        }
        
        if (currentUser instanceof Customer customer) {
            if (phoneNumber != null && !phoneNumber.trim().isEmpty()) {
                customer.setPhoneNumber(phoneNumber);
            }
            if (address != null && !address.trim().isEmpty()) {
                customer.setAddress(address);
            }
        }
    }
    
    public void changePassword(String oldPassword, String newPassword) {
        if (!isLoggedIn()) {
            throw new IllegalStateException("No user logged in");
        }
        
        currentUser.changePassword(oldPassword, newPassword);
    }
}