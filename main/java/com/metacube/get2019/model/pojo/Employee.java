package com.metacube.get2019.model.pojo;

/**
 * POJO class for the employee
 * @author Kritika
 *
 */
public class Employee {
	
	private int employeeId;
	private String fullName;
	private String gender;
	private String email;
	private String password;
	private long contact;
	private String organization;
	
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public int getId() {
		return employeeId;
	}
	public void setId(int id) {
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
