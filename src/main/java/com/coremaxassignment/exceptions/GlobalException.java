package com.coremaxassignment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> resourceNotFoundHandler(Exception e){
        Map<String,String> res = new HashMap<>();
        res.put("message",e.getLocalizedMessage());
        return new ResponseEntity<>(res, HttpStatus.NOT_FOUND);
    }
}
