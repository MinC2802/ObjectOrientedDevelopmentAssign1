package com.gadgetstore;

import java.util.*;
import com.gadgetstore.*;
import com.gadgetstore.services.CustomerManagement;
import com.gadgetstore.services.GadgetManagement;
import com.gadgetstore.services.OrderProcessing;

public class GadgetStoreApp {
    private Scanner scanner;
    private String currentUser;
    private String userRole;
    
    // User database
    private Map<String, String> userCredentials = new HashMap<>();
    private Map<String, String> userRoles = new HashMap<>();
    
    public GadgetStoreApp() {
        this.scanner = new Scanner(System.in);
        initializeUsers();
    }
    
    private void initializeUsers() {
        // Admin users
        userCredentials.put("admin", "admin123");
        userRoles.put("admin", "admin");
        
        // Customer users
        userCredentials.put("john", "pass123");
        userRoles.put("john", "customer");
        
        userCredentials.put("sarah", "pass123");
        userRoles.put("sarah", "customer");
    }
    
    public static void main(String[] args) {
        GadgetStoreApp app = new GadgetStoreApp();
        app.start();
    }
    
    public void start() {
        System.out.println("  Welcome to Gadget Store");
        
        try {
            mainLoop();
        } catch (Exception e) {
            System.out.println(" System error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
    
    private void mainLoop() {
        while (true) {
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            System.out.print("Choose option: ");
            
            String choice = scanner.nextLine().trim();
            
            switch (choice) {
                case "1":
                    login();
                    break;
                case "2":
                    register();
                    break;
                case "3":
                    System.out.println("Thank you for visiting! ");
                    return;
                default:
                    System.out.println(" Invalid choice! Please try again.");
            }
        }
    }
    
    private void login() {
        try {
            System.out.println("\n--- Login ---");
            System.out.print("Username: ");
            String username = scanner.nextLine().trim();
            System.out.print("Password: ");
            String password = scanner.nextLine().trim();
            
            if (username.isEmpty() || password.isEmpty()) {
                System.out.println(" Username and password cannot be empty!");
                return;
            }
            
            if (userCredentials.containsKey(username) && 
                userCredentials.get(username).equals(password)) {
                
                currentUser = username;
                userRole = userRoles.get(username);
                System.out.println(" Login successful! Welcome " + username);
                showRoleMenu();
                
            } else {
                System.out.println(" Invalid username or password!");
            }
            
        } catch (Exception e) {
            System.out.println(" Login error: " + e.getMessage());
        }
    }
    
    private void register() {
        try {
            System.out.println("\n--- Register ---");
            System.out.print("Choose username: ");
            String username = scanner.nextLine().trim();
            System.out.print("Choose password: ");
            String password = scanner.nextLine().trim();
            System.out.print("Role (admin/customer): ");
            String role = scanner.nextLine().trim().toLowerCase();
            
            if (username.isEmpty() || password.isEmpty()) {
                System.out.println(" Username and password cannot be empty!");
                return;
            }
            
            if (userCredentials.containsKey(username)) {
                System.out.println(" Username already exists!");
                return;
            }
            
            if (!role.equals("admin") && !role.equals("customer")) {
                System.out.println(" Role must be 'admin' or 'customer'!");
                return;
            }
            
            userCredentials.put(username, password);
            userRoles.put(username, role);
            System.out.println(" Registration successful! You can now login.");
            
        } catch (Exception e) {
            System.out.println(" Registration error: " + e.getMessage());
        }
    }
    
    private void showRoleMenu() {
        while (currentUser != null) {
            if ("admin".equals(userRole)) {
                showAdminMenu();
            } else {
                showCustomerMenu();
            }
        }
    }
    
    private void showAdminMenu() {
        System.out.println("\n=== ADMIN DASHBOARD ===");
        System.out.println("Logged in as: " + currentUser);
        System.out.println("1.  Manage Products");
        System.out.println("2.  View Orders");
        System.out.println("3.  Logout");
        System.out.print("Choose option: ");
        
        String choice = scanner.nextLine();
        
        switch (choice) {
            case "1":
                System.out.println("Opening product management...");
                GadgetManagement g1 = new GadgetManagement();
                break;
            case "2":
                System.out.println("Viewing all orders...");
                OrderProcessing o1 = new OrderProcessing();
                break;
            case "3":
                logout();
                break;
            default:
                System.out.println(" Invalid choice!");
        }
    }
    
    private void showCustomerMenu() {
        System.out.println("\n=== CUSTOMER DASHBOARD ===");
        System.out.println("Welcome, " + currentUser + "!");
        System.out.println("1.  Browse Products");
        System.out.println("2.  Place Order");
        System.out.println("3.  My Orders");
        System.out.println("4.  Logout");
        System.out.print("Choose option: ");
        
        String choice = scanner.nextLine();
        
        switch (choice) {
            case "1":
                System.out.println("Browsing products...");
                GadgetManagement g1 = new GadgetManagement();
                break;
            case "2":
                System.out.println("Placing order...");
                CustomerManagement o1 = new CustomerManagement();
                break;
            case "3":
                System.out.println("Viewing your orders...");
                CustomerManagement c1 = new CustomerManagement();
                break;
            case "4":
                logout();
                break;
            default:
                System.out.println(" Invalid choice!");
        }
    }
    
    private void logout() {
        System.out.println("Logging out " + currentUser + "...");
        currentUser = null;
        userRole = null;
    }
}