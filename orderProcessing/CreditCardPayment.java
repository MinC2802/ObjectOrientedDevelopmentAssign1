package orderProcessing;

import java.util.List;

public class CreditCardPayment extends Payment {
    private String cardNumber;

    public CreditCardPayment() {}

    public CreditCardPayment(String cardNumber, double amount) {
        this.cardNumber = cardNumber;
        this.amount = amount;
    }

    @Override
    public boolean processPayment() { return false; }

    @Override
    public boolean validatePayment() { return false; }

    @Override
    public List<String> viewPaymentDetails() { return null; }

    public String getCardNumber() { return cardNumber; }
    public void setCardNumber(String cardNumber) { this.cardNumber = cardNumber; }
}
