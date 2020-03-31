package com.metacube.get2019;

import java.util.HashSet;
import java.util.Set;

/**
 * It is a class to add an employee
 * @author Kritika
 *
 */
public class AddEmployee {

	public int empId;
	public String empName;
	public String empAddress;
	public Set<AddEmployee> empSet = new HashSet<AddEmployee>();

	/**
	 * It is a default constructor.
	 */
	public AddEmployee() {}

	/**
	 * It is a constructor used to initialize employee attributes.
	 * @param empId Id of employee.
	 * @param empName name of employee.
	 * @param empAddress address of employee.
	 */
	public AddEmployee(int empId, String empName, String empAddress) {
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
	}

	/**
	 * It is a method to create a list .
	 * @param empObj Object of employee
	 * @return employee list.
	 */
	public boolean createEmpList(AddEmployee empObj) {
		return empSet.add(empObj);
	}

	/**
	 * It is overridden method equals of object class.
	 */
	@Override
	public boolean equals(Object obj){
		return obj instanceof AddEmployee && this.empId == ((AddEmployee)obj).empId;
	}

	/**
	 * It is a overridden method of object class.
	 */
	@Override
	public int hashCode(){
		return this.empId;
	}


}