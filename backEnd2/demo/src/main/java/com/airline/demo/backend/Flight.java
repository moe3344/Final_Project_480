package com.airline.demo.backend;


public class Flight {
    private int flightNumber;
    private String flightStartPoint;
    private String flightDest;

    private double flightCost;
    private String flightArrivalTime;
    private String flightLeavingTime;

    // Additional data members
    private String availableBusinessSeats;
    private String availableComfortSeats;
    private String availableOrdinarySeats;

    // Constructor
    public Flight(int flightNumber, String flightStartPoint, String flightDest,
            double flightCost, String flightArrivalTime, String flightLeavingTime,
            String availableBusinessSeats, String availableComfortSeats, String availableOrdinarySeats) {
        this.flightNumber = flightNumber;
        this.flightStartPoint = flightStartPoint;
        this.flightDest = flightDest;

        this.flightCost = flightCost;
        this.flightArrivalTime = flightArrivalTime;
        this.flightLeavingTime = flightLeavingTime;
        this.availableBusinessSeats = availableBusinessSeats;
        this.availableComfortSeats = availableComfortSeats;
        this.availableOrdinarySeats = availableOrdinarySeats;
    }

    // Getter methods
    public int getFlightNumber() {
        return flightNumber;
    }

    public String getFlightStartPoint() {
        return flightStartPoint;
    }

    public String getFlightDest() {
        return flightDest;
    }

    public double getFlightCost() {
        return flightCost;
    }

    public String getFlightArrivalTime() {
        return flightArrivalTime;
    }

    public String getFlightLeavingTime() {
        return flightLeavingTime;
    }

    // Additional getters and setters
    public String getAvailableBusinessSeats() {
        return availableBusinessSeats;
    }

    public void setAvailableBusinessSeats(String availableBusinessSeats) {
        this.availableBusinessSeats = availableBusinessSeats;
    }

    public String getAvailableComfortSeats() {
        return availableComfortSeats;
    }

    public void setAvailableComfortSeats(String availableComfortSeats) {
        this.availableComfortSeats = availableComfortSeats;
    }

    public String getAvailableOrdinarySeats() {
        return availableOrdinarySeats;
    }

    public void setAvailableOrdinarySeats(String availableOrdinarySeats) {
        this.availableOrdinarySeats = availableOrdinarySeats;
    }

    // Setter methods (if needed)
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setFlightStartPoint(String flightStartPoint) {
        this.flightStartPoint = flightStartPoint;
    }

    public void setFlightDest(String flightDest) {
        this.flightDest = flightDest;
    }

    public void setFlightCost(double flightCost) {
        this.flightCost = flightCost;
    }

    public void setFlightArrivalTime(String flightArrivalTime) {
        this.flightArrivalTime = flightArrivalTime;
    }

    public void setFlightLeavingTime(String flightLeavingTime) {
        this.flightLeavingTime = flightLeavingTime;
    }

}
