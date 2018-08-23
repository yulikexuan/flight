//: com.expedia.flight.domain.services.IFlightService.java


package com.expedia.flight.domain.services;


import com.expedia.flight.domain.model.Flight;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;
import java.util.List;


public interface IFlightService {

    DateTimeFormatter TIME_FORMATTER =
            new DateTimeFormatterBuilder()
                    .appendText(ChronoField.CLOCK_HOUR_OF_AMPM)
                    .appendLiteral(":")
                    .appendText(ChronoField.MINUTE_OF_HOUR)
                    .parseCaseInsensitive()
                    .appendText(ChronoField.AMPM_OF_DAY)
                    .toFormatter();

    DateTimeFormatter SIMPLE_TIME_FORMATTER =
            new DateTimeFormatterBuilder()
                    .appendText(ChronoField.CLOCK_HOUR_OF_AMPM)
                    .parseCaseInsensitive()
                    .appendText(ChronoField.AMPM_OF_DAY)
                    .toFormatter();

    List<String> serachFlightForDeparture(LocalTime departureTime);

} ///:~
