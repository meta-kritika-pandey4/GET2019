package com.metacube.get2019.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

/**
 * model attribute for search by class form
 * @author Kritika
 *
 */
public class SearchByClass {
	
	//validations
	@NotBlank(message="{requiredField}")
	@Pattern(regexp="^[A-Za-z ]{1,3}[-]{1}[A-Za-z ]{1}$",message="{validClassName}")
	private String className;

	//getters and setters
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
}
