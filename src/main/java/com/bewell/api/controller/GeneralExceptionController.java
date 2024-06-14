package com.bewell.api.controller;

import com.bewell.api.common.ErrorMessage;
import com.bewell.api.common.GeneralException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GeneralExceptionController {
    @ExceptionHandler(value = GeneralException.class)
    public ResponseEntity<ErrorMessage> exception(GeneralException exception) {
        return new ResponseEntity<>(ErrorMessage.builder().errorMessage(exception.getMessage()).build(), HttpStatus.BAD_REQUEST);
    }
}

