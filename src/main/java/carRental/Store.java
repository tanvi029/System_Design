package carRental;

import carRental.product.Vehicle;
import carRental.product.VehicleType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class Store {
    int storeId;
    VehicleInventoryManagement vehicleInventoryManagement;
    Location location;
    List<Reservation> reservations = new ArrayList<>();

    public Store(int storeId, Location location) {
        this.storeId = storeId;
        this.location = location;
        this.vehicleInventoryManagement = new VehicleInventoryManagement(new ArrayList<>());
    }


    public List<Vehicle> getVehicles(VehicleType vehicleType) {
        return vehicleInventoryManagement.getVehicles().stream()
                .filter(v->v.getVehicleType().equals(vehicleType))
                .collect(Collectors.toList());
    }

    public void setVehicles(List<Vehicle> vehicles) {
        vehicleInventoryManagement = new VehicleInventoryManagement(vehicles);
    }

    public Reservation createReservation(Vehicle vehicle, User user, Date from, Date to, Location dropLocation, ReservationType reservationType) {
        Reservation reservation = new Reservation(user, vehicle, from, to, this.location, dropLocation, reservationType);
        reservations.add(reservation);
        return reservation;
    }

    public boolean completeReservation(String reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationId().equals(reservationId)) {
                reservation.setReservationStatus(ReservationStatus.COMPLETED);
                return true;
            }
        }
        return false;
    }

    public Location getLocation() {
        return this.location;
    }

    //update reservation

}
