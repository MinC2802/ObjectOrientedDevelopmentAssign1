package com.gadgetstore.services;

import orderProcessing.Product;

public interface InventoryService2 {
    Product findProductById(String productId);
    boolean reserveStock(String productId, int quantity);
    void releaseStock(String productId, int quantity);
    void commitStock(String productId, int quantity);
}