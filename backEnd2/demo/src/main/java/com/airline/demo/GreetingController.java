package com.airline.demo;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.demo.backend.UserManager;
import com.airline.demo.backend.Card;
import com.airline.demo.backend.Flight;
import com.airline.demo.backend.User;


@RestController
@RequestMapping("/api")
public class GreetingController {
    UserManager globalUser = UserManager.getInstance();

    @GetMapping("/greeting")
    public String greeting() {
        return "Hello! Welcome to our API gege.";
    }

    @GetMapping("/login/{username}/{password}")
    public boolean getDataById(@PathVariable String username, @PathVariable String password) {
        // Access the attached path variable (e.g., "/data/123" - id will be 123)
        System.out.println("Trying to Login With");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        boolean userFound = globalUser.login(username, password);
        return userFound;
    }

    @GetMapping("/signup/{username}/{password}")
    public boolean signUp(@PathVariable String username, @PathVariable String password) {
        // Access the attached path variable (e.g., "/data/123" - id will be 123)
        System.out.println("Trying to Sign Up With");
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        boolean userFound = globalUser.signUp(username, password);
        globalUser.populateUsers();
        return userFound;
    }

    @GetMapping("/getpayment/{username}/{password}")
    public boolean findPayment(@PathVariable String username, @PathVariable String password) {

        // Access the attached path variable (e.g., "/data/123" - id will be 123)
        System.out.println("Trying to Sign Up With");
        System.out.println("Username: " + username);
    
        System.out.println("Password: " + password);
        boolean userFound = globalUser.signUp(username, password);
        globalUser.populateUsers();
        return userFound;
    }

    @GetMapping("/flightData")
    public ArrayList<Flight> getAllFlightData() {
    
        globalUser.populateUsers();
        globalUser.browseFLights();
        return globalUser.returnFlights();
    }

    //boolean userInsurance, int receiptNumber, int SeatNumber, String SeatLetter,
    //int flightID,
    //  String state, String zipCode, String streetName,
    //String streetNumber,
    //String cardNumber, String expirationDate, int cvv

    @GetMapping("/pay/{cardNumber}/{expirationDate}/{cvvNumber}/{email}")
    public boolean payForTicket(@PathVariable String cardNumber, 
            @PathVariable String expirationDate, @PathVariable int cvvNumber, @PathVariable String email) {
        // Access the attached path variable (e.g., "/data/123" - id will be 123)
        System.out.println("Paying for ticket");
        System.out.println("card Number: " + cardNumber);
        System.out.println("Expiration Date: " + expirationDate);
        System.out.println("cvv Number: " + cvvNumber);
        System.out.println("email: " + email);
        Card usersCard = new Card(cardNumber, expirationDate, cvvNumber);
        boolean validPayment = globalUser.validatePayment(usersCard);
        if (!validPayment) {
            System.out.println("Payment Accepted");
            // TODO book the seat in the global user ie...
            String tempStuff = "temp";
            //globalUser.userBookFlight(false, 12, 1, "A", 3, tempStuff, tempStuff, tempStuff, 
            //                        tempStuff, tempStuff, tempStuff, tempStuff, cardNumber, expirationDate, cvvNumber);

            return true;
        }
        System.out.println("Payment Was not Accepted");
        return false;
    }

    @GetMapping("/makepayment")
    public boolean makePayment(
        @RequestHeader("username") String username, 
        @RequestHeader("password") String password,
        @RequestHeader("insurance") boolean hasInsurance,
        @RequestHeader("recieptNumber") int receiptNumber,
        @RequestHeader("seatNumber") int seatNumber,
        @RequestHeader("seatLetter") String seatLetter,
        @RequestHeader("flightId") int flightId,
        @RequestHeader("phoneNumber") String phoneNumber,
        @RequestHeader("city") String city,
        @RequestHeader("country") String country,
        @RequestHeader("state") String state,
        @RequestHeader("zipCode") String zipCode,
        @RequestHeader("streetName") String streetName,
        @RequestHeader("streetNumber") String streetNumber,
        @RequestHeader("cardNumber") String cardNumber,
        @RequestHeader("expirationDate") String expirationDate,
        @RequestHeader("cvvNumber") int cvvNumber) {
    // Your logic here

    System.out.println("Password: " + password);
    globalUser.populateUsers();
    globalUser.login(username, password);
    User buyWithUser = globalUser.loginReturnUser(username, password);
    globalUser.userBookFlight(hasInsurance, receiptNumber, seatNumber, seatLetter, flightId, phoneNumber, 
                            city, country, state, zipCode, streetName, streetNumber, cardNumber, 
                            expirationDate, cvvNumber, buyWithUser);
    return true;
    }
}
