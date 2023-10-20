package com.employee.globalexception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.employee.idnotfoundexception.IdNotFoundException;
import com.employee.salarynotvalidexception.SalaryNotValidException;

@RestControllerAdvice
public class GlobalHandling {
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<Object> idHandling() {
		return new ResponseEntity<>("Sorry, Its a Not Valid Id Moron",HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(SalaryNotValidException.class)
	public ResponseEntity<Object> salHandling() {
		return new ResponseEntity<>("Exception Handled By GlobalException....",HttpStatus.BAD_REQUEST);
	}

}
