package com.college.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class ExceptionsHandler {

	@ExceptionHandler
	public ResponseEntity<ExceptionResponse> handleException(DataNotFoundException er) {

		ExceptionResponse err = new ExceptionResponse();

		err.setDate(new Date());
		err.setDetails(er.getMessage());
		err.setMessage("Not_Found");
		err.setServerStatus(HttpStatus.NOT_FOUND.value());

		return new ResponseEntity<ExceptionResponse>(err, HttpStatus.NOT_FOUND);
	}
	
//	Method call when validation related exception is occur during running the program
	
	public ResponseEntity<ExceptionResponse> handleException(MethodArgumentNotValidException methodErr) {

		ExceptionResponse err = new ExceptionResponse();

		err.setDate(new Date());
		err.setDetails(methodErr.getBindingResult().getFieldError().getDefaultMessage());
		err.setMessage("Bad_Request "+"=> Validdation Error !!!");
		err.setServerStatus(HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}

//	Method for handle global exception i,e- any kind of exception we can handle

	@ExceptionHandler
	public ResponseEntity<ExceptionResponse> handleException(Exception e) {

		ExceptionResponse err = new ExceptionResponse();

		err.setDate(new Date());
		err.setDetails(err.getMessage());
		err.setMessage("Bad_Request");
		err.setServerStatus(HttpStatus.BAD_REQUEST.value());

		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
}
