package com.fiap.persistence.ecommerce.adapter.exception.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

@ControllerAdvice
class TBDExceptionHandler { // TODO TBD-ExceptionHandler

    @ExceptionHandler(value = BadRequest.class)
    public ResponseEntity<Object> badRequestException(BadRequest e){
        return null;
    }


}