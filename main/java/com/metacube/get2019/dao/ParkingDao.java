package com.metacube.get2019.dao;

import java.util.List;
import java.util.Map;

import com.metacube.get2019.model.dto.Pass;
import com.metacube.get2019.model.dto.VehicleForm;
import com.metacube.get2019.model.pojo.Employee;
import com.metacube.get2019.model.pojo.Vehicle;
/**
 * Represents the dao layer
 * @author Kritika
 *
 */
public interface ParkingDao {
	
	/**
	 * validates employee
	 * @param email
	 * @param password
	 * @return true or false
	 */
	boolean validateEmployee(String email, String password);
	
	/**
	 * retrieves employee details by email
	 * @param email
	 * @return true or false
	 */
	public Employee getEmployee(String email);
	
	/**
	 * This method is used to register a new employee
	 * @param employee
	 * @return true or false
	 */
	public boolean addEmployee(Employee employee);
	
	
	/**
	 * This method is used to register a new vehicle
	 * @param vehicleform
	 * @return true or false
	 */
	boolean addVehicle(VehicleForm vehicleform);
	
	/**
	 * This method is used to add a new pass
	 * @param pass
	 * @return true or false
	 */
	boolean addPass(Pass pass);
	
	/**
	 * used to fetch the vehicle details of the employee
	 * @param id
	 * @return Vehicle
	 */
	Vehicle getVehicle(int id);
	
	/**
	 * This method is used get the pass details of an employee
	 * @param id
	 * @return Pass
	 */
	Pass getPass(int id);
	
	/**
	 * This method is used to update the employee details
	 * @param employee
	 * @return true or false
	 */
	boolean updateEmployee(Employee employee);
	
	/**
	 * This method is used to fetch the friends of an employee
	 * @param email
	 * @return list of friends
	 */
	List<Employee> getFriends(String email);
}
