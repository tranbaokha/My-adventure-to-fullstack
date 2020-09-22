package com.too.tired.TooTired;

import java.net.http.HttpHeaders;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javassist.NotFoundException;

@RestController
@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> notFoundExceptionHandler(Exception ex, WebRequest request) {
		OutputFormat<String> exceptionResponse = new OutputFormat<String>(404, "Fail", null, ex.getMessage());
		return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
	}
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		List<String> errors = new ArrayList<String>();
	    for (FieldError error : ex.getBindingResult().getFieldErrors()) {
	        errors.add(error.getField() + ": " + error.getDefaultMessage());
	    }
	    OutputFormat<String> exceptionResponse = new OutputFormat<String>(400, "Fail", errors, null);
	    return new ResponseEntity(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
}

