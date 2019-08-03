package com.metacube.get2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * It is a class to create an employee list and return it sorted on basis of empId.
 * @author Kritika
 *
 */
public class EmpIdSorter implements Comparable<EmpIdSorter>{

	public int empId;
	public String empName;
	public String empAddress;
	public List<EmpIdSorter> empList = new ArrayList<EmpIdSorter>();

	/**
	 * It is a default constructor.
	 */
	public EmpIdSorter() {}

	/**
	 * It is a constructor used to initialize employee attributes.
	 * @param empId Id of employee.
	 * @param empName name of employee.
	 * @param empAddress address of employee.
	 */
	public EmpIdSorter(int empId, String empName, String empAddress) {
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
	}

	/**
	 * It is a method used to create employee list.
	 * @param emp employee object.
	 */
	public void makeEmpList(EmpIdSorter emp) {
		empList.add(emp);
	}

	/**
	 * It is a method which overrides comparable compareTo method.
	 */
	@Override
	public int compareTo(EmpIdSorter obj1) {
		return this.empId - obj1.empId;
	}

	/**
	 * It is a method used to return list sorted according to empId.
	 * @return employee list.
	 */
	public List<EmpIdSorter> sortAccId() {
		Collections.sort(empList);
		return empList;
	}
}