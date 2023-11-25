package Backend;

public class User {

    private Flight selectedFlight;
    private double dueAmount;
    private String name;
    private String password;
    private String phone;
    private Address address;
    private Card creditCard;
    private Seat selectedSeat;
    private Ticket selectedTicket;
    private Receipt customerReceipt;

    public User(String userName, String password) {
        this.name = userName;
        this.password = password;

    }

    // Getter methods
    public Flight getSelectedFlight() {
        return selectedFlight;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
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
    public void setSelectedFlight(Flight selectedFlight) {
        this.selectedFlight = selectedFlight;
    }

    public void setFlightCost(double x) {
        this.dueAmount = x;
    }

    public void setDueAmount(double dueAmount) {
        this.dueAmount = dueAmount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
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
