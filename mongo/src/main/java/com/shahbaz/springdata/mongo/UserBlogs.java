package com.shahbaz.springdata.mongo;

import java.util.Date;

public class UserBlogs {
	
	private String title;
	
	protected String address;
	
	private Date datePublished;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getDatePublished() {
		return datePublished;
	}

	public void setDatePublished(Date datePublished) {
		this.datePublished = datePublished;
	}
	
	

}
