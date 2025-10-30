package com.gadgetstore.services;

import com.gadgetstore.entities.Order;

/**
 * Interface defining email-related operations.
 * Demonstrates abstraction.
 */
public interface EmailService {

    void sendConfirmationEmail(String recipientEmail, Order order);

    void sendCancellationEmail(String recipientEmail, Order order);

    void sendDeliveryEmail(String recipientEmail, Order order);
}
