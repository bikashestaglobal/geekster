package com.geekster.hotel.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<Object, Object> handleArgumentNotValidException(MethodArgumentNotValidException exception){
        Map<Object, Object> errorMap = new HashMap<>();
        Map<Object, Object> resMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error->{
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        resMap.put("message", "Validation Failed");
        resMap.put("status", HttpStatus.BAD_REQUEST);
        resMap.put("error", errorMap);
        return resMap;
    }
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<Object, Object> handleException(Exception exception){
        Map<Object, Object> errorMap = new HashMap<>();
        Map<Object, Object> resMap = new HashMap<>();
        errorMap.put("error", exception.getMessage());
        resMap.put("message", "Validation Failed");
        resMap.put("status", HttpStatus.BAD_REQUEST);
        resMap.put("error", errorMap);
        return resMap;
    }
}
