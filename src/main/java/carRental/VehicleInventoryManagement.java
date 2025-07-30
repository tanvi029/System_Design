package carRental;

import carRental.product.Status;
import carRental.product.Vehicle;
import carRental.product.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class VehicleInventoryManagement {
    private List<Vehicle> vehicles;

    VehicleInventoryManagement(List<Vehicle> vehicles) {
    this.vehicles = new ArrayList<>(vehicles); // defensive copy
    }

    public List<Vehicle> getVehicles() {
        //filtering
        return new ArrayList<>(vehicles); // defensive copy
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles =  new ArrayList<>(vehicles);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        vehicles.remove(vehicle);
    }

    public List getAvailableVehicles() {
        return vehicles.stream().filter(v->v.getVehicleStatus() == Status.ACTIVE).collect(Collectors.toList());
    }

    public List<Vehicle> getVehiclesByType(String type) {
        return vehicles.stream()
                .filter(v -> v.getVehicleType().equals(type))
                .collect(Collectors.toList());
    }

    public List<Vehicle> getVehiclesByBrand(String brand) {
        return vehicles.stream()
                .filter(v -> v.getCompanyName().equalsIgnoreCase(brand))
                .collect(Collectors.toList());
    }

}
