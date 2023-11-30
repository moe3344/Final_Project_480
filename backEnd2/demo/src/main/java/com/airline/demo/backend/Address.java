package com.airline.demo.backend;

public class Address {
    private String streetNumber;
    private String streetName;
    private String city;
    private String state;
    private String zipCode;
    private String country;

    // Constructor
    public Address(String streetNumber, String streetName, String city, String state, String zipCode, String country) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }

    // Getter methods
    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCountry() {
        return country;
    }

    // Setter methods
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String stringAddress() {
        String selAddress = streetNumber + " " + streetName + " , " + city + " , " + country;
        return selAddress;
    }
}
