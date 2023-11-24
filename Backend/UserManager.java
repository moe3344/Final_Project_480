package Backend;

import java.sql.*;
import java.util.ArrayList;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Backend.Address;
import Backend.Flight;
import Backend.Receipt;
import Backend.Seat;
import Backend.Ticket;

public class UserManager {

    private static UserManager instance;
    protected ArrayList<Flight> myFlights = new ArrayList<>();
    protected ResultSet results;
    protected Connection dbConnect;

    // JDBC URL, username, and password of MySQL server

    private static final String JDBC_URL = "jdbc:mysql://localhost/ewr";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "0953326601";
    private int selectedFlight;
    private double dueAmount;
    private String name;
    private String password;
    private int phone;
    private Address address;
    private Card creditCard;
    private Seat selectedSeat;
    private Ticket selectedTicket;
    private Receipt customerReceipt;

    // Constructor (you can add it if needed)
    private UserManager(String name, String pass) {
        this.name = name;
        this.password = pass;
    }

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

    // Private constructor to prevent instantiation from outside the class
    private UserManager() {
        // Initialization code, if needed
    }

    // Public method to get the single instance of UserManager
    public static synchronized UserManager getInstance() {
        if (instance == null) {
            instance = new UserManager();
        }
        return instance;
    }

    public void setNameAndPassword(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void browseFLights() {

        try {
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/ewr", "root", "0953326601");

            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM flights");

            while (results.next()) {

                Flight newFlight = new Flight(results.getInt("FlightID"), results.getString("FlightStartPoint"),
                        results.getString("FlightDest"), results.getDouble("FlightCost"),
                        results.getDate("FlightArrivalTime"), results.getDate("FlightLeavingTime"),
                        results.getInt("AvailableBusinessSeats"), results.getInt("AvailableComfortSeats"),
                        results.getInt("AvailableOrdinarySeats"));

                // Adding read object to the arraylist of animals
                myFlights.add(newFlight);

            }
            for (Flight o : myFlights) {
                System.out.print("    *   flight start point: " + o.getFlightStartPoint());
                System.out.print("    *   flight Destenation point: " + o.getFlightDest());
                System.out.print("    *   flight cost is:" + o.getFlightCost());
                System.out.println();
                System.out.println();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Login method using JDBC
    public boolean login() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM users WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, this.name);
                preparedStatement.setString(2, this.password);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    return resultSet.next(); // true if a matching user is found
                }
            }
        } catch (SQLException e) {
            System.out.println("please sign up!"); // Handle the exception according to your needs
            return false;
        }
    }

    // Signup method using JDBC
    public boolean signUp(String username, String password) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO users (username, password) VALUES (?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                int rowsAffected = preparedStatement.executeUpdate();
                return rowsAffected > 0; // true if the user is successfully inserted
            }
        } catch (SQLException e) {
            System.out.println("Please Log in!");// Handle the exception according to your needs
            return false;
        }
    }

    // Other methods and properties related to user management

    // Example usage:
    public static void main(String[] args) {
        UserManager userManager = UserManager.getInstance();
        userManager.setNameAndPassword("Mooud", "12345");
        // Example login
        boolean loginResult = userManager.login();
        if (loginResult) {
            System.out.println("Login successful!");
        } else {
            System.out.println("Login failed!");
        }

        // Example signup
        boolean signupResult = userManager.signUp("youtd", "145");
        if (signupResult) {
            System.out.println("Signup successful!");
        } else {
            System.out.println("Signup failed!");
        }
        userManager.browseFLights();
    }
}
