package com.gadgetstore.entities;

public class EWalletPayment extends Payment {
    // attributes: phoneNumber, address, orderHistory
    private String walletProvider;
    private String walletId;

    public EWalletPayment() {}

    // Constructor
    public EWalletPayment(String paymentId, String orderId, double amount, 
                          String paymentStatus, String walletProvider, 
                          String walletId) {
        super(paymentId, orderId, amount, paymentStatus);
        this.walletProvider = walletProvider;
        this.walletId = walletId;
    }

    // Getters and setters
    public String getWalletProvider() { return walletProvider; }
    public void setWalletProvider(String walletProvider) { this.walletProvider = walletProvider; }

    public String getWalletId() { return walletId; }
    public void setWalletId(String walletId) { this.walletId = walletId; }

    public void processPayment() {
        // TODO: process e-wallet payment
    }
}
