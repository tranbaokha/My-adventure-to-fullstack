package com.example.demo;

public class HelloWorldBean {
	private String message;
	private static int id = 0;
	private int a;
	public HelloWorldBean(String message) {
		this.message = message;
		id++;
	}
	public String getMessage() {
		return this.message;
	}
	public int getId() {
		return this.id;
	}
	public int getA() {
		return this.a;
	}
}
