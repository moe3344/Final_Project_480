package com.airline.demo;
import java.util.Date;
import com.airline.demo.backend.Flight;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flight")
public class displayFlights {

    @GetMapping("/info")
    public String greeting() {
        return "This is flight Info!!";
    }
    
}
