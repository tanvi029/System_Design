package parkingLot.LookupStrategy;

import parkingLot.entity.ParkingSpot;

import java.util.List;

public interface ParkingSpotLookUpStrategy {
    ParkingSpot selectSpot (List<ParkingSpot> spots);
}
