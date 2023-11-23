package Backend;
public class User {
    private int selectedFlight;
    private double dueAmount;
    private String name;
    private int phone;
    private Address address;
    private Card creditCard;
    private Seat selectedSeat;
    private Ticket selectedTicket;
    private Receipt customerReceipt;

    // Constructor (you can add it if needed)
    
    // Getter methods
    public int getSelectedFlight() {
        return selectedFlight;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public String getName() {
        return name;
    }

    public int getPhone() {
        return phone;
    }

    public Address getAddress() {
        return address;
    }

    public Card getCreditCard() {
        return creditCard;
    }

    public Seat getSelectedSeat() {
        return selectedSeat;
    }

    public Ticket getSelectedTicket() {
        return selectedTicket;
    }

    public Receipt getCustomerReceipt() {
        return customerReceipt;
    }

    // Setter methods
    public void setSelectedFlight(int selectedFlight) {
        this.selectedFlight = selectedFlight;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void setCreditCard(Card creditCard) {
        this.creditCard = creditCard;
    }

    public void setSelectedSeat(Seat selectedSeat) {
        this.selectedSeat = selectedSeat;
    }

    public void setSelectedTicket(Ticket selectedTicket) {
        this.selectedTicket = selectedTicket;
    }

    public void setCustomerReceipt(Receipt customerReceipt) {
        this.customerReceipt = customerReceipt;
    }
}