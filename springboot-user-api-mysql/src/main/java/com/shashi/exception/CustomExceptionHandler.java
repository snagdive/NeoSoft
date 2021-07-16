package com.shashi.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request)
	{
		ExceptionEntity exceptionEntity = new ExceptionEntity(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionEntity, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidRequestException.class)
	public ResponseEntity<Object> handleInvalidRequstException(Exception ex, WebRequest request)
	{
		ExceptionEntity exceptionEntity = new ExceptionEntity(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionEntity, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleAllException(Exception ex, WebRequest request)
	{
		ExceptionEntity exceptionEntity = new ExceptionEntity(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionEntity, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
