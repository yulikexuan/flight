//: com.expedia.flight.domain.services.FlightService.java


package com.expedia.flight.domain.services;


import com.expedia.flight.domain.respositories.IFlightRepository;
import com.expedia.flight.domain.specifications.FlightDepartureSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class FlightService implements IFlightService {

    private final IFlightRepository flightRepository;

    @Autowired
    public FlightService(IFlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public List<String> serachFlightForDeparture(
            final LocalTime departureTime) {

        if (departureTime == null) {
            return new ArrayList<>();
        }

        List<String> result = this.flightRepository.findAll().stream()
                .filter(f -> FlightDepartureSpecification.isSatisfied(
                        f, departureTime))
                .map(f -> String.format("%1$s --> %2$s", f.getName(),
                        TIME_FORMATTER.format(f.getDeparture())))
                .collect(Collectors.toList());

        if (result.isEmpty()) {
            throw new ResourceNotFoundException("No flight found!");
        }

        return result;
    }

} ///:~
