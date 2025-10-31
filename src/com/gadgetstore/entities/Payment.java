package com.gadgetstore.entities;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Represents payment details for an order.
 * Demonstrates encapsulation and abstraction.
 */
public abstract class Payment {
    private String paymentId;
    private String orderId;
    private double amount;
    private LocalDateTime paymentDate;
    private PaymentStatus paymentStatus;

    // Enum for payment status
    public enum PaymentStatus {
        PENDING, COMPLETED, FAILED
    }

    // Constructors
    public Payment() {}

    public Payment(String paymentId, String orderId, double amount) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.paymentDate = LocalDateTime.now();
        this.paymentStatus = PaymentStatus.PENDING;
    }

    public Payment(String paymentId, String orderId, double amount, PaymentStatus paymentStatus) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.paymentDate = LocalDateTime.now();
        this.paymentStatus = paymentStatus;
    }

    // Getters and Setters
    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }

    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public LocalDateTime getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }

    public PaymentStatus getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(PaymentStatus paymentStatus) { this.paymentStatus = paymentStatus; }

    // Abstract and placeholder methods
    public abstract void processPayment();   // Abstract method to be implemented by subclasses

    public boolean validatePayment() {
        // Placeholder for payment validation logic
        return false;
    }

    public List<String> viewPaymentDetails() {
        // Placeholder for viewing payment details
        return null;
    }

    public String getPaymentSummary() {
        // Placeholder for returning payment summary
        return null;
    }
}
