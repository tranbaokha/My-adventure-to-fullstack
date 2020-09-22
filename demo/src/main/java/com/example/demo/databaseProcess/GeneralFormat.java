package com.example.demo.databaseProcess;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
public class GeneralFormat {
	private int code;
	private String message;
	private ArrayList<User> data;
	public GeneralFormat(int code, String message, ArrayList<User> user) {
		this.code = code;
		this.message = message;
		this.data = user;
	}
	public int getCode() {
		return this.code;
	}
	public String getMessage() {
		return this.message;
	}
	public ArrayList<User> getUser() {
		return this.data;
	}
}
