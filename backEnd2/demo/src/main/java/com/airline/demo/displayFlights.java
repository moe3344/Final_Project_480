package com.airline.demo;
import java.util.Date;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/flight")
public class displayFlights {

    @GetMapping("/info")
    public String greeting() {
        Flight newFlight = new Flight(10, "test", "test1",
                  10.2, new Date(), new Date(),
                  10, 10, 10);
        return newFlight.getFlightStartPoint();
    }
    
}
