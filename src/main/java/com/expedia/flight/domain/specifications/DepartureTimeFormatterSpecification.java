//: com.expedia.flight.domain.specifications.DepartureTimeFormatterSpecification.java


package com.expedia.flight.domain.specifications;


import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

public class DepartureTimeFormatterSpecification {

    static final DateTimeFormatter TIME_FORMATTER =
            new DateTimeFormatterBuilder()
                    .appendText(ChronoField.CLOCK_HOUR_OF_AMPM)
                    .appendLiteral(":")
                    .appendText(ChronoField.MINUTE_OF_HOUR)
                    .appendText(ChronoField.AMPM_OF_DAY)
                    .parseCaseInsensitive()
                    .toFormatter();

    public static boolean isSatisfiedBy(String time) {



        return false;
    }

} ///:~
