package com.gadgetstore.exceptions;

/**
 * Custom exception for authentication failures
 */
public class AuthenticationException extends Exception {
    public AuthenticationException(String message) {
        super(message);
    }
}