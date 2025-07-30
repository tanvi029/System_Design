package carRental;

import java.util.Date;

public class PaymentDetails {
    private int paymentId;
    private double amountPaid;
    private Date dateOfPayment;
    private boolean isRefundable;
    private PaymentMode paymentMode;

    public PaymentDetails(int paymentId, double amountPaid, Date dateOfPayment,
                          boolean isRefundable, PaymentMode paymentMode) {
        this.paymentId = paymentId;
        this.amountPaid = amountPaid;
        this.dateOfPayment = dateOfPayment;
        this.isRefundable = isRefundable;
        this.paymentMode = paymentMode;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public Date getDateOfPayment() {
        return dateOfPayment;
    }

    public boolean isRefundable() {
        return isRefundable;
    }

    public PaymentMode getPaymentMode() {
        return paymentMode;
    }

    @Override
    public String toString() {
        return "PaymentDetails{" +
                "paymentId=" + paymentId +
                ", amountPaid=" + amountPaid +
                ", dateOfPayment=" + dateOfPayment +
                ", isRefundable=" + isRefundable +
                ", paymentMode=" + paymentMode +
                '}';
    }
}
