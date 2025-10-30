package com.gadgetstore.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Represents the processing details of a customer order.
 * Demonstrates composition and encapsulation.
 */
public class OrderProcessing {
    private String orderId;
    private LocalDateTime processingDate;
    private String status;
    private List<Payment> payments;

    public OrderProcessing() {
        this.payments = new ArrayList<>();
        this.processingDate = LocalDateTime.now();
        this.status = "Pending";
    }

    public OrderProcessing(String orderId, String status) {
        this.orderId = orderId;
        this.processingDate = LocalDateTime.now();
        this.status = status;
        this.payments = new ArrayList<>();
    }

    // Getters and Setters
    public String getOrderId() { return orderId; }
    public void setOrderId(String orderId) { this.orderId = orderId; }

    public LocalDateTime getProcessingDate() { return processingDate; }
    public void setProcessingDate(LocalDateTime processingDate) { this.processingDate = processingDate; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public List<Payment> getPayments() { return payments; }
    public void setPayments(List<Payment> payments) { this.payments = payments; }

    // Business method placeholders
    public void addPayment(Payment payment) {
        // Adds a payment record related to this order
    }

    public void updateStatus(String newStatus) {
        // Updates the processing status of the order
    }

    public void reviewProcessingDetails() {
        // Placeholder: display order processing info
    }
}
