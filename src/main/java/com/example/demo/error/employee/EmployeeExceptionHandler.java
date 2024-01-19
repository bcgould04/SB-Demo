package com.example.demo.error.employee;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc) {
        EmployeeErrorResponse error = new EmployeeErrorResponse();

        error.setStatus((HttpStatus.NOT_FOUND.value()));
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return ResponseEntity.badRequest().body(error);
    }

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(Exception exc) {
        EmployeeErrorResponse error = new EmployeeErrorResponse();

        error.setStatus((HttpStatus.BAD_REQUEST.value()));
        error.setMessage(exc.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        return ResponseEntity.badRequest().body(error);
    }
}
