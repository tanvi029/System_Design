package carRental;

public class Bill {
    private Reservation reservation;
    private double totalBillAmount;
    private boolean isBillPaid;

    public Bill(Reservation reservation) {
        this.reservation = reservation;
        this.totalBillAmount = computeBillAmount();
        this.isBillPaid = false;
    }

    private double computeBillAmount() {
        // Sample logic: ₹1000 per day for daily reservations
        long millisInDay = 24 * 60 * 60 * 1000L;
        long durationInDays = (reservation.getDateBookedTo().getTime() -
                reservation.getDateBookedFrom().getTime()) / millisInDay;

        if (durationInDays <= 0) durationInDays = 1; // Minimum 1 day charge

        return durationInDays * 1000.0;
    }

    public double getTotalBillAmount() {
        return totalBillAmount;
    }

    public boolean isBillPaid() {
        return isBillPaid;
    }

    public void markAsPaid() {
        this.isBillPaid = true;
    }

    public Reservation getReservation() {
        return reservation;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "reservationId=" + reservation.getReservationId() +
                ", totalBillAmount=" + totalBillAmount +
                ", isBillPaid=" + isBillPaid +
                '}';
    }
}
