//: com.expedia.flight.api.v1.controllers.FlightController.java


package com.expedia.flight.api.v1.controllers;


import com.expedia.flight.domain.services.IFlightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/api/v1/flights")
public class FlightController {

    private final IFlightService flightService;

    @Autowired
    public FlightController(IFlightService flightService) {
        this.flightService = flightService;
    }

    @GetMapping("/{departure}")
    @ResponseStatus(HttpStatus.OK)
    public List<String> getAllFlightsForDepartureTime(
            @PathVariable String departure) {

        log.debug(departure);

        LocalTime departureTime = null;

        try {
            departureTime = LocalTime.parse(departure,
                    IFlightService.TIME_FORMATTER);
        } catch (DateTimeParseException e) {
            departureTime = LocalTime.parse(departure,
                    IFlightService.SIMPLE_TIME_FORMATTER);
        }

        List<String> flightInfo = this.flightService.serachFlightForDeparture(
                departureTime);


        return flightInfo;
    }

} ///:~
