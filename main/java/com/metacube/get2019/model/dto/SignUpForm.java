package com.metacube.get2019.model.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

/**
 * DTO class for the SignUpForm
 * @author Kritika
 *
 */
public class SignUpForm {

	//validation constraints
	@NotBlank(message="{requiredField}")
	@Pattern(regexp="^[a-zA-Z ]*$",message="{onlyLetters}")
	private String fullName;
	
	@NotBlank(message="{requiredField}")
	private String gender;
	
	@NotBlank(message="{requiredField}")
	@Email(message="{emailFormat}")
	private String email;
	
	@Pattern(regexp = "(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[@*$])(?=.*?[0-9]).{8,}", message = "{passwordValidation}")
	private String password;
	
	@NotBlank(message="{requiredField}")
	private String confirmPassword;
	
    @Pattern(regexp="^[0-9]{10,10}$",message="{contactValidation}")
	private String contact;
	
	@NotBlank(message="{requiredField}")
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
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
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
