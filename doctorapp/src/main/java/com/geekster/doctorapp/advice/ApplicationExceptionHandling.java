package com.geekster.doctorapp.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationExceptionHandling {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<Object, Object> validateInvalidField(MethodArgumentNotValidException exception){
        Map<Object, Object> resMap = new HashMap<>();
        Map<Object, Object> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(error->{
            errorMap.put(error.getField(), error.getDefaultMessage());
        });
        resMap.put("message","Validation Failed");
        resMap.put("error",errorMap);
        resMap.put("status",HttpStatus.BAD_REQUEST);
        return resMap;
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<Object, Object> validateHttpMethodRequest(HttpRequestMethodNotSupportedException exception){
        Map<Object, Object> resMap = new HashMap<>();
        Map<Object, Object> errorMap = new HashMap<>();
        resMap.put("message",exception.getMessage());
        resMap.put("error",errorMap);
        resMap.put("status",HttpStatus.BAD_REQUEST);
        return resMap;
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<Object, Object>  validateHttpMethodRequest(Exception exception){
        Map<Object, Object> resMap = new HashMap<>();
        Map<Object, Object> errorMap = new HashMap<>();
        resMap.put("message",exception.getMessage());
        resMap.put("error",errorMap);
        resMap.put("status",HttpStatus.BAD_REQUEST);
        return resMap;
    }

}
