package com.example.demo.databaseProcess;

import java.util.ArrayList;
import java.time.LocalDate;
import java.util.*;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFilter;

@Component
@JsonFilter("DynamicFilter")
public class UserDatabase {
	private ArrayList<User> users = new ArrayList<User>();
	public static int count = 0;
	@SuppressWarnings("deprecation")
	public UserDatabase() {
		users.add(new User("kha", 20, "HCMUT","2000-09-15"));
		users.add(new User("chau", 15, "TPHCM", "1999-10-10"));
		users.add(new User("Hao", 19, "TDTU", "1998-03-31"));
		count = 3;
	}
	public ArrayList<User> getAllUsers(){
		return this.users;
	}
	public User getUser(int id) {
		User res = null;
		for(User user:users) {
			if(user.getId() == id) {
				res = user;
				break;
			}
		}
		if(res == null)
			throw new NotFoundException("Cannot found " + id);
		else return res;
	}
	public ArrayList<User> getUser(String name) {
		ArrayList<User> res = new ArrayList<User>();
		for(User user:users) {
			if(user.getName().equals(name))res.add(user);
		}
		if(res.size() == 0) {
			throw new NotFoundException("Cannot found " + name);
		}
		else return res;
	}
	public int getUserById(int id) {
		for(int i = 0;i < users.size(); i++) {
			if(users.get(i).getId() == id)return i;
		}
		return -1;
	}
	public void removeUser(int id) {
		int idRemove = getUserById(id);
		if(idRemove == -1) throw new NotFoundException("Can not remove");
		users.remove(idRemove);
	}
	public void addUser(User user) {
		users.add(user);
	}
}
