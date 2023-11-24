public class Seat {
    private double seatCost =70.0;
    private int seatNumber;
    private String seatLetter;

    // Constructor
    public Seat(int seatNumber, String seatType) {
        this.seatNumber = seatNumber;
        this.seatLetter = seatType;
    }

    // Getter methods
    public int getSeatNumber() {
        return seatNumber;
    }

    public String getSeatLetter() {
        return seatLetter;
    }

    // Setter methods
    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setSeatType(String seatType) {
        this.seatLetter = seatType;
    }
    public double seatCost(){
        if (seatNumber<=2){
            return 2.1*seatCost;
        }
        else if (seatNumber>2 &&seatNumber<=6){
            return (0.4 * seatCost);
        }
        
        return seatCost;
    }