//: com.expedia.flight.api.v1.controllers.FlightControllerIT.java


package com.expedia.flight.api.v1.controllers;


import com.expedia.flight.domain.services.IFlightService;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(controllers = {FlightController.class})
public class FlightControllerIT {


    @MockBean
    private IFlightService flightService;

    @Autowired
    private MockMvc mockMvc;

    private String url;

    @Before
    public void setUp() throws Exception {
        this.url = "http://127.0.0.1:8080/api/v1/flights/12:00am";
    }

    @Test
    public void able_To_Get_Fllght_Info() throws Exception {

        // Given
        List<String> infos = new ArrayList<>();
        String flightInfo = UUID.randomUUID().toString();
        infos.add(flightInfo);
        given(this.flightService.serachFlightForDeparture(any(LocalTime.class)))
                .willReturn(infos);

        // When & Then
        this.mockMvc.perform(get(url)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}///:~