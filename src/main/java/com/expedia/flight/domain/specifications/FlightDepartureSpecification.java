//: com.expedia.flight.domain.FlightDepartureSpecification.java


package com.expedia.flight.domain.specifications;


import com.expedia.flight.domain.model.Flight;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;


public class FlightDepartureSpecification {

    public static final int TIME_WIN_DISTANCE_HOURS = 5;

    public static boolean isSatisfied(Flight flight, LocalTime departure) {

        if ((flight == null) || (departure ==null)) {
            return false;
        }

        LocalDate today = LocalDate.now();

        LocalDateTime departureDateTime = LocalDateTime.of(today, departure);
        LocalDateTime timeWinStart = departureDateTime.minusHours(
                TIME_WIN_DISTANCE_HOURS);
        LocalDateTime timeWinEnd = departureDateTime.plusHours(
                TIME_WIN_DISTANCE_HOURS);

        LocalTime flightDeparture = flight.getDeparture();

        LocalDateTime flightDepartureTimeForWinStartDate = LocalDateTime.of(
                timeWinStart.toLocalDate(), flightDeparture);
        LocalDateTime flightDepartureTimeForWinEndDate = LocalDateTime.of(
                timeWinEnd.toLocalDate(), flightDeparture);

        boolean isSatisfiedLeft =
                flightDepartureTimeForWinStartDate.isAfter(timeWinStart) &&
                        flightDepartureTimeForWinStartDate.isBefore(timeWinEnd);

        boolean isSatisfiedRight =
                flightDepartureTimeForWinEndDate.isAfter(timeWinStart) &&
                        flightDepartureTimeForWinEndDate.isBefore(timeWinEnd);

        return isSatisfiedLeft || isSatisfiedRight;
    }

} ///:~
