package com.gadgetstore.services;

import com.gadgetstore.entities.Order;

/**
 * Implements EmailService for sending order-related emails.
 * Demonstrates abstraction and encapsulation.
 */
public class EmailSystem implements EmailService {

    // Singleton instance (optional)
    private static EmailSystem instance;

    private EmailSystem() {
        // private constructor
    }

    public static EmailSystem getInstance() {
        if (instance == null) {
            instance = new EmailSystem();
        }
        return instance;
    }

    @Override
    public void sendConfirmationEmail(String recipientEmail, Order order) {
        // Placeholder: send confirmation email
    }

    @Override
    public void sendCancellationEmail(String recipientEmail, Order order) {
        // Placeholder: send cancellation email
    }

    @Override
    public void sendDeliveryEmail(String recipientEmail, Order order) {
        // Placeholder: send delivery email
    }
}
