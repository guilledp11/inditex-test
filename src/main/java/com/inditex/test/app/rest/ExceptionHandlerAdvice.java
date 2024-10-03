package com.inditex.test.app.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ExceptionHandlerAdvice {

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<String> handleCustomException(MethodArgumentTypeMismatchException ex) {
		return new ResponseEntity<String>("Params format mismatch", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<String> handleCustomException(MissingServletRequestParameterException ex) {
		return new ResponseEntity<String>("Params mismatch", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		return new ResponseEntity<String>(
				"There has been an unexpected and unknown internal error. Please contact admin.",
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
