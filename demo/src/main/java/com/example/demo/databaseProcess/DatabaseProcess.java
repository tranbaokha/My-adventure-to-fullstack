package com.example.demo.databaseProcess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import java.net.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;



@SuppressWarnings("deprecation")
@RestController
public class DatabaseProcess {
	@Autowired
	private UserDatabase usersDatabase = new UserDatabase();
	@RequestMapping(method = RequestMethod.GET, path = "/users")
	public GeneralFormat getAllUsers(){
		ArrayList<User> res = usersDatabase.getAllUsers();
		return new GeneralFormat(1, "Success", res);
	}
	@RequestMapping(method = RequestMethod.GET, path = "/users/id={id}")
	public GeneralFormat getUserById(@PathVariable int id) {
		ArrayList<User> res = new ArrayList<User>();
		res.add(usersDatabase.getUser(id));
		if(res.size() == 0)return new GeneralFormat(2, "Fail", res);
		return new GeneralFormat(1, "Success", res);
	}
	@RequestMapping(method = RequestMethod.GET, path = "/users/name={name}")
	public GeneralFormat getUsersByName(@PathVariable String name){
		ArrayList<User> res = new ArrayList<User>();
		res.addAll(usersDatabase.getUser(name));
		if(res.size() == 0)return new GeneralFormat(2, "Fail", res);
		return new GeneralFormat(1, "Success", res);
	}
	@RequestMapping(method=RequestMethod.POST, path = "/users")
	public ResponseEntity<Object> addUser(@Valid @RequestBody User user) {
		usersDatabase.addUser(user);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("id={id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(location).build();
	}
	@RequestMapping(method=RequestMethod.DELETE, path = "/users/delete={id}")
	public void deleteUser(@PathVariable int id) {
		usersDatabase.removeUser(id);
	}
	
}
