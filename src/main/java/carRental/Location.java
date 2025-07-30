package carRental;

import java.util.Objects;

public class Location {
    private String address;
    private int pincode;
    private String city;
    private String state;
    private String country;

    public Location(String address, int pincode, String city, String state, String country) {
        this.address = address;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    // Getters
    public String getAddress() {
        return address;
    }

    public int getPincode() {
        return pincode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    // Optional: Setters if needed (omit for immutability)
    public void setAddress(String address) {
        this.address = address;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    // toString()
    @Override
    public String toString() {
        return address + ", " + city + ", " + state + ", " + pincode + ", " + country;
    }

    // equals() and hashCode()
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return pincode == location.pincode &&
                Objects.equals(address, location.address) &&
                Objects.equals(city, location.city) &&
                Objects.equals(state, location.state) &&
                Objects.equals(country, location.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, pincode, city, state, country);
    }
}
