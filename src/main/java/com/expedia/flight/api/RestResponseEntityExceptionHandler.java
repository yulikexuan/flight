//: com.expedia.flight.api.RestResponseEntityExceptionHandler.java


package com.expedia.flight.api;


import com.expedia.flight.domain.services.ResourceNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.format.DateTimeParseException;


@ControllerAdvice
@RequestMapping(produces = "application/json; charset=UTF-8")
public class RestResponseEntityExceptionHandler extends
        ResponseEntityExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(
            Exception exception, WebRequest webRequest) {

        return new ResponseEntity<>(exception.getMessage(), new HttpHeaders(),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({DateTimeParseException.class})
    public ResponseEntity<Object> handleDateTimeParseException(
            Exception exception, WebRequest webRequest) {

        return new ResponseEntity<>("Invalid time format", new HttpHeaders(),
                HttpStatus.BAD_REQUEST);
    }

} ///:~
