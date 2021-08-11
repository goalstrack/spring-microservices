package com.fisglobal.organizationalservice.utils;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {

	private java.util.Date timestamp;
	private String message;
	private String Details;
}
