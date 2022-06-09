package com.example.server;

public class Pharmacy {

    private String pharmaId;
    private String name;
    private String latitude;
    private String longitude;

    public Pharmacy(String pharmaId, String name, String latitude, String longitude) {
        this.pharmaId = pharmaId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getPharmaId() {
        return pharmaId;
    }

    public void setPharmaId(String pharmaId) {
        this.pharmaId = pharmaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "Pharmacy{" +
                "pharmaId='" + pharmaId + '\'' +
                ", name='" + name + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                '}';
    }

}
