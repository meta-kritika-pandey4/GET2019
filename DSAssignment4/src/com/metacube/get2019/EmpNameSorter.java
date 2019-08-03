package com.metacube.get2019;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * It is a class to create an employee list and return it sorted on basis of empName.
 * @author Kritika
 *
 */
public class EmpNameSorter implements Comparator<EmpNameSorter>{

	public int empId;
	public String empName;
	public String empAddress;
	public List<EmpNameSorter> empList = new ArrayList<EmpNameSorter>();

	/**
	 * It is a default constructor.
	 */
	public EmpNameSorter() {}

	/**
	 * It is a constructor used to initialize employee attributes.
	 * @param empId Id of employee.
	 * @param empName name of employee.
	 * @param empAddress address of employee.
	 */
	public EmpNameSorter(int empId, String empName, String empAddress) {
		this.empId = empId;
		this.empName = empName;
		this.empAddress = empAddress;
	}

	/**
	 * It is a method used to create employee list.
	 * @param emp employee object.
	 */
	public void makeEmpList(EmpNameSorter emp) {
		empList.add(emp);
	}

	/**
	 * It is a method which overrides comparator compare method.
	 */
	@Override
	public int compare(EmpNameSorter obj1, EmpNameSorter obj2) {
		return (obj1.empName).compareTo(obj2.empName);
	}

	/**
	 * It is a method used to return list sorted according to name.
	 * @return employee list.
	 */
	public List<EmpNameSorter> sortAccName() {
		Collections.sort(empList, new EmpNameSorter());
		return empList;
	}
}