package com.example.demo.databaseProcess;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

class ExceptionFormat{
	private String field;
	private String message;
	public ExceptionFormat(String field, String message) {
		this.field = field;
		this.message = message;
	}
	public ExceptionFormat() {
		
	}
}
@JsonInclude(Include.NON_NULL)
public class ExceptionHandlerFormat{
	private int code;
	private String message;
	private ExceptionFormat data;
	List<ExceptionFormat>badRequestError;
	public ExceptionHandlerFormat(int code, String message, ExceptionFormat data,List<ExceptionFormat> fieldErrors) {
		this.code = code;
		this.message = message;
		this.data = data;
		this.badRequestError = fieldErrors;
	}
	public int getCode() {
		return code;
	}
	public String getMessage() {
		return message;
	}
	public ExceptionFormat getData() {
		return data;
	}
	public List<ExceptionFormat> getBadResquestError(){
		return this.badRequestError;
	}
}
