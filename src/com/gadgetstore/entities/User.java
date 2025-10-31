package com.gadgetstore.entities;

import java.util.UUID;

/** Abstract base class for all users in the system */

public abstract class User {
    // Protected classes for base class (userId, name, email, password)
    protected String userId;
    protected String name;
    protected String email;
    protected String passwordHash;

    // Constructor
    public User(String name, String email, String password) {
        // Assigns userId using java util
        this.userId = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.passwordHash = password;
    }

    // Abstract method - must be implemented by subclasses
    public abstract String getRole();

    // Getters and setters with validation
    public String getUserId() { return userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) {
        this.email = email;
    }

    //Business methods
    public boolean validatePassword(String password) {
        // TODO : include logic for reduce stock
        return false;
    }

    public void changePassword(String oldPassword, String newPassword) {
        // TODO : include logic for reduce stock
    }

    @Override
    public String toString() {
        return String.format("User{userId='%s', name='%s', email='%s', role='%s'}", userId, name, email, getRole());
    }
}