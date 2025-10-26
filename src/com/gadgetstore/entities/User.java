package com.gadgetstore.entities;

import java.util.UUID;

/**
 * Abstract base class for all users in the system
 * Demonstrates abstraction and inheritance
 */
public abstract class User {
    protected String userId;
    protected String name;
    protected String email;
    protected String password;
    
    // Constructor
    public User(String name, String email, String password) {
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.password = password;
    }
    
    // Abstract method - must be implemented by subclasses
    public abstract String getRole();
    
    // Getters and setters with validation
    public String getUserId() { return userId; }
    
    public String getName() { return name; }
    public void setName(String name) { 
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty");
        }
        this.name = name; 
    }
    
    public String getEmail() { return email; }
    public void setEmail(String email) { 
        if (email == null || !email.contains("@")) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.email = email; 
    }
    
    public boolean validatePassword(String password) {
        return this.password.equals(password);
    }
    
    public void changePassword(String oldPassword, String newPassword) {
        if (!validatePassword(oldPassword)) {
            throw new IllegalArgumentException("Old password is incorrect");
        }
        if (newPassword == null || newPassword.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }
        this.password = newPassword;
    }
    
    @Override
    public String toString() {
        return String.format("User{userId='%s', name='%s', email='%s', role='%s'}", 
                           userId, name, email, getRole());
    }
}