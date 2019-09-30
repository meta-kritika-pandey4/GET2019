package com.metacube.get2019.model.pojo;

import java.io.Serializable;

/**
 * POJO class for the user
 * @author Kritika
 *
 */
public class Employee implements Serializable{
	
	private int employeeId;
	private String fullName;
	private String gender;
	private String email;
	private String password;
	private long contact;
	private String organization;
	
	//getters and setters
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int id) {
		this.employeeId = id;
	}
	public void setGender(String gender) {
		this.gender = gender;
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
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
}
