package parkingLot.pricing;

import parkingLot.Ticket;

public class FixedPricingStrategy implements PricingStrategy{

    @Override
    public double calculate(Ticket ticket) {
        return 100;
    }
}
