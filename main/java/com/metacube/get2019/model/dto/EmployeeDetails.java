package com.metacube.get2019.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
/**
 * DTO for Welcome Page and Update form page
 * @author user
 *
 */
public class EmployeeDetails {

	//validation constraints
	private int employeeId;

	@NotBlank(message="{requiredField}")
	@Pattern(regexp="^[a-zA-Z ]*$",message="{onlyLetters}")
	private String fullName;

	@NotBlank(message="{requiredField}")
	private String gender;

	@Pattern(regexp="^[0-9]{10,10}$",message="{contactValidation}")
	private String contact;

	@NotBlank(message="{requiredField}")
	private String organization;

	//getters and setters
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getContact() {
		return contact;
	}
	public void setContact( String contact) {
		this.contact = contact;
	}
	public String getOrganization() {
		return organization;
	}
	public void setOrganization(String organization) {
		this.organization = organization;
	}
}
