package parkingLot.LookupStrategy;

import parkingLot.entity.ParkingSpot;

import java.util.List;

public class RandomLookUpStrategy implements ParkingSpotLookUpStrategy {

    @Override
    public ParkingSpot selectSpot(List<ParkingSpot> spots) {
        for (ParkingSpot spot: spots) {
            if (spot.isSpotFree()) {
                return spot;

            }
        }
        return  null;
    }
}
