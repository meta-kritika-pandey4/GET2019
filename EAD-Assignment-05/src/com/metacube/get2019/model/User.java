package com.metacube.get2019.model;

/**
 * POJO class for user
 * @author Kritika
 *
 */
public class User {
	int userId;
	String email;
	String password;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
