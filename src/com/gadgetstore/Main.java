package com.gadgetstore;

import com.gadgetstore.entities.*;
import com.gadgetstore.exceptions.AuthenticationException;
import com.gadgetstore.exceptions.InsufficientStockException;
import com.gadgetstore.services.*;
import com.gadgetstore.utils.ConsoleHelper;
import com.gadgetstore.utils.InputValidator;

import java.util.List;

/**
 * Main class for Online Gadget Store Management System
 * Demonstrates comprehensive system integration
 */
public class Main {
    private UserService userService;
    private InventoryService inventoryService;
    private OrderService orderService;
    private boolean running;
    
    public Main() {
        this.userService = UserService.getInstance();
        this.inventoryService = InventoryService.getInstance();
        this.orderService = OrderService.getInstance();
        this.running = true;
    }
    
    public void start() {
        ConsoleHelper.printHeader("WELCOME TO GADGET STORE MANAGEMENT SYSTEM");
        
        while (running) {
            if (!userService.isLoggedIn()) {
                showLoginMenu();
            } else {
                if (userService.isAdmin()) {
                    showAdminMenu();
                } else {
                    showCustomerMenu();
                }
            }
        }
        
        ConsoleHelper.closeScanner();
        System.out.println("Thank you for using Gadget Store Management System!");
    }
    
    private void showLoginMenu() {
        ConsoleHelper.printSection("MAIN MENU");
        System.out.println("1. Login");
        System.out.println("2. Register as Customer");
        System.out.println("3. Exit");
        
        int choice = ConsoleHelper.readPositiveInt("Choose an option: ");
        
        switch (choice) {
            case 1 -> login();
            case 2 -> register();
            case 3 -> running = false;
            default -> System.out.println("Invalid option. Please try again.");
        }
    }
    
    private void login() {
        ConsoleHelper.printSection("LOGIN");
        
        String email = ConsoleHelper.readNonEmptyString("Email: ");
        String password = ConsoleHelper.readNonEmptyString("Password: ");
        
        try {
            User user = userService.login(email, password);
            System.out.println("Login successful! Welcome, " + user.getName() + " (" + user.getRole() + ")");
        } catch (AuthenticationException e) {
            System.out.println("Login failed: " + e.getMessage());
        }
        
        ConsoleHelper.pause();
    }
    
    private void register() {
        ConsoleHelper.printSection("CUSTOMER REGISTRATION");
        
        String name = ConsoleHelper.readNonEmptyString("Full Name: ");
        String email = ConsoleHelper.readNonEmptyString("Email: ");
        String password = ConsoleHelper.readNonEmptyString("Password: ");
        String phone = ConsoleHelper.readNonEmptyString("Phone Number: ");
        String address = ConsoleHelper.readNonEmptyString("Address: ");
        
        // Validate inputs
        if (!InputValidator.isValidEmail(email)) {
            System.out.println("Invalid email format.");
            return;
        }
        
        if (!InputValidator.isValidPassword(password)) {
            System.out.println("Password must be at least 6 characters long.");
            return;
        }
        
        if (!InputValidator.isValidPhoneNumber(phone)) {
            System.out.println("Invalid phone number format.");
            return;
        }
        
        try {
            User user = userService.registerCustomer(name, email, password, phone, address);
            System.out.println("Registration successful! Welcome, " + user.getName());
        } catch (IllegalArgumentException e) {
            System.out.println("Registration failed: " + e.getMessage());
        }
        
        ConsoleHelper.pause();
    }
    
    private void showAdminMenu() {
        ConsoleHelper.printSection("ADMIN DASHBOARD");
        System.out.println("1. View All Products");
        System.out.println("2. Add New Product");
        System.out.println("3. Update Product");
        System.out.println("4. Remove Product");
        System.out.println("5. Update Stock");
        System.out.println("6. View System Statistics");
        System.out.println("7. Logout");
        System.out.println("8. Exit System");
        
        int choice = ConsoleHelper.readPositiveInt("Choose an option: ");
        
        switch (choice) {
            case 1 -> viewAllProducts();
            case 2 -> addNewProduct();
            case 3 -> updateProduct();
            case 4 -> removeProduct();
            case 5 -> updateStock();
            case 6 -> viewSystemStatistics();
            case 7 -> userService.logout();
            case 8 -> running = false;
            default -> System.out.println("Invalid option. Please try again.");
        }
    }
    
