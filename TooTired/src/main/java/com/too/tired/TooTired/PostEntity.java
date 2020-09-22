package com.too.tired.TooTired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "post")
public class PostEntity {
	@Id
	@GeneratedValue
	@Column(name = "post_id")
	private int id;
	private String content;
	@ManyToOne(fetch=FetchType.LAZY)
	@JsonIgnore
	private UserEntity user;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
}
