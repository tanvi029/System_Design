package parkingLot.parkingLot;

import parkingLot.Ticket;
import parkingLot.payment.Payment;
import parkingLot.pricing.CostComputation;

public class ExitGate {
    private final CostComputation costComputation;

    public ExitGate(CostComputation costComputation) {
        this.costComputation = costComputation;
    }

    public void completeExit(ParkingBuilding building, Ticket ticket, Payment payment) {
        double amount = calculatePrice(ticket);
        boolean success = payment.pay(amount);
        if (!success) {
            throw new RuntimeException("Payment Failed. Exit denied.");
        }
        building.release(ticket);
        System.out.println("Exit Successful. Gate Opened");
    }
    private double calculatePrice(Ticket ticket) {
        return costComputation.compute(ticket);
    }
}
