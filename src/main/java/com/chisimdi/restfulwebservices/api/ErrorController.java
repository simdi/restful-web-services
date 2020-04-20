package com.chisimdi.restfulwebservices.api;

import java.util.Date;

import com.chisimdi.restfulwebservices.exception.ApplicationError;
import com.chisimdi.restfulwebservices.exception.UserNotFoundException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class ErrorController extends ResponseEntityExceptionHandler {
  @Value("${api.docs.url}")
  private String details;

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ApplicationError> handleAllExceptions(Exception exception, WebRequest webRequest) {
    ApplicationError error = new ApplicationError();
    error.setCode(500);
    error.setTimestamp(new Date());
    error.setMessage(exception.getMessage());
    error.setDetails(details);
    return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
  }
  
  @ExceptionHandler(UserNotFoundException.class)
  public ResponseEntity<ApplicationError> handleUserNotFoundException(UserNotFoundException exception, WebRequest webRequest) {
    ApplicationError error = new ApplicationError();
    error.setCode(404);
    error.setTimestamp(new Date());
    error.setMessage(exception.getMessage());
    error.setDetails(details);
    return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
  }

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
      HttpStatus status, WebRequest request) {
    ApplicationError error = new ApplicationError();
    error.setCode(400);
    error.setTimestamp(new Date());
    error.setMessage("Validation failed");
    error.setDetails(ex.getBindingResult().toString());
    return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
  }
  
  
}