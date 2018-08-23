//: com.expedia.flight.domain.services.FlightServiceIT.java


package com.expedia.flight.domain.services;


import com.expedia.flight.bootstrap.Bootstrap;
import com.expedia.flight.domain.respositories.IFlightRepository;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalTime;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;


@Slf4j
@RunWith(SpringRunner.class)
@DataJpaTest
public class FlightServiceIT {

    @Autowired
    private IFlightRepository flightRepository;

    private FlightService flightService;

    @Before
    public void setUp() throws Exception {
        new Bootstrap(this.flightRepository).run();
        this.flightService = new FlightService(this.flightRepository);
    }

    @Test
    public void able_To_Get_Flight_Information_Accordint_To_Departure_Time() throws Exception {

        // Given
        LocalTime departure = LocalTime.of(6, 0);

        // When
        List<String> flightInfo = this.flightService.serachFlightForDeparture(
                departure);

        // Then
        assertThat(flightInfo.size(), is(2));
    }

}///:~