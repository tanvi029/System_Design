package carRental;

import carRental.product.Car;
import carRental.product.Vehicle;
import carRental.product.VehicleType;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String args[]) {


        List<User> users = addUsers();
        List<Vehicle> vehicles = addVehicles();
        List<Store> stores = addStores(vehicles);

        VehicleRentalSystem rentalSystem = new VehicleRentalSystem(stores, users);

        //0. User comes
        User user = users.get(0);

        //1. user search store based on location
        Location location = new Location("OMBR", 560001, "Bangalore", "Karnataka", "India");
        Store store = rentalSystem.getStore(location);

        //2. get All vehicles you are interested in (based upon different filters)
        List<Vehicle> storeVehicles = store.getVehicles(VehicleType.CAR);

        Date from = new Date(); // current time
        Date to = new Date(from.getTime() + 2 * 60 * 60 * 1000); // 2 hours later
        Location dropLocation = store.getLocation(); // or another location if different
        ReservationType reservationType = ReservationType.HOURLY;

        //3.reserving the particular vehicle
        Reservation reservation = store.createReservation(
                storeVehicles.get(0),
                user,
                from,
                to,
                dropLocation,
                reservationType);

        //4. generate the bill
        Bill bill = new Bill(reservation);

        //5. make payment
        Payment payment = new Payment();
        payment.payBill(bill);

        //6. trip completed, submit the vehicle and close the reservation
        store.completeReservation(reservation.getReservationId());

    }



    public static List<Vehicle> addVehicles(){

        List<Vehicle> vehicles = new ArrayList<>();

        Vehicle vehicle1 = new Car();
        vehicle1.setVehicleId(1);
        vehicle1.setVehicleType(VehicleType.CAR);

        Vehicle vehicle2 = new Car();
        vehicle2.setVehicleId(2);
        vehicle2.setVehicleType(VehicleType.CAR);

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        return vehicles;
    }

    public static List<User> addUsers(){

        List<User> users = new ArrayList<>();
        User user1 = new User();
        user1.setUserId(1);

        users.add(user1);
        return users;
    }

    public static List<Store> addStores(List<Vehicle> vehicles){

        List<Store> stores = new ArrayList<>();

        // Create a dummy location for the store
        Location location = new Location("OMBR", 560001, "Bangalore", "Karnataka", "India");

        // Create the store using the constructor
        Store store1 = new Store(1, location);

        // Set the vehicles in the store's inventory
        store1.setVehicles(vehicles);

        // Add the store to the list
        stores.add(store1);

        return stores;
    }


}
