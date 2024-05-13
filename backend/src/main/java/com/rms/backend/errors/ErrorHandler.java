package com.rms.backend.errors;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internav Server Error", e.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(NotFound.class)
    public ResponseEntity<ErrorResponse> handleNotFound(NotFound ex){
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND, "Not Found", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Unauthorized.class)
    public ResponseEntity<ErrorResponse> handleUnauthorized(Unauthorized ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.UNAUTHORIZED, "Unauthorized", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(BadRequest.class)
    public ResponseEntity<ErrorResponse> handleBadRequest(BadRequest ex) {
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, "Bad Request", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

}
