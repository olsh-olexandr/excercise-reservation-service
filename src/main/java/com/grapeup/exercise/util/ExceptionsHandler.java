package com.grapeup.exercise.util;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@ControllerAdvice(basePackages = {"com.grapeup.exercise.controller"} )
public class ExceptionsHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        return ResponseEntity.status(INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}
