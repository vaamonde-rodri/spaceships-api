package com.rodrigovaamonde.spaceships.controllers.exception;

import com.rodrigovaamonde.spaceships.controllers.dto.ErrorResource;
import com.rodrigovaamonde.spaceships.domain.exception.InvalidInputException;
import com.rodrigovaamonde.spaceships.domain.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  public ResponseEntity<ErrorResource> resourceNotFoundException(ResourceNotFoundException ex) {
    ErrorResource errorResource =
        new ErrorResource(HttpStatus.NOT_FOUND.toString(), ex.getMessage(), null);

    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResource);
  }

  @ExceptionHandler(InvalidInputException.class)
  public ResponseEntity<ErrorResource> invalidInputException(InvalidInputException ex) {
    ErrorResource errorResource =
        new ErrorResource(HttpStatus.BAD_REQUEST.toString(), ex.getMessage(), null);

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResource);
  }

  @ExceptionHandler({RuntimeException.class, Exception.class})
  public ResponseEntity<ErrorResource> runtimeException(RuntimeException ex) {
    ErrorResource errorResource =
        new ErrorResource(HttpStatus.INTERNAL_SERVER_ERROR.toString(), ex.getMessage(), null);
    return new ResponseEntity<>(errorResource, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
