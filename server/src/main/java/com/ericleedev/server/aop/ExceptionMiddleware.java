package com.ericleedev.server.aop;

import com.ericleedev.server.error.ErrorResponse;
import com.ericleedev.server.error.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@ControllerAdvice
public class ExceptionMiddleware {
    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(NotFoundException exception){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.NOT_FOUND.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(new Date().toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND) ;
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(Exception exception){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());
        errorResponse.setMessage(exception.getMessage());
        errorResponse.setTimeStamp(new Date().toString());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST) ;
    }
}
