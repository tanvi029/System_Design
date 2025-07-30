package carRental;

public class Payment {

    public boolean payBill(Bill bill) {
        if (bill == null) {
            throw new IllegalArgumentException("Bill cannot be null.");
        }

        if (bill.isBillPaid()) {
            System.out.println("Bill is already paid.");
            return false;
        }

        // Simulate payment processing
        System.out.println("Processing payment of ₹" + bill.getTotalBillAmount() + " for reservation ID: " +
                bill.getReservation().getReservationId());

        // You can add more logic here like interacting with a payment gateway or validating card, etc.

        bill.markAsPaid();
        System.out.println("Payment successful. Bill marked as paid.");
        return true;
    }
}
