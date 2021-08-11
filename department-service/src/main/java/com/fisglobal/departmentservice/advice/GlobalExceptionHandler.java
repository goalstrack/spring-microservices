package com.fisglobal.departmentservice.advice;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import com.fisglobal.departmentservice.exception.RecordNotFound;
import com.fisglobal.departmentservice.utils.ErrorDetails;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(RecordNotFound.class)
	public ResponseEntity<Object> recordNotFoundExecptionHandler(RecordNotFound ex, WebRequest request){
		ErrorDetails errordetails=new ErrorDetails(HttpStatus.NOT_FOUND, ex);
		return buildResponseEntity(errordetails);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> globalExecptionHandler(RecordNotFound ex, WebRequest request){
		ErrorDetails errordetails=new ErrorDetails(HttpStatus.INTERNAL_SERVER_ERROR, ex);
		return buildResponseEntity(errordetails);
		
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ErrorDetails errordetails= new ErrorDetails(HttpStatus.BAD_REQUEST);
		return buildResponseEntity(errordetails);
		// TODO Auto-generated method stub
		//return super.handleMethodArgumentNotValid(ex, headers, status, request);
	}
	
	private ResponseEntity<Object> buildResponseEntity(ErrorDetails apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

	

}
