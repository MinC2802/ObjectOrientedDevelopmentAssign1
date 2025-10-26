package com.gadgetstore.utils;

/**
 * Utility class for input validation
 * Demonstrates utility pattern and error handling
 */
public class InputValidator {
    
    private InputValidator() {
        // Private constructor to prevent instantiation
    }
    
    public static boolean isValidEmail(String email) {
        return email != null && email.matches("^[A-Za-z0-9+_.-]+@(.+)$");
    }
    
    public static boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }
    
    public static boolean isValidPhoneNumber(String phone) {
        return phone != null && phone.matches("^[0-9\\-\\s()+]{10,}$");
    }
    
    public static boolean isPositiveNumber(String input) {
        try {
            double value = Double.parseDouble(input);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean isPositiveInteger(String input) {
        try {
            int value = Integer.parseInt(input);
            return value > 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static void validateProductData(String name, double price, int stock) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Product name cannot be empty");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Price cannot be negative");
        }
        if (stock < 0) {
            throw new IllegalArgumentException("Stock cannot be negative");
        }
    }
}