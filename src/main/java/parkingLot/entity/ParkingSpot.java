package parkingLot.entity;

public class ParkingSpot {
    private final String spotId;
    private boolean isFree = true;

    public ParkingSpot(String spotId) {
        this.spotId = spotId;
    }

    public boolean isSpotFree(){
        return isFree;
    }

    public void occupySlot() {
        this.isFree = false;
    }

    public void releaseSpot() {
        this.isFree = true;
    }

    public String getSpotId() {
        return spotId;
    }
}
