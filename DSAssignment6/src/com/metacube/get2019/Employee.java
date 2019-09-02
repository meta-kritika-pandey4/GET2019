package com.metacube.get2019;

/**
 * It is a class having attributes of an employee
 * @author Kritika
 *
 */
public class Employee {
	private String empName;
	private int age;
	private int salary;
	
	/**
	 * It is a constructor to initialize employee attributes.
	 * @param empName name of employee
	 * @param age age of employee
	 * @param salary salary of employee.
	 */
	public Employee(String empName, int age, int salary) {
		this.setEmpName(empName);
		this.setAge(age);
		this.setSalary(salary);
	}

	/**
	 * getter method for salary
	 * @return salary
	 */
	public int getSalary() {
		return salary;
	}


	/**
	 * setter method for salary
	 * 
	 */
	public void setSalary(int salary) {
		this.salary = salary;
	}


	/**
	 * getter method for age
	 * @return age
	 */
	public int getAge() {
		return age;
	}


	/**
	 * setter method for age
	 * 
	 */
	public void setAge(int age) {
		this.age = age;
	}


	/**
	 * setter method for employee name
	 * @return empName
	 */
	public String getEmpName() {
		return empName;
	}


	/**
	 * setter method for salary
	 * 
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	

}