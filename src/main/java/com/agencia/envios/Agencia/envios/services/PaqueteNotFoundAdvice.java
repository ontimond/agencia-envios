package com.agencia.envios.Agencia.envios.services;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class PaqueteNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(PaqueteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String employeeNotFoundHandler(PaqueteNotFoundException ex) {
        return ex.getMessage();
    }
}
