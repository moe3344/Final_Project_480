package com.airline.demo;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airline.demo.backend.UserManager;
import com.airline.demo.backend.Flight;


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

    @GetMapping("/flightData")
    public ArrayList<Flight> getAllFlightData() {
    
        globalUser.populateUsers();
        globalUser.browseFLights();
        return globalUser.returnFlights();
    }
}
