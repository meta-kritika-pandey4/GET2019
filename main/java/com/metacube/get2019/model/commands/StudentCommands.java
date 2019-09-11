package com.metacube.get2019.model.commands;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 * This is the bean class of
 * signup form
 * @author Kritika
 *
 */
public class StudentCommands {

	//validation constraints
	@NotBlank(message="{requiredField}")
	@Pattern(regexp="/^[a-zA-Z ]*$/",message="{onlyLetters}")
	private String firstName;
	
	@NotBlank(message="{requiredField}")
	@Pattern(regexp="/^[a-zA-Z ]*$/",message="{onlyLetters}")
	private String lastName;
	
	@NotBlank(message="{requiredField}")
	@Pattern(regexp="/^[a-zA-Z ]*$/",message="{onlyLetters}")
	private String fatherName;
	
	
	@Max(100)
	private int age;
	
	@NotBlank(message="{requiredField}")
	@Size(max = 10, message="{fixedSize}")
	private String className;
	
	@NotBlank(message="{requiredField}")
	@Email(message="{emailFormat}")
	private String email;
	
	//Getters and Setters of the data members
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
	public String getFatherName() {
		return fatherName;
	}
	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
