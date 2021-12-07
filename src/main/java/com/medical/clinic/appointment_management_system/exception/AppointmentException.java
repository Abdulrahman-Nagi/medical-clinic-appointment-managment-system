package com.medical.clinic.appointment_management_system.exception;
import java.net.URI;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AppointmentException extends RuntimeException {

    private static final long serialVersionUID = 1L;


    private final HttpStatus statusCode;
    private final String errorType;
    private final String errorMessage;
    private final URI exceptionUri;


    public AppointmentException(HttpStatus statusCode, String errorType, String errorMessage, URI exceptionUri) {
        super(errorMessage);
        this.statusCode = statusCode;
        this.errorType = errorType;
        this.errorMessage = errorMessage;
        this.exceptionUri = URI.create("about:blank");
    }
}

