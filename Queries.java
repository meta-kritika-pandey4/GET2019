package com.metacube.get2019;

import java.util.ArrayList;

/**
 * It is a class which holds all queries
 * @author Kritika
 *
 */
public class Queries {

	/*
	 * It is method that returns the query for adding 
	 * details of the students in the database
	 * @param first_name first name of the student
	 * @param last_name last name of the student
	 * @param father_name father's name of the student
	 * @param age age of the student
	 * @param class_name class name of the student
	 * @param email email id of the student
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
				+ email + "'"
				+");";
		System.out.println(query);
		return query;
		
	}
	public static String getEmployeeId()
	{
		String query="select max(employee_id) as curr_emp_id from employee;";
		System.out.println(query);
		return query;
				
	}
	
	/*
	 * It is a method that returns the query for searching
	 * the students in the database
	 * @param first_name first name of the student
	 * @param last_name last name of the student
	 * @return query
	 * 
	 */
	public static String searchEmployeeQuery(String email_id,String password){
		String query="select * from employee where email_id='"+email_id+"' and password='"+password+"';";
		System.out.println(query);
		return query;
	}
	
	/*
	 * It is a method that returns the query for 
	 * showing all the students present in the school
	 * @return query
	 * 
	 */
	public static String showStudentQuery(){
		String query="select * from student;";
		return query;
		
	}
	
	/*
	 * It is a method to return the query for fetching 
	 * all the information of a particular student
	 * @param student_id id of the student
	 * @return query
	 * 
	 */
	public static String populateStudentQuery(int student_id){
		String query="select * from student where student_id = "+student_id+";";
		return query;
		
	}
	
	
	/*
	 * It is a method to return the query for updating
	 * the details of a student
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
	public static String updateStudentQuery(int student_id, String first_name, String last_name,String father_name, String email_id, int age, String class_name){
		String query="update student set first_name = '"+first_name+"'"
				+ ", last_name = '"+ last_name + "'"
				+ ", father_name = '"+ father_name + "'"
				+ ", email_id = '"+ email_id + "'"
				+ ", age = "+ age
				+ ", class = '" + class_name + "'"
				+ " where student_id = " + student_id + ";";
		System.out.println(query);		
		return query;
		
	}
	
}