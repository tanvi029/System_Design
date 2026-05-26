package parkingLot.parkingLot;


import parkingLot.Ticket;
import parkingLot.entity.Vehicle;

public class EntranceGate {
    public Ticket enter(ParkingBuilding building, Vehicle vehicle) {
        return building.allocate(vehicle);
    }
}
