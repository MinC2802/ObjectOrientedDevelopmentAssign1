package com.gadgetstore.entities;

import java.time.LocalDateTime;

/**
 * Represents payment details for an order.
 * Demonstrates encapsulation and abstraction.
 */
public class Payment {
    private String paymentId;
    private String orderId;
    private double amount;
    private LocalDateTime paymentDate;
    private PaymentStatus paymentStatus;

    public enum PaymentStatus {
        PENDING, COMPLETED, FAILED
    }
    public Payment() {}


    // 3-parameter constructor (default)
    public Payment(String paymentId, String orderId, double amount) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.paymentDate = LocalDateTime.now();
        this.paymentStatus = PaymentStatus.PENDING;
    }

    // ✅ Added 4-parameter constructor
    public Payment(String paymentId, String orderId, double amount, PaymentStatus paymentStatus) {
        this.paymentId = paymentId;
        this.orderId = orderId;
        this.amount = amount;
        this.paymentDate = LocalDateTime.now();
        this.paymentStatus = paymentStatus;
    }

    public String getPaymentId() { return paymentId; }
    public String getOrderId() { return orderId; }
    public double getAmount() { return amount; }
    public LocalDateTime getPaymentDate() { return paymentDate; }
    public PaymentStatus getPaymentStatus() { return paymentStatus; }

    public void updatePaymentStatus(PaymentStatus newStatus) {
        this.paymentStatus = newStatus;
    }

    public String getPaymentSummary() {
        return String.format("Payment #%s | Order: %s | Status: %s | Amount: $%.2f",
                paymentId, orderId, paymentStatus, amount);
    }
}
