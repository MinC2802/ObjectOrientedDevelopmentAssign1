package com.gadgetstore.entities;

public class Gadget extends Product{

    public String brand;
    public Gadget(String productId, String name, String description, double price, int stock, String category, String brand) {
        super(productId, name, description, price, stock, category);
        this.brand = brand;
    }
    
    // Getters and setters with validation
    public String getBrand(){ return brand; }
    public synchronized void setBrand(String brand) { this.brand = brand; }

    
    @Override
    public String toString() {
        return String.format("Gadget{productId='%s', name='%s', description='%s', price=%.2f, stock=%d, category='%s'}",
                            productId, name, description, price, stock, category, brand);
    }
}
