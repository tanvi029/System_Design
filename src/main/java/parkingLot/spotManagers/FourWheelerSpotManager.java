package parkingLot.spotManagers;

import parkingLot.LookupStrategy.ParkingSpotLookUpStrategy;
import parkingLot.entity.ParkingSpot;

import java.util.List;

public class FourWheelerSpotManager extends ParkingSpotManager{

    public FourWheelerSpotManager(List<ParkingSpot> spots, ParkingSpotLookUpStrategy strategy) {
        super(spots, strategy);
    }
}
