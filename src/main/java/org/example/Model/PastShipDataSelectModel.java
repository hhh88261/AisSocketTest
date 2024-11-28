package org.example.Model;

import java.math.BigDecimal;

public class PastShipDataSelectModel {
    private String mmsi;
    private BigDecimal lon;
    private BigDecimal lat;

    // Getters and Setters
    public String getMmsi() {
        return mmsi;
    }

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    public BigDecimal getLon() {
        return lon;
    }

    public void setLon(BigDecimal lon) {
        this.lon = lon;
    }

    public BigDecimal getLat() {
        return lat;
    }

    public void setLat(BigDecimal lat) {
        this.lat = lat;
    }

}
