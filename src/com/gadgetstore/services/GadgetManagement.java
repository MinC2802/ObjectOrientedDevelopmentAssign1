package com.gadgetstore.services;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class GadgetManagement {
    // ConcurrentHashMap for thread-safe operations
    private final Map<String, Gadgets> gadgets = new ConcurrentHashMap<>();

    public void addGadget(Gadgets gadget) {
        gadgets.put(gadget.getProductId(), gadget);
    }

    public Gadgets getGadget(String id) {
        return gadgets.get(id);
    }

    public void updateStock(String id, int delta) throws Exception {
        Gadgets gadget = gadgets.get(id);
        if (gadget == null) {
            throw new Exception("Gadget not found: " + id);
        }

        synchronized (gadget) {
            int newStock = gadget.getStock() + delta;
            if (newStock < 0) {
                throw new Exception("Insufficient stock for " + gadget.getName());
            }
            gadget.setStock(newStock);
        }
    }

    public void printInventory() {
        System.out.println("\n--- Current Inventory ---");
        gadgets.values().forEach(System.out::println);
    }
}
