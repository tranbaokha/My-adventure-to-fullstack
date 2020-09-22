package com.example.demo.databaseProcess;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class User {
	@Size(min = 2, message = "Name at least 2 chars")
	private String name;
	@Min(1)
	private int id;
	@Size(min = 2)
	private String officeName;
	@Past
	private LocalDate _birthDay;
	private String birthDay;
	public User() {
		
	}
	public User(String name, int id, String officeName, String date) {
		this.name = name;
		this.id = id;
		this.officeName = officeName;
		this.birthDay = date;
		this._birthDay = LocalDate.parse(date);
	}
	public String getName() {
		return this.name;
	}
	public int getId() {
		return this.id;
	}
	public String getOfficeName() {
		return this.officeName;
	}
	public String getBirthDay() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		return formatter.format(_birthDay);
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setOfficeName(String officeName) {
		this.officeName = officeName;
	}
	public void setBirthDay(String birthDay) {
		String res = "";
		if(birthDay.contains("/")) {
			String[] temp = birthDay.split("/");
			for(int i = temp.length - 1; i > 0;i --)
				res += temp[i] + "-";
			res += temp[0];
		}
		this.birthDay = res;
		this._birthDay = LocalDate.parse(res);
	}
}
