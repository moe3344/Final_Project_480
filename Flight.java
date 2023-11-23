import java.util.Date;

public class Flight {
    private int flightNumber;
    private String flightStartPoint;
    private String flightDest;

    private int availableSeats;
    private double flightCost;
    private Date flightArrivalTime;
    private Date flightLeavingTime;

    // Constructor
    public Flight(int flightNumber, String flightStartPoint, String flightDest, int availableSeats,
                  double flightCost, Date flightArrivalTime, Date flightLeavingTime) {
        this.flightNumber = flightNumber;
        this.flightStartPoint = flightStartPoint;
        this.flightDest = flightDest;
        this.availableSeats = availableSeats;
        this.flightCost = flightCost;
        this.flightArrivalTime = flightArrivalTime;
        this.flightLeavingTime = flightLeavingTime;
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

    public int getAvailableSeats() {
        return availableSeats;
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

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
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

    // Other methods if needed
    // ...
}
