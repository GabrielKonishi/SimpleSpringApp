package com.registry.vc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler{
	
	/*@ExceptionHandler(Exception.class)
	public ResponseEntity handleException() {
		System.out.println("caiu no exception");
		return new ResponseEntity("error", HttpStatus.BAD_REQUEST);
	}*/
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity BadRequestExceptionHandler() {
		System.out.println("erro aqui");
		return new ResponseEntity("error", HttpStatus.BAD_REQUEST);
	}
	
	
}
