package com.example.demo.databaseProcess;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lc.app.web.rest.errors.FieldErrorVM;
@ControllerAdvice
public class customizedExceptionHandler extends ResponseEntityExceptionHandler{
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handlerExceptionNot_Found(Exception ex, WebRequest request){
		ExceptionHandlerFormat exHandler = new ExceptionHandlerFormat(2, ex.getMessage(), null, null);
		return new ResponseEntity(exHandler, HttpStatus.NOT_FOUND);
	}
//	@Override
//	public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, @NonNull NativeWebRequest request) {
//        BindingResult result = ex.getBindingResult();
//        List<FieldErrorVM> fieldErrors = result.getFieldErrors().stream()
//            .map(f -> new FieldErrorVM(f.getField(), f.getCode()))
//            .collect(Collectors.toList());
//        return new ResponseEntity(fieldErrors, HttpStatus.BAD_REQUEST);
////    }
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		BindingResult result = ex.getBindingResult();
        List<FieldErrorVM> fieldErrors = result.getFieldErrors().stream()
            .map(f -> new FieldErrorVM(f.getField(), f.getCode()))
            .collect(Collectors.toList());
        return new ResponseEntity(fieldErrors, HttpStatus.BAD_REQUEST);
	}
}
