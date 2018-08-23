//: com.expedia.flight.bootstrap.Bootstrap.java


package com.expedia.flight.bootstrap;


import com.expedia.flight.domain.model.Flight;
import com.expedia.flight.domain.respositories.IFlightRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;


@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    private final IFlightRepository flightRepository;

    @Autowired
    public Bootstrap(IFlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.loadFlights();
    }

    private void loadFlights() {

        Flight ac8099 = new Flight();
        ac8099.setName("Air Canada 8099");
        ac8099.setDeparture(LocalTime.of(7, 30));

        Flight ua6115 = new Flight();
        ua6115.setName("United Airline 6115");
        ua6115.setDeparture(LocalTime.of(10, 30));

        Flight wj6456 = new Flight();
        wj6456.setName("WestJet 6456");
        wj6456.setDeparture(LocalTime.of(12, 30));

        Flight dt3833 = new Flight();
        dt3833.setName("Delta 3833");
        dt3833.setDeparture(LocalTime.of(15, 0));

        this.flightRepository.save(ac8099);
        this.flightRepository.save(ua6115);
        this.flightRepository.save(wj6456);
        this.flightRepository.save(dt3833);

        log.debug(String.format("-------> Flights loaded = %d",
                this.flightRepository.count()));

    }// End of loadFlights

} ///:~
