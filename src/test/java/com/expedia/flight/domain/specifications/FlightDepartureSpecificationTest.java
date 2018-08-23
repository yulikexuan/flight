//: com.expedia.flight.domain.specifications.FlightDepartureSpecificationTest.java


package com.expedia.flight.domain.specifications;


import com.expedia.flight.domain.model.Flight;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalTime;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


public class FlightDepartureSpecificationTest {

    private Flight flight;
    private Flight altFlight;
    private LocalTime departure;

    @Before
    public void setUp() throws Exception {
        this.flight = new Flight();
        this.altFlight = new Flight();
    }

    @Test
    public void able_To_Figure_Out_If_A_Flight_Is_Satisfied_By_A_Departure_Time_In_The_Morning() throws Exception {

        // Given
        this.departure = LocalTime.of(3, 1);
        this.flight.setDeparture(LocalTime.of(8, 0));
        this.altFlight.setDeparture(LocalTime.of(22, 2));

        // When
        boolean satisfied = FlightDepartureSpecification.isSatisfied(
                this.flight, this.departure);
        boolean altSatisfied = FlightDepartureSpecification.isSatisfied(
                this.altFlight, this.departure);

        // Then
        assertThat(satisfied, is(true));
        assertThat(altSatisfied, is(true));
    }

    @Test
    public void able_To_Figure_Out_If_A_Flight_Is_Not_Satisfied_By_A_Departure_Time_Morning() throws Exception {

        // Given
        this.departure = LocalTime.of(3, 0);
        this.flight.setDeparture(LocalTime.of(8, 0));
        this.altFlight.setDeparture(LocalTime.of(22, 0));

        // When
        boolean satisfied = FlightDepartureSpecification.isSatisfied(
                this.flight, this.departure);
        boolean altSatisfied = FlightDepartureSpecification.isSatisfied(
                this.altFlight, this.departure);

        // Then
        assertThat(satisfied, is(false));
        assertThat(altSatisfied, is(false));
    }

    @Test
    public void able_To_Figure_Out_If_A_Flight_Is_Satisfied_By_A_Departure_Time_In_The_Night() throws Exception {

        // Given
        this.departure = LocalTime.of(22, 59);
        this.flight.setDeparture(LocalTime.of(3, 58));
        this.altFlight.setDeparture(LocalTime.of(18, 0));

        // When
        boolean satisfied = FlightDepartureSpecification.isSatisfied(
                this.flight, this.departure);
        boolean altSatisfied = FlightDepartureSpecification.isSatisfied(
                this.altFlight, this.departure);

        // Then
        assertThat(satisfied, is(true));
        assertThat(altSatisfied, is(true));
    }

    @Test
    public void able_To_Figure_Out_If_A_Flight_Is_Not_Satisfied_By_A_Departure_Time_In_The_Night() throws Exception {

        // Given
        this.departure = LocalTime.of(23, 1);
        this.flight.setDeparture(LocalTime.of(4, 1));
        this.altFlight.setDeparture(LocalTime.of(18, 1));

        // When
        boolean satisfied = FlightDepartureSpecification.isSatisfied(
                this.flight, this.departure);
        boolean altSatisfied = FlightDepartureSpecification.isSatisfied(
                this.altFlight, this.departure);

        // Then
        assertThat(satisfied, is(false));
        assertThat(altSatisfied, is(false));
    }

    @Test
    public void able_To_Figure_Out_If_A_Flight_Is_Satisfied_By_A_Departure_Time_In_The_Noon() throws Exception {

        // Given
        this.departure = LocalTime.of(12, 0);
        this.flight.setDeparture(LocalTime.of(16, 59));
        this.altFlight.setDeparture(LocalTime.of(7, 1));

        // When
        boolean satisfied = FlightDepartureSpecification.isSatisfied(
                this.flight, this.departure);
        boolean altSatisfied = FlightDepartureSpecification.isSatisfied(
                this.altFlight, this.departure);

        // Then
        assertThat(satisfied, is(true));
        assertThat(altSatisfied, is(true));
    }

    @Test
    public void able_To_Figure_Out_If_A_Flight_Is_Not_Satisfied_By_A_Departure_Time_In_The_Noon() throws Exception {

        // Given
        this.departure = LocalTime.of(12, 0);
        this.flight.setDeparture(LocalTime.of(17, 0));
        this.altFlight.setDeparture(LocalTime.of(7, 0));

        // When
        boolean satisfied = FlightDepartureSpecification.isSatisfied(
                this.flight, this.departure);
        boolean altSatisfied = FlightDepartureSpecification.isSatisfied(
                this.altFlight, this.departure);

        // Then
        assertThat(satisfied, is(false));
        assertThat(altSatisfied, is(false));
    }

    @Test
    public void not_Satisfied_By_Null_Flight_Or_Departure_Time() throws Exception {

        // When & Then
        assertThat(FlightDepartureSpecification.isSatisfied(
                new Flight(), null), is(false));
        assertThat(FlightDepartureSpecification.isSatisfied(
                null, LocalTime.now()), is(false));
    }

}///:~