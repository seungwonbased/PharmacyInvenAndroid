package com.example.server;

import java.io.Serializable;

public class Pharmacy implements Serializable{

    private String pharmaId;
    private String name;
    private String latitude;
    private String longitude;
    private String phone;

    public Pharmacy(String pharmaId, String name, String latitude, String longitude, String phone) {
        this.pharmaId = pharmaId;
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.phone = phone;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
