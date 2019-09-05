package com.metacube.get2019;

import java.util.ArrayList;

/**
 * It is a class which holds all queries
 * @author Kritika
 *
 */
public class Queries {

	/**
	 * It is method that returns the query for adding 
	 * details of the employees in the database
	 * @param full_name full name of the employee
	 * @param gender gender of the employee
	 * @param contact contact name of the employee
	 * @param email email id of the employe
	 * @param password password of the employee
	 * @param organization organization of the employee
	 * @return query
	 * 
	 */
	public static String addEmployeeQuery(String full_name, String gender, long contact, String email, String password, String organization) {
		String query = "insert into employee(full_name,gender,email_id,password,contact,organization) values('" 
				+ full_name + "', '"
				+ gender + "' , '"
				+ email + "','"
				+ password + "', "
				+ contact + ", '"
				+ organization + "'"
				+");";
		return query;
	}
	
	/**
	 * It is method that returns the query for adding 
	 * details of the vehicles in the database
	 * @param vehicle_name 
	 * @param vehicle_type
	 * @param identification
	 * @param vehicle_number
	 * @param employee_id
	 * @return query
	 * 
	 */
	public static String addVehicleQuery(String vehicle_name,String vehicle_type, String identification, String vehicle_number,int employee_id) {
		String query = "insert into vehicle(vehicle_name,vehicle_type,identification,vehicle_number,employee_id) values('" 
				+ vehicle_name + "', '"
				+ vehicle_type + "' , '"
				+ identification + "','"
				+ vehicle_number + "', "
				+ employee_id + ""
				+");";
		return query;
	}
	
	/**
	 * It is a method to get the employee_id of the employee
	 * 
	 */
	public static String getEmployeeId() {
		String query="select max(employee_id) as curr_emp_id from employee;";
		return query;
	}
	
	/**
	 * It is a method that returns the query for searching
	 * the employee in the database
	 * @param email_id email if of the employee
	 * @param password password of the employee
	 * @return query
	 * 
	 */
	public static String searchEmployeeQuery(String email_id,String password){
		String query="select * from employee e "
				     + "inner join vehicle v on e.employee_id=v.employee_id "
				     + "inner join pass p on v.employee_id=p.employee_id "
				     + "where email_id='"+email_id+"' and password='"+password+"';";
		System.out.println(query);
		return query;
	}
	
	/**
	 * It is a method to validate if the employee exists
	 * @param email_id
	 * @param password
	 * @return query
	 */
	public static String validateEmployeeQuery(String email_id,String password){
		String query="select * from employee "
				     + "where email_id='"+email_id+"' and password='"+password+"';";
		return query;
	}
	
	/**
	 * It is a method that returns the query for 
	 * showing all the friends of an employee
	 * @return query
	 * 
	 */
	public static String showFriendsQuery(int employee_id){
		String query="select distinct e2.employee_id,e2.full_name from "
				+ " employee e1,employee e2 "
				+ "where ((e1.organization=e2.organization) and (e1.employee_id<>e2.employee_id) and e1.employee_id="+employee_id+");";
		return query;
	}
	
	/**
	 * It is a method to add vehicle pass
	 * in the account of an employee
	 * @param vehicle_number
	 * @param price
	 * @param employee_id
	 * @return
	 */
	public static String addPassQuery(String vehicle_number, float price, int employee_id) {
		String query = "insert into pass values('" 
				+ vehicle_number + "',"
				+ price + " , "
				+ employee_id+");";
		return query;
	}

	/**
	 * It is a method to get all the details of the employee
	 * @param employee_id
	 * @return query
	 */
	public static String getEmployeeQuery(int employee_id) {
		String query="select * from employee e "  
						+ "inner join vehicle v on e.employee_id=v.employee_id "  
						+ "inner join pass p on v.employee_id=p.employee_id "
						+ "where e.employee_id="+employee_id;
		return query;
	}
	
	/**
	 * It is a method to return the query for updating
	 * the details of an employee
	 * @param student_id id of the student
	 * @param first_name first name of the student
	 * @param last_name last name of the student
	 * @param father_name father's name of the student
	 * @param age age of the student
	 * @param class_name class name of the student
	 * @param email email id of the student
	 * @return query
	 * 
	 */
	public static String updateEmployeeQuery(int employee_id, String full_name,
			String gender, String contact, String organization) {
		String query="update employee set full_name = '"+full_name+"'"
				+ ", gender = '"+ gender + "'"
				+ ", organization = '"+ organization + "'"
				+ ", contact = "+ contact
				+ " where employee_id = " + employee_id + ";";
		return query;
	}
}