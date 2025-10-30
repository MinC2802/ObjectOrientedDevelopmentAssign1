package com.gadgetstore.entities;

/**
 * Represents a payment made by credit card.
 * Demonstrates inheritance and polymorphism.
 */
public class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;

    public CreditCardPayment() {}

    public CreditCardPayment(String paymentId, String orderId, double amount, 
                             PaymentStatus paymentStatus, String cardNumber, 
                             String cardHolderName, String expiryDate) {
        super(paymentId, orderId, amount, paymentStatus);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
    }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }

    public String getCardHolderName() { return cardHolderName; }
    public void setCardHolderName(String cardHolderName) { this.cardHolderName = cardHolderName; }

    public String getExpiryDate() { return expiryDate; }
    public void setExpiryDate(String expiryDate) { this.expiryDate = expiryDate; }

    public void processPayment() {
        // Placeholder: process credit card payment
    }
}
