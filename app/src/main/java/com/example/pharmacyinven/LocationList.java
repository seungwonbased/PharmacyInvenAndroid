package com.example.pharmacyinven;

public class LocationList {
    String name;
    double latitude;
    double longitude;

    public double getLatitude() {
        return latitude;
    }

    public String getName() {
        return name;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setName(String name) {
        this.name = name;
    }
}
