package com.gadgetstore.entities;

/**
 * Admin class extending User
 * Demonstrates inheritance
 */
public class Admin extends User {
    private String adminLevel;
    
    public Admin(String name, String email, String password, String adminLevel) {
        super(name, email, password);
        this.adminLevel = adminLevel;
    }
    
    @Override
    public String getRole() {
        return "ADMIN";
    }
    
    public String getAdminLevel() { return adminLevel; }
    public void setAdminLevel(String adminLevel) { this.adminLevel = adminLevel; }
    
    @Override
    public String toString() {
        return String.format("Admin{userId='%s', name='%s', email='%s', level='%s'}", 
                           userId, name, email, adminLevel);
    }
}