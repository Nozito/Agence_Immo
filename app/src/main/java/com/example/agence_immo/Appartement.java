package com.example.agence_immo;

import java.io.Serializable;

public class Appartement implements Serializable {
    private String street;
    private String city;
    private String postalCode;
    private int floor;
    private boolean hasElevator;

    public Appartement(String street, String city, String postalCode, int floor, boolean hasElevator) {
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.floor = floor;
        this.hasElevator = hasElevator;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public int getFloor() {
        return floor;
    }

    public boolean hasElevator() {
        return hasElevator;
    }
}