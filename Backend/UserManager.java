package Backend;

import java.sql.*;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.Date;

import Backend.Address;
import Backend.Flight;
import Backend.Receipt;
import Backend.Seat;
import Backend.Ticket;

public class UserManager {
    private User currentUser;
    private ArrayList<User> users = new ArrayList<>();

    private static UserManager instance;
    protected ArrayList<Flight> myFlights = new ArrayList<>();
    protected ResultSet results;
    protected Connection dbConnect;
    private String name;
    private String password;
    private static int userID = 1;

    // JDBC URL, username, and password of MySQL server

    private static final String JDBC_URL = "jdbc:mysql://localhost/ewr";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "0953326601";

    // Private constructor to prevent instantiation from outside the class
    private UserManager() {

        // Initialization code, if needed
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void populateUsers() {
        try {
            dbConnect = DriverManager.getConnection("jdbc:mysql://localhost/ewr", "root", "0953326601");

            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM logedusers");

            while (results.next()) {

                User newUser = new User(results.getString("username"), results.getString("password"));

                // Adding read object to the arraylist of animals
                users.add(newUser);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
                System.out.print("    *   flightid: " + o.getFlightNumber());
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
    public boolean login(String nameUser, String pass) {
        for (User o : users) {
            if (o.getName().equals(nameUser)) {
                currentUser = o;
            }
        }

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM logedusers WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, nameUser); // Set username first
                preparedStatement.setString(2, pass); // Set password second
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        System.out.println("Log in successful");
                    }
                    return resultSet.next(); // true if a matching user is found

                }
            }
        } catch (SQLException e) {
            System.out.println("Please sign up first"); // Handle the exception according to your needs
            return false;
        }
    }

    public void createUser(String username, String password) {
        User newUser = new User(username, password);

        users.add(newUser);
        int index = users.indexOf(newUser);
        currentUser = users.get(index);

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO logedusers (password, username, dueAmount, phone, address, selectedSeat, flightID, flightCost, flightDest, flightStartPoint) VALUES (?,?,?,?,?,?,?,?,?,?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                // Set values or null as needed
                preparedStatement.setString(1, password);
                preparedStatement.setString(2, username);
                preparedStatement.setInt(3, 0); // Example value for dueAmount
                preparedStatement.setNull(4, java.sql.Types.VARCHAR); // Example value for phone as null
                preparedStatement.setNull(5, java.sql.Types.VARCHAR); // Example value for address as null
                preparedStatement.setNull(6, java.sql.Types.VARCHAR); // Example value for selectedSeat as null
                preparedStatement.setInt(7, 0); // Example value for flightID
                preparedStatement.setInt(8, 0); // Example value for flightCost
                preparedStatement.setNull(9, java.sql.Types.VARCHAR); // Example value for flightDest as null
                preparedStatement.setNull(10, java.sql.Types.VARCHAR); // Example value for flightStartPoint as null

                preparedStatement.executeUpdate();

            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your needs
        }
    }

    // Signup method using JDBC
    public boolean signUp(String username, String password) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            String query = "INSERT INTO users (userID, username, password) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userID); // Assuming userID is an integer
                preparedStatement.setString(2, username);
                preparedStatement.setString(3, password);

                int rowsAffected = preparedStatement.executeUpdate();
                createUser(username, password);
                // Increment the static field directly
                userID += 1;

                return rowsAffected > 0; // true if the user is successfully inserted
            }
        } catch (SQLException e) {

            System.out.println("Sign up Failed, it seems you have an account please log in");
            // according
            // to your needs
            return false;
        }
    }

    public boolean userBookFlight(boolean userInsurance, int receiptNumber, int SeatNumber, String SeatLetter,
            int flightID,
            String phone, String city, String country, String state, String zipCode, String streetName,
            String streetNumber,
            String cardNumber, String expirationDate, int cvv) {
        Address userAddress = new Address(streetNumber, streetName, city, state, zipCode, country);
        currentUser.setAddress(userAddress);
        currentUser.setPhone(phone);
        Card userCard = new Card(cardNumber, expirationDate, cvv);
        currentUser.setCreditCard(userCard);
        Flight userSelectedFlight = myFlights.get(flightID - 1);

        currentUser.setSelectedFlight(userSelectedFlight);
        Seat userSeat = new Seat(SeatNumber, SeatLetter);
        currentUser.setSelectedSeat(userSeat);
        double totalAmount = 0.0;
        if (userInsurance) {
            totalAmount = userSelectedFlight.getFlightCost() + userSeat.getSeatCost() + 150;
        } else {
            totalAmount = userSelectedFlight.getFlightCost() + userSeat.getSeatCost();
        }

        currentUser.setFlightCost(totalAmount);
        boolean validPayment = validatePayment(userCard);
        if (validPayment) {
            Date o = new Date();

            Receipt userReceipt = new Receipt(receiptNumber, o, totalAmount, "CreditCard");
            currentUser.setCustomerReceipt(userReceipt);

            Ticket userTicket = new Ticket(currentUser.getName(), userSelectedFlight.getFlightLeavingTime(), userSeat,
                    totalAmount, userSelectedFlight.getFlightDest(), userSelectedFlight.getFlightStartPoint());
            currentUser.setSelectedTicket(userTicket);
            return true;
        } else {
            System.out.println("payment declined");
            return false;
        }

    }

    public boolean validatePayment(Card creditCard) {
        if (creditCard.getCardNumber().length() == 16) {
            String comparisonDate = "11/2023";
            String inputDate = creditCard.getExpirationDate();

            // Compare the year part
            String[] inputParts = inputDate.split("/");
            String[] comparisonParts = comparisonDate.split("/");

            // Compare years
            int yearComparison = Integer.parseInt(inputParts[1]) - Integer.parseInt(comparisonParts[1]);
            if (yearComparison > 0) {
                return true;
            } else if (yearComparison < 0) {
                return false;
            } else {
                // Years are equal, check months
                int monthComparison = Integer.parseInt(inputParts[0]) - Integer.parseInt(comparisonParts[0]);
                if (monthComparison >= 0) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;

    }

    // Other methods and properties related to user management

    // Example usage:
    public static void main(String[] args) {
        UserManager userManager = UserManager.getInstance();
        userManager.populateUsers();

        // Example login

        // Example signup

        boolean signupResult = userManager.signUp("Mohamad_Hammoud", "5");
        // if (signupResult) {
        // System.out.println("Signup successful!");
        // }
        for (User x : userManager.getUsers()) {
            System.out.println("dd" + x.getName());
        }
        userManager.browseFLights();
        boolean loginResult = userManager.login("Mohamad_Hammoud", "5");
        if (loginResult) {
            System.out.println("Login successful!");

        } else {
            System.out.println("fucked up ");
        }

    }
}
