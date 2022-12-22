package com.example.finalproject.Advice;

import com.example.finalproject.Exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class CourseAdvice {
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity ApiException(ApiException s){
        String message=s.getMessage();
        return ResponseEntity.status(400).body(message);
    }
}
