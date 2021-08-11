package com.fisglobal.organizationalservice.advice;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fisglobal.organizationalservice.exception.RecordNotFound;
import com.fisglobal.organizationalservice.utils.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(RecordNotFound.class)
	public ResponseEntity<?> recordNotFoundExecptionHandler(RecordNotFound ex, WebRequest request){
		ErrorDetails errordetails=new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errordetails, HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExecptionHandler(RecordNotFound ex, WebRequest request){
		ErrorDetails errordetails=new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(errordetails, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ErrorDetails errordetails= new ErrorDetails(new Date(), ex.getMessage(), "Validation Failed");
		return new ResponseEntity<>(errordetails,HttpStatus.NOT_FOUND);
		// TODO Auto-generated method stub
		//return super.handleMethodArgumentNotValid(ex, headers, status, request);
	}
	

}
