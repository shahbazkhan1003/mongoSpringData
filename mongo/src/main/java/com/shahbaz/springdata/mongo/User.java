package com.shahbaz.springdata.mongo;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {

	private String id;
	
	private String username;
	
	private String password;
	
	private List<UserBlogs> userBlogs;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<UserBlogs> getUserBlogs() {
		return userBlogs;
	}

	public void setUserBlogs(List<UserBlogs> userBlogs) {
		this.userBlogs = userBlogs;
	}

	
	
}
