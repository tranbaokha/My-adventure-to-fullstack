package com.too.tired.TooTired;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

@Entity
@Table(name = "user")
public class UserEntity {
	@Id
	@GeneratedValue
	@Column(name = "student_id")
	//@Min(value = 0, message = "Id must be greater or equal 0")
	private int id;
	//@Size(min = 2, message = "Name must have more than 2 characters")
	@Column(name = "full_name")
	private String name;
	//@Past(message = "Birthday of a person have to be in the past")
	private LocalDate birthday;
	@OneToMany(mappedBy = "user")
	private List<PostEntity> posts;
	private String username;
	@Size(min = 6)
	private String password;
	private String role;
	public String getRoles() {
		return this.role;
	}
	public void setRoles(String roles) {
		this.role = roles;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return this.username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return this.password;
	}
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public String getBirthday() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		return this.birthday.format(formatter);
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirthday(String birthday) {
		String res = "";
		String[] temp = birthday.split("/");
		for(int i = temp.length - 1;i > 0; i--) {
			res += temp[i] + "-";
		}
		res += temp[0];
		this.birthday = LocalDate.parse(res);
	}
	public List<PostEntity> getPosts() {
		return posts;
	}
	public void setPosts(List<PostEntity> posts) {
		this.posts = posts;
	}
	public PostEntity getPosts(int id) {
		for(PostEntity post: this.posts) {
			if(post.getId() == id)return post;
		}
		return null;
	}
	public void addPost(PostEntity post) {
		posts.add(post);
	}
}
