package carRental;

import carRental.product.Vehicle;

import java.util.Date;
import java.util.UUID;

public class Reservation {

    private String reservationId;
    private User user;
    private Vehicle vehicle;
    private Date bookingDate;
    private Date dateBookedFrom;
    private Date dateBookedTo;
    private Long fromTimeStamp;
    private Long toTimeStamp;
    private Location pickUpLocation;
    private Location dropLocation;
    private ReservationType reservationType;
    private ReservationStatus reservationStatus;

    public Reservation(User user, Vehicle vehicle, Date dateBookedFrom, Date dateBookedTo,
                       Location pickUpLocation, Location dropLocation,
                       ReservationType reservationType) {
        this.reservationId = generateReservationId();
        this.user = user;
        this.vehicle = vehicle;
        this.bookingDate = new Date(); // now
        this.dateBookedFrom = dateBookedFrom;
        this.dateBookedTo = dateBookedTo;
        this.fromTimeStamp = dateBookedFrom.getTime();
        this.toTimeStamp = dateBookedTo.getTime();
        this.pickUpLocation = pickUpLocation;
        this.dropLocation = dropLocation;
        this.reservationType = reservationType;
        this.reservationStatus = ReservationStatus.SCHEDULED;
    }

    private String generateReservationId() {
        return UUID.randomUUID().toString();
    }

    public String getReservationId() {
        return reservationId;
    }

    public User getUser() {
        return user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Date getBookingDate() {
        return bookingDate;
    }

    public Date getDateBookedFrom() {
        return dateBookedFrom;
    }

    public Date getDateBookedTo() {
        return dateBookedTo;
    }

    public Long getFromTimeStamp() {
        return fromTimeStamp;
    }

    public Long getToTimeStamp() {
        return toTimeStamp;
    }

    public Location getPickUpLocation() {
        return pickUpLocation;
    }

    public Location getDropLocation() {
        return dropLocation;
    }

    public ReservationType getReservationType() {
        return reservationType;
    }

    public ReservationStatus getReservationStatus() {
        return reservationStatus;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        this.reservationStatus = reservationStatus;
    }

    // toSTring() can be used for logging and debugging.
    @Override
    public String toString() {
        return "Reservation{" +
                "reservationId='" + reservationId + '\'' +
                ", user=" + user +
                ", vehicle=" + vehicle +
                ", bookingDate=" + bookingDate +
                ", dateBookedFrom=" + dateBookedFrom +
                ", dateBookedTo=" + dateBookedTo +
                ", pickUpLocation=" + pickUpLocation +
                ", dropLocation=" + dropLocation +
                ", reservationType=" + reservationType +
                ", reservationStatus=" + reservationStatus +
                '}';
    }
}
