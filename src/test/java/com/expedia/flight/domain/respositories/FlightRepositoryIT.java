//: com.expedia.flight.domain.respositories.FlightRepositoryIT.java


package com.expedia.flight.domain.respositories;


import com.expedia.flight.domain.model.Flight;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalTime;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class FlightRepositoryIT {

    @Autowired
    private IFlightRepository flightRepository;

    @Test
    public void able_To_Fetch_All_Flights() throws Exception {

        // When
        List<Flight> flights = this.flightRepository.findAll();

        // Then
        assertThat(flights.size(), is(4));
    }

    @Test
    public void able_To_Find_Flight_By_Departure_Time() throws Exception {

        // When
        Flight flight = this.flightRepository.findByDeparture(
                LocalTime.of(7, 30));

        // Then
        assertThat(flight.getName(), is("Air Canada 8099"));
    }

}///:~