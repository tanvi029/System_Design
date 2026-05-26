package parkingLot.spotManagers;

import parkingLot.LookupStrategy.ParkingSpotLookUpStrategy;
import parkingLot.entity.ParkingSpot;

import java.util.List;

public class TwoWheelerSpotManager extends ParkingSpotManager{

    public TwoWheelerSpotManager(List<ParkingSpot> spots, ParkingSpotLookUpStrategy strategy) {
        super(spots, strategy);
    }
}
