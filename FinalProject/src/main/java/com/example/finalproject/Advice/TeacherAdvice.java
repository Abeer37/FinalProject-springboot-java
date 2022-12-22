package com.example.finalproject.Advice;

import com.example.finalproject.Exception.ApiException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TeacherAdvice {
    @ExceptionHandler(value = ApiException.class)
    public ResponseEntity ApiException(ApiException t){
        String message=t.getMessage();
        return ResponseEntity.status(400).body(message);
    }
}
