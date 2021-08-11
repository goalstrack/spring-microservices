package com.fisglobal.departmentservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.ToString;

@ToString
@ResponseStatus(value= HttpStatus.NOT_FOUND)
public class RecordNotFound extends Exception {

	public RecordNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	

}
