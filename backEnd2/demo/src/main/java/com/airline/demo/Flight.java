package com.airline.demo;
import java.util.Date;


public class Flight {
    private int flightNumber;
    private String flightStartPoint;
    private String flightDest;

  
    private double flightCost;
    private Date flightArrivalTime;
    private Date flightLeavingTime;

    // Additional data members
    private int availableBusinessSeats;
    private int availableComfortSeats;
    private int availableOrdinarySeats;

    // Constructor
    public Flight(int flightNumber, String flightStartPoint, String flightDest,
                  double flightCost, Date flightArrivalTime, Date flightLeavingTime,
                  int availableBusinessSeats, int availableComfortSeats, int availableOrdinarySeats) {
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

    public Date getFlightArrivalTime() {
        return flightArrivalTime;
    }

    public Date getFlightLeavingTime() {
        return flightLeavingTime;
    }

    // Additional getters and setters
    public int getAvailableBusinessSeats() {
        return availableBusinessSeats;
    }

    public void setAvailableBusinessSeats(int availableBusinessSeats) {
        this.availableBusinessSeats = availableBusinessSeats;
    }

    public int getAvailableComfortSeats() {
        return availableComfortSeats;
    }

    public void setAvailableComfortSeats(int availableComfortSeats) {
        this.availableComfortSeats = availableComfortSeats;
    }

    public int getAvailableOrdinarySeats() {
        return availableOrdinarySeats;
    }

    public void setAvailableOrdinarySeats(int availableOrdinarySeats) {
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

    public void setFlightArrivalTime(Date flightArrivalTime) {
        this.flightArrivalTime = flightArrivalTime;
    }

    public void setFlightLeavingTime(Date flightLeavingTime) {
        this.flightLeavingTime = flightLeavingTime;
    }

    
}