    private void showCustomerMenu() {
        ConsoleHelper.printSection("CUSTOMER DASHBOARD");
        System.out.println("1. Browse Products");
        System.out.println("2. Search Products");
        System.out.println("3. View Product Details");
        System.out.println("4. Place Order");
        System.out.println("5. View Order History");
        System.out.println("6. View Profile");
        System.out.println("7. Update Profile");
        System.out.println("8. Change Password");
        System.out.println("9. Logout");
        System.out.println("10. Exit System");
        
        int choice = ConsoleHelper.readPositiveInt("Choose an option: ");
        
        switch (choice) {
            case 1 -> browseProducts();
            case 2 -> searchProducts();
            case 3 -> viewProductDetails();
            case 4 -> placeOrder();
            case 5 -> viewOrderHistory();
            case 6 -> viewProfile();
            case 7 -> updateProfile();
            case 8 -> changePassword();
            case 9 -> userService.logout();
            case 10 -> running = false;
            default -> System.out.println("Invalid option. Please try again.");
        }
    }
    
    // Admin functionalities
    private void viewAllProducts() {
        ConsoleHelper.printSection("ALL PRODUCTS");
        List<Product> products = inventoryService.getAllProducts();
        
        if (products.isEmpty()) {
            System.out.println("No products found.");
            return;
        }
        
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.printf("%d. %s | Stock: %d | Price: $%.2f\n", 
                i + 1, product.getName(), product.getStock(), product.getPrice());
        }
        
