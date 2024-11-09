package com.taraktech.react_spring_boot_crud_app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeException {
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<String> handleExceptionNotFound(RuntimeException e){
		return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
	}
	/*
	 * @ExceptionHandler(RuntimeException.class) public ResponseEntity<String>
	 * handleExceptionAlreadyExitsException(RuntimeException e){ return new
	 * ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT); }
	 */
}
