package com.airline.demo.backend;

public class Seat {
    private int seatNumber;
    private String seatType;
    private double seatCost = 100;

    // Constructor
    public Seat(int seatNumber, String seatType) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;

    }

    // Getter methods
    public int getSeatNumber() {
        return seatNumber;
    }

    // Setter methods
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }

    public double getSeatCost() {
        if (seatNumber <= 2) {
            return ((double) 2.1 * seatCost);
        } else if (seatNumber < 7) {
            return ((double) 1.4 * seatCost);
        } else
            return 100;
    }

    public String getSeatType() {
        if (this.seatNumber <= 2) {
            return "Business";
        } else if (seatNumber < 7) {
            return "Comfort";
        } else
            return "Ordinary";
    }

    public String stringSeat() {
        String selSeat = seatNumber + seatType;
        return selSeat;
    }

}