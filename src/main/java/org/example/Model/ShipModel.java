package org.example.Model;

public class ShipModel {
    private String mmsi;
    private double lon;
    private double lat;
    private double trueHead;

    public void setMmsi(String mmsi) {
        this.mmsi = mmsi;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setTrueHead(int trueHead) {
        this.trueHead = trueHead;
    }
}
