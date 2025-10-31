package com.gadgetstore.entities;

public class CreditCardPayment extends Payment {

    // attributes: cardNumber, cardHolderName, expiryDate
    private String cardNumber;
    private String cardHolderName;
    private String expiryDate;

    // Constructor
    public CreditCardPayment() {}

    public CreditCardPayment(String paymentId, String orderId, double amount, 
                             String paymentStatus, String cardNumber, 
                             String cardHolderName, String expiryDate) {
        super(paymentId, orderId, amount, paymentStatus);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.expiryDate = expiryDate;
    }

    // Getter and Setter
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
