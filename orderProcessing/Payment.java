package orderProcessing;

import java.util.Date;
import java.util.List;

public abstract class Payment {
    protected String paymentId;
    protected double amount;
    protected Date paymentDate;
    protected String paymentStatus;

    public abstract boolean processPayment();
    public abstract boolean validatePayment();
    public abstract List<String> viewPaymentDetails();

    public String getPaymentId() { return paymentId; }
    public void setPaymentId(String paymentId) { this.paymentId = paymentId; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public Date getPaymentDate() { return paymentDate; }
    public void setPaymentDate(Date paymentDate) { this.paymentDate = paymentDate; }

    public String getPaymentStatus() { return paymentStatus; }
    public void setPaymentStatus(String paymentStatus) { this.paymentStatus = paymentStatus; }
}
