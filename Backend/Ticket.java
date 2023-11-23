package Backend;
public class Ticket {
    private int ticketNumber;
    private String passengerName;
    private Seat seat;
    private double ticketPrice;

    // Constructor
    public Ticket(int ticketNumber, String passengerName, Seat seat, double ticketPrice) {
        this.ticketNumber = ticketNumber;
        this.passengerName = passengerName;
        this.seat = seat;
        this.ticketPrice = ticketPrice;
    }

    // Getter methods
    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public Seat getSeat() {
        return seat;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }

    // Setter methods
    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public void setTicketPrice(double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }
}
