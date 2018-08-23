//: com.expedia.flight.domain.respositories.IFlightRepository.java


package com.expedia.flight.domain.respositories;


import com.expedia.flight.domain.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalTime;


public interface IFlightRepository extends JpaRepository<Flight, Long> {

    Flight findByDeparture(LocalTime departure);

} ///:~
