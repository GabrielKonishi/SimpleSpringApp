package com.registry.vc.exception;

import java.time.LocalDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetail> handleException(Exception exception) {
		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ErrorDetail
						.Builder(HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.INTERNAL_SERVER_ERROR.name())
						.description(exception.getMessage())
						.timestamp(LocalDateTime.now())
						.build());

	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDetail> badRequestExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException) {
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(new ErrorDetail
						.Builder(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name())
						.description("Erro ao validar os campos de requisicao")
						.timestamp(LocalDateTime.now())
						.build());
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<ErrorDetail> dataIntegrityViolationException(DataIntegrityViolationException dataIntegrityViolationException) {
		return ResponseEntity
				.status(HttpStatus.BAD_REQUEST)
				.body(new ErrorDetail
						.Builder(HttpStatus.BAD_REQUEST.value(), HttpStatus.BAD_REQUEST.name())
						.description("Erro ao validar os campos no banco de dados")
						.timestamp(LocalDateTime.now())
						.build());

	}
	
}
