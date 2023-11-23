package Backend;
public class Seat {
    private String seatNumber;
    private String seatType;

    // Constructor
    public Seat(String seatNumber, String seatType) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
    }

    // Getter methods
    public String getSeatNumber() {
        return seatNumber;
    }

    public String getSeatType() {
        return seatType;
    }

    // Setter methods
    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setSeatType(String seatType) {
        this.seatType = seatType;
    }
}
