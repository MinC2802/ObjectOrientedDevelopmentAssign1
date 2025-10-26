package com.gadgetstore.exceptions;

/**
 * Custom exception for insufficient stock scenarios
 */
public class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}