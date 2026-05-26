package parkingLot.pricing;

import parkingLot.Ticket;

public interface PricingStrategy {
    double calculate(Ticket ticket);
}
