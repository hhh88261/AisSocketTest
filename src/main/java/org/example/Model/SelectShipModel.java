package org.example.Model;

public class SelectShipModel {

    private String shipDate;
    private String shipStartTime;
    private String shipEndTime;
    private String shipPastLon;
    private String shipPastLat;
    private String ShipPastMmsi;

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public void setShipStartTime(String shipStartTime) {
        this.shipStartTime = shipStartTime;
    }

    public void setShipEndTime(String shipEndTime) {
        this.shipEndTime = shipEndTime;
    }

    public String getShipDate() {
        return shipDate;
    }

    public String getShipPastMmsi() {
        return ShipPastMmsi;
    }

    public String getShipPastLon() {
        return shipPastLon;
    }

    public String getShipPastLat() {
        return shipPastLat;
    }

}
