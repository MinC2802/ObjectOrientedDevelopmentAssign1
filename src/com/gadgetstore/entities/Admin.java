package com.gadgetstore.entities;

public class Admin extends User {

    // attributes: adminLevel
    private String adminLevel;

    // Constructor
    public Admin(String name, String email, String password, String adminLevel) {
        // Inherits name email password
        super(name, email, password);
        this.adminLevel = adminLevel;
    }

    @Override
    public String getRole() { return "ADMIN"; }

    // Getter and Setter
    public String getAdminLevel() { return adminLevel; }
    public void setAdminLevel(String adminLevel) { this.adminLevel = adminLevel; }

    @Override
    public String toString() {
        return String.format("Admin{userId='%s', name='%s', email='%s', level='%s'}", userId, name, email, adminLevel);
    }

    // Business methods
    public void reduceStock(int quantity, int stock) {}
        // TODO : include logic for reduce stock


    public void addStock(int quantity, int stock) {}
        // TODO : include logic for reduce stock
}