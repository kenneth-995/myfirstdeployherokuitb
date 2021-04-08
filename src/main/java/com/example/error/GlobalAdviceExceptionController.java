package com.example.error;

import com.example.error.Family.FamilyNameNotFoundException;
import com.example.error.Family.FamilyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class GlobalAdviceExceptionController extends ResponseEntityExceptionHandler {

    @ExceptionHandler(FamilyNotFoundException.class)
    public ResponseEntity<ApiError> handleFamilyNotFound(FamilyNotFoundException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }

    @ExceptionHandler(FamilyNameNotFoundException.class)
    public ResponseEntity<ApiError> handleFamilyNameNotFound(FamilyNameNotFoundException ex) {
        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(apiError);
    }
}
