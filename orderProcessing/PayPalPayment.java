package orderProcessing;

import java.util.List;

public class PayPalPayment extends Payment {
    private String accountEmail;

    public PayPalPayment() {}

    public PayPalPayment(String accountEmail, double amount) {
        this.accountEmail = accountEmail;
        this.amount = amount;
    }

    @Override
    public boolean processPayment() { return false; }

    @Override
    public boolean validatePayment() { return false; }

    @Override
    public List<String> viewPaymentDetails() { return null; }

    public String getAccountEmail() { return accountEmail; }
    public void setAccountEmail(String accountEmail) { this.accountEmail = accountEmail; }
}
