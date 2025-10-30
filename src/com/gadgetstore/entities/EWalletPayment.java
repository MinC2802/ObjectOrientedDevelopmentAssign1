package com.gadgetstore.entities;

/**
 * Represents a payment made through an e-wallet (e.g., TNG, GrabPay).
 * Demonstrates inheritance and polymorphism.
 */
public class EWalletPayment extends Payment {
    private String walletProvider;
    private String walletId;

    public EWalletPayment() {}

    public EWalletPayment(String paymentId, String orderId, double amount, 
                          PaymentStatus paymentStatus, String walletProvider, 
                          String walletId) {
        super(paymentId, orderId, amount, paymentStatus);
        this.walletProvider = walletProvider;
        this.walletId = walletId;
    }

    public String getWalletProvider() { return walletProvider; }
    public void setWalletProvider(String walletProvider) { this.walletProvider = walletProvider; }

    public String getWalletId() { return walletId; }
    public void setWalletId(String walletId) { this.walletId = walletId; }

    public void processPayment() {
        // Placeholder: process e-wallet payment
    }
}
