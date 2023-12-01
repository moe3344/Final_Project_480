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
    private boolean payement = false;

    // JDBC URL, username, and password of MySQL server

    private static final String JDBC_URL = "jdbc:mysql://localhost/ewr";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "0953326601";

    // Private constructor to prevent instantiation from outside the class
    private UserManager() {

        // Initialization code, if needed
    }

    public User getCurrentUser() {
        return this.currentUser;
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
                        results.getString("FlightArrivalTime"), results.getString("FlightLeavingTime"),
                        results.getString("bookedBusinessSeats"), results.getString("bookedComfortSeats"),
                        results.getString("bookedOrdinarySeats"));

                // Adding read object to the arraylist of animals
                myFlights.add(newFlight);

            }
            /*
             * for (Flight o : myFlights) {
             * System.out.print("    *   flightid: " + o.getFlightNumber());
             * System.out.print("    *   flight start point: " + o.getFlightStartPoint());
             * System.out.print("    *   flight Destenation point: " + o.getFlightDest());
             * System.out.print("    *   flight cost is:" + o.getFlightCost());
             * System.out.println();
             * System.out.println();
             * }
             */

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // Login method using JDBC
    public boolean login(String nameUser, String pass) {

        int x = 1;
        for (User o : users) {
            if (o.getName().equals(nameUser)) {

                currentUser = o;
                currentUser.setUserID(1);
                x++;
            }
        }

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM logedusers WHERE username = ? AND password = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, nameUser); // Set username first
                preparedStatement.setString(2, pass); // Set password second
                try (ResultSet resultSet = preparedStatement.executeQuery()) {

                    return resultSet.next(); // true if a matching user is found

                }
            }
        } catch (SQLException e) {
            System.out.println("Please sign up first"); // Handle the exception according to your needs
            return false;
        }

    }

    public void cancelFlight() {
        int canceledUserID = currentUser.getUserID();
        Seat canceledSeat = currentUser.getSelectedSeat();

        for (User s : users) {
            if (s.getName().equals(currentUser.getName())) {
                s.setSelectedFlight(null);
                s.setSelectedSeat(null);
                s.setDueAmount(0);
            }
        }

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            String updateQuery = "UPDATE logedusers SET "
                    + "dueAmount=?, "
                    + "selectedSeat=?, flightID=?, flightCost=?, flightDest=?, flightStartPoint=? "
                    + "WHERE username=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setDouble(1, 0); // Set dueAmount at index 1

                preparedStatement.setString(2, ""); // Set selectedSeat at index 2
                preparedStatement.setInt(3, 0); // Set flightID at index 3
                preparedStatement.setDouble(4, 0); // Set flightCost at index 4
                preparedStatement.setString(5, ""); // Set flightDest at index 5
                preparedStatement.setString(6, ""); // Set flightStartPoint at index 6

                preparedStatement.setString(7, currentUser.getName()); // Set the username in the WHERE clause

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Update successful!");
                } else {
                    System.out.println("No user found with the given username.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
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

    public void userBookFlight(boolean userInsurance, int receiptNumber, int SeatNumber, String SeatLetter,
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
        System.out.println("selectedflight" + userSelectedFlight.getFlightDest());

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

            Ticket userTicket = new Ticket(currentUser.getName(), userSeat,
                    totalAmount, userSelectedFlight.getFlightDest(), userSelectedFlight.getFlightStartPoint());
            currentUser.setSelectedTicket(userTicket);
            System.out.println("payment done");
            this.payement = true;
        } else {
            System.out.println("payment declined");
            this.payement = false;
        }
        updateUserdata();
        updateFlightdata();

    }

    public void updateFlightdata() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            String updateQuery = "UPDATE FLIGHTS SET ";

            switch (currentUser.getSelectedSeat().getSeatType()) {
                case "Business":

                    updateQuery += "bookedBusinessSeats = CONCAT(bookedBusinessSeats, ?)";
                    break;
                case "Comfort":
                    updateQuery += "bookedComfortSeats = CONCAT(bookedComfortSeats, ?)";
                    break;
                case "Ordinary":
                    updateQuery += "bookedOrdinarySeats = CONCAT(bookedOrdinarySeats, ?)";
                    break;
                default:
                    System.out.println("Invalid seat type");
                    return;
            }
            String x = "-" + currentUser.getSelectedSeat().stringSeat();
            updateQuery += " WHERE FlightID = ?";

            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, x);
                preparedStatement.setInt(2, currentUser.getSelectedFlight().getFlightNumber());

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Update successful!");
                } else {
                    System.out.println("No flight found with the given FlightID.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateUserdata() {

        try (Connection connection = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASSWORD)) {
            String updateQuery = "UPDATE logedusers SET "
                    + "password=?, dueAmount=?, phone=?, address=?, "
                    + "selectedSeat=?, flightID=?, flightCost=?, flightDest=?, flightStartPoint=? "
                    + "WHERE username=?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
                preparedStatement.setString(1, currentUser.getPassword());
                preparedStatement.setDouble(2, currentUser.getDueAmount());
                preparedStatement.setString(3, currentUser.getPhone());
                preparedStatement.setString(4, currentUser.getAddress().stringAddress());
                preparedStatement.setString(5, currentUser.getSelectedSeat().stringSeat());
                preparedStatement.setInt(6, currentUser.getSelectedFlight().getFlightNumber());
                preparedStatement.setDouble(7, currentUser.getSelectedFlight().getFlightCost());
                preparedStatement.setString(8, currentUser.getSelectedFlight().getFlightDest());
                preparedStatement.setString(9, currentUser.getSelectedFlight().getFlightStartPoint());
                preparedStatement.setString(10, currentUser.getName()); // Set the username in the WHERE clause

                int rowsAffected = preparedStatement.executeUpdate();

                if (rowsAffected > 0) {
                    System.out.println("Update successful!");
                } else {
                    System.out.println("No user found with the given username.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean validatePayment(Card creditCard) {
        if (creditCard.getCardNumber().length() == 16) {
            String comparisonDate = "11-23";
            String inputDate = creditCard.getExpirationDate();

            // Compare the year part
            String[] inputParts = inputDate.split("-");
            String[] comparisonParts = comparisonDate.split("-");

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

        // boolean signupResult = userManager.signUp("Dennis", "1235");
        // if (signupResult) {
        // System.out.println("Signup successful!");
        // }

        // for (User x : userManager.getUsers()) {
        // System.out.println("dd" + x.getName());
        // }

        boolean loginResult = userManager.login("jayden", "1235");
        if (loginResult) {
            System.out.println("Login successful!");
            System.out.println("current user is " +
                    userManager.getCurrentUser().getName());
        }
        System.out.println("current user sign is " +
                userManager.getCurrentUser().getName());
        // else {
        // System.out.println("fucked up ");
        // }
        FlightAttendant attendant = new FlightAttendant("Hello", "123");

        userManager.browseFLights();
        userManager.userBookFlight(true, 12, 1, "A", 2, "4038883344", "Calgary",
                "Canada", "AB", "T3E 3e2", "university drive",
                "1234534",
                "1234543643214567", "07-27", 888);
        attendant.showPassengerList(userManager.getUsers());
        userManager.cancelFlight();
        // String number =
        // userManager.getCurrentUser().getCreditCard().getCardNumber();
        // boolean x =
        // userManager.validatePayment(userManager.getCurrentUser().getCreditCard());
        // System.out.println("x is " + number);

    }
}
