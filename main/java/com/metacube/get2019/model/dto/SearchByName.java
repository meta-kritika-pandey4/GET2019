package com.metacube.get2019.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * model attribute for search by name form
 * @author Kritika
 *
 */
public class SearchByName {
	
	//validations
	@NotBlank(message="{requiredField}")
	@Pattern(regexp="^[a-zA-Z ]*$",message="{onlyLetters}")
	private String firstName;
	
	@NotBlank(message="{requiredField}")
	@Pattern(regexp="^[a-zA-Z ]*$",message="{onlyLetters}")
	private String lastName;
	
	//getters and setters
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
