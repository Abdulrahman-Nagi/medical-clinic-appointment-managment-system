package com.medical.clinic.appointment_management_system.exception.handler;


import com.medical.clinic.appointment_management_system.exception.AppointmentException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice(basePackages = {
    "com.medical.clinic.appointment_management_system.controller"})
public class AppointmentExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AppointmentException.class)
    public ResponseEntity<Object> handleException(AppointmentException exception) {

        return ResponseEntity.status(exception.getStatusCode()).body(exception);
    }

}
