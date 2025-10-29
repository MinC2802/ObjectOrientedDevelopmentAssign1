package com.gadgetstore.services;

import com.gadgetstore.entities.Product;
import com.gadgetstore.exceptions.InsufficientStockException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * InventoryService managing products using Singleton pattern
 * Demonstrates Singleton pattern and encapsulation
 */
public class InventoryService {
    private static InventoryService instance;
    private Map<String, Product> products;
    
    private InventoryService() {
        products = new HashMap<>();
        initializeSampleProducts();
    }
    
    public static synchronized InventoryService getInstance() {
        if (instance == null) {
            instance = new InventoryService();
        }
        return instance;
    }
    
    private void initializeSampleProducts() {
        // Add sample products
        addProduct(new Product("P001", "iPhone 15 Pro", "Latest Apple smartphone with advanced camera", 999.99, 50, "Smartphone"));
        addProduct(new Product("P002", "Samsung Galaxy S24", "Android flagship phone", 849.99, 30, "Smartphone"));
        addProduct(new Product("P003", "MacBook Pro 16", "Professional laptop for developers", 2399.99, 20, "Laptop"));
        addProduct(new Product("P004", "Dell XPS 13", "Ultra-thin business laptop", 1199.99, 25, "Laptop"));
        addProduct(new Product("P005", "Sony WH-1000XM5", "Noise-cancelling wireless headphones", 399.99, 40, "Headphones"));
        addProduct(new Product("P006", "iPad Air", "Versatile tablet for work and play", 599.99, 35, "Tablet"));
    }
    
    // Product management methods
    public void addProduct(Product product) {
        if (product != null) {
            products.put(product.getProductId(), product);
        }
    }
    
    public Product getProduct(String productId) {
        return products.get(productId);
    }
    
    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }
    
    public List<Product> getAvailableProducts() {
        return products.values().stream()
                .filter(Product::isInStock)
                .toList();
    }
    
    public void updateProduct(Product product) {
        if (product != null && products.containsKey(product.getProductId())) {
            products.put(product.getProductId(), product);
        }
    }
    
    public boolean removeProduct(String productId) {
        return products.remove(productId) != null;
    }
    
    // Stock management
    public void updateStock(String productId, int quantity) throws InsufficientStockException {
        Product product = products.get(productId);
        if (product == null) {
            throw new IllegalArgumentException("Product not found");
        }
        
        if (quantity < 0 && product.getstock() < Math.abs(quantity)) {
            throw new InsufficientStockException(
                String.format("Insufficient stock for %s. Available: %d, Requested: %d",
                            product.getName(), product.getstock(), Math.abs(quantity))
            );
        }
        
        product.setstock(product.getstock() + quantity);
    }
    
    public boolean checkStock(String productId, int quantity) {
        Product product = products.get(productId);
        return product != null && product.getstock() >= quantity;
    }
    
    // Search functionality
    public List<Product> searchProducts(String keyword) {
        String searchTerm = keyword.toLowerCase();
        return products.values().stream()
                .filter(product -> 
                    product.getName().toLowerCase().contains(searchTerm) ||
                    product.getDescription().toLowerCase().contains(searchTerm) ||
                    product.getCategory().toLowerCase().contains(searchTerm))
                .toList();
    }
    
    public List<Product> getProductsByCategory(String category) {
        return products.values().stream()
                .filter(product -> product.getCategory().equalsIgnoreCase(category))
                .toList();
    }
}