        ConsoleHelper.pause();
    }
    
    private void addNewProduct() {
        ConsoleHelper.printSection("ADD NEW PRODUCT");
        
        String id = ConsoleHelper.readNonEmptyString("Product ID: ");
        String name = ConsoleHelper.readNonEmptyString("Product Name: ");
        String description = ConsoleHelper.readNonEmptyString("Description: ");
        double price = ConsoleHelper.readPositiveDouble("Price: $");
        int stock = ConsoleHelper.readPositiveInt("Stock Quantity: ");
        String category = ConsoleHelper.readNonEmptyString("Category: ");
        String brand = ConsoleHelper.readNonEmptyString("Brand: ");
        
        try {
            InputValidator.validateProductData(name, price, stock);
            Product product = new Product(id, name, description, price, stock, category);
            inventoryService.addProduct(product);
            System.out.println("Product added successfully!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error adding product: " + e.getMessage());
        }
        
        ConsoleHelper.pause();
    }
    
    private void updateProduct() {
        ConsoleHelper.printSection("UPDATE PRODUCT");
        viewAllProducts();
        
        String productId = ConsoleHelper.readNonEmptyString("Enter Product ID to update: ");
        Product product = inventoryService.getProduct(productId);
        
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }
        
        System.out.println("Current product details:");
        System.out.println(product.getDetailedInfo());
        
        // Get updated values (empty input keeps current value)
        System.out.println("\nEnter new values (press Enter to keep current):");
        String name = ConsoleHelper.readNonEmptyString("Name [" + product.getName() + "]: ");
        String description = ConsoleHelper.readNonEmptyString("Description [" + product.getDescription() + "]: ");
        String priceStr = ConsoleHelper.readNonEmptyString("Price [" + product.getPrice() + "]: ");
        String stockStr = ConsoleHelper.readNonEmptyString("Stock [" + product.getStock() + "]: ");
        String category = ConsoleHelper.readNonEmptyString("Category [" + product.getCategory() + "]: ");
        
        try {
            if (!name.isEmpty()) product.setName(name);
            if (!description.isEmpty()) product.setDescription(description);
            if (!priceStr.isEmpty()) product.setPrice(Double.parseDouble(priceStr));
            if (!stockStr.isEmpty()) product.setStock(Integer.parseInt(stockStr));
            if (!category.isEmpty()) product.setCategory(category);

            
            inventoryService.updateProduct(product);
            System.out.println("Product updated successfully!");
        } catch (Exception e) {
            System.out.println("Error updating product: " + e.getMessage());
        }
        
        ConsoleHelper.pause();
    }
    
    private void removeProduct() {
        ConsoleHelper.printSection("REMOVE PRODUCT");
        viewAllProducts();
        
        String productId = ConsoleHelper.readNonEmptyString("Enter Product ID to remove: ");
        
        if (inventoryService.removeProduct(productId)) {
            System.out.println("Product removed successfully!");
        } else {
            System.out.println("Product not found.");
        }
        
        ConsoleHelper.pause();
    }
    
    private void updateStock() {
        ConsoleHelper.printSection("UPDATE STOCK");
        viewAllProducts();
        
        String productId = ConsoleHelper.readNonEmptyString("Enter Product ID: ");
        Product product = inventoryService.getProduct(productId);
        
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }
        
        System.out.println("Current stock: " + product.getStock());
        int quantity = ConsoleHelper.readPositiveInt("Enter quantity to add (negative to remove): ");
        
        try {
            inventoryService.updateStock(productId, quantity);
            System.out.println("Stock updated successfully! New stock: " + 
                             inventoryService.getProduct(productId).getStock());
        } catch (InsufficientStockException e) {
            System.out.println("Error updating stock: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        ConsoleHelper.pause();
    }
    
    private void viewSystemStatistics() {
        ConsoleHelper.printSection("SYSTEM STATISTICS");
        
        List<Product> products = inventoryService.getAllProducts();
        long totalProducts = products.size();
        long outOfStock = products.stream().filter(p -> !p.isInStock()).count();
        double totalInventoryValue = products.stream()
                .mapToDouble(p -> p.getPrice() * p.getStock())
                .sum();
        
        System.out.printf("Total Products: %d\n", totalProducts);
        System.out.printf("Out of Stock: %d\n", outOfStock);
        System.out.printf("Total Inventory Value: $%.2f\n", totalInventoryValue);
        System.out.printf("Logged in as: %s\n", userService.getCurrentUser().getName());
        
        ConsoleHelper.pause();
    }
    
    // Customer functionalities
    private void browseProducts() {
        ConsoleHelper.printSection("AVAILABLE PRODUCTS");
        List<Product> products = inventoryService.getAvailableProducts();
        
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }
        
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            System.out.printf("%d. %s - %s | $%.2f | Stock: %d\n", 
                i + 1, product.getName(), 
                product.getPrice(), product.getStock());
        }
        
        ConsoleHelper.pause();
    }
    
    private void searchProducts() {
        ConsoleHelper.printSection("SEARCH PRODUCTS");
        String keyword = ConsoleHelper.readNonEmptyString("Enter search keyword: ");
        
        List<Product> results = inventoryService.searchProducts(keyword);
        
        if (results.isEmpty()) {
            System.out.println("No products found matching: " + keyword);
            return;
        }
        
        System.out.println("Found " + results.size() + " product(s):");
        for (int i = 0; i < results.size(); i++) {
            Product product = results.get(i);
            System.out.printf("%d. %s - %s | $%.2f | %s\n", 
                i + 1, product.getName(), 
                product.getPrice(), product.isInStock() ? "In Stock" : "Out of Stock");
        }
        
        ConsoleHelper.pause();
    }
    
    private void viewProductDetails() {
        ConsoleHelper.printSection("PRODUCT DETAILS");
        String productId = ConsoleHelper.readNonEmptyString("Enter Product ID: ");
        
        Product product = inventoryService.getProduct(productId);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }
        
        System.out.println(product.getDetailedInfo());
        ConsoleHelper.pause();
    }
    
    private void placeOrder() {
        ConsoleHelper.printSection("PLACE NEW ORDER");
        
        Customer customer = userService.getCurrentCustomer();
        if (customer == null) {
            System.out.println("Customer data not available.");
            return;
        }
        
        Order order = orderService.createOrder(customer.getUserId());
        boolean addingItems = true;
        
        while (addingItems) {
            browseProducts();
            String productId = ConsoleHelper.readNonEmptyString("Enter Product ID to add (or 'done' to finish): ");
            
            if (productId.equalsIgnoreCase("done")) {
                addingItems = false;
                continue;
            }
            
            Product product = inventoryService.getProduct(productId);
            if (product == null) {
                System.out.println("Product not found.");
                continue;
            }
            
            if (!product.isInStock()) {
                System.out.println("Product is out of stock.");
                continue;
            }
            
            int quantity = ConsoleHelper.readPositiveInt("Enter quantity: ");
            
            try {
                orderService.addItemToOrder(order, productId, quantity);
                System.out.println("Added " + quantity + " x " + product.getName() + " to order.");
            } catch (InsufficientStockException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error adding item: " + e.getMessage());
            }
        }
        
        if (order.getItems().isEmpty()) {
            System.out.println("Order cancelled - no items added.");
            return;
        }
        
        // Process the order
        orderService.processOrder(order);
        customer.addOrder(order);
        
        System.out.println("\nOrder Summary:");
        order.displayOrderDetails();
        
        ConsoleHelper.pause();
    }
    
    private void viewOrderHistory() {
        Customer customer = userService.getCurrentCustomer();
        if (customer == null) {
            System.out.println("Customer data not available.");
            return;
        }
        
        customer.viewOrderHistory();
        ConsoleHelper.pause();
    }
    
    private void viewProfile() {
        ConsoleHelper.printSection("MY PROFILE");
        User user = userService.getCurrentUser();
        
        System.out.println(user);
        if (user instanceof Customer customer) {
            System.out.println("Phone: " + customer.getPhoneNumber());
            System.out.println("Address: " + customer.getAddress());
            System.out.println("Total Orders: " + customer.getOrderHistory().size());
        }
        
        ConsoleHelper.pause();
    }
    
    private void updateProfile() {
        ConsoleHelper.printSection("UPDATE PROFILE");
        User user = userService.getCurrentUser();
        
        System.out.println("Current profile:");
        System.out.println("Name: " + user.getName());
        System.out.println("Email: " + user.getEmail());
        
        if (user instanceof Customer customer) {
            System.out.println("Phone: " + customer.getPhoneNumber());
            System.out.println("Address: " + customer.getAddress());
        }
        
        System.out.println("\nEnter new values (press Enter to keep current):");
        String name = ConsoleHelper.readNonEmptyString("Name: ");
        String email = ConsoleHelper.readNonEmptyString("Email: ");
        String phone = "";
        String address = "";
        
        if (user instanceof Customer) {
            phone = ConsoleHelper.readNonEmptyString("Phone: ");
            address = ConsoleHelper.readNonEmptyString("Address: ");
        }
        
        try {
            userService.updateUserProfile(
                name.isEmpty() ? null : name,
                email.isEmpty() ? null : email,
                phone.isEmpty() ? null : phone,
                address.isEmpty() ? null : address
            );
            System.out.println("Profile updated successfully!");
        } catch (Exception e) {
            System.out.println("Error updating profile: " + e.getMessage());
        }
        
        ConsoleHelper.pause();
    }
    
    private void changePassword() {
        ConsoleHelper.printSection("CHANGE PASSWORD");
        
        String oldPassword = ConsoleHelper.readNonEmptyString("Current Password: ");
        String newPassword = ConsoleHelper.readNonEmptyString("New Password: ");
        String confirmPassword = ConsoleHelper.readNonEmptyString("Confirm New Password: ");
        
        if (!newPassword.equals(confirmPassword)) {
            System.out.println("New passwords do not match.");
            return;
        }
        
        if (!InputValidator.isValidPassword(newPassword)) {
            System.out.println("New password must be at least 6 characters long.");
            return;
        }
        
        try {
            userService.changePassword(oldPassword, newPassword);
            System.out.println("Password changed successfully!");
        } catch (Exception e) {
            System.out.println("Error changing password: " + e.getMessage());
        }
        
        ConsoleHelper.pause();
    }
    
    public static void main(String[] args) {
        try {
            Main app = new Main();
            app.start();
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}