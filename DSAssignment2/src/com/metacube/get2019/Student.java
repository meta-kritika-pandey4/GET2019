package com.metacube.get2019;

/**
 * It is a student class.
 * @author Kritika
 *
 */
public class Student {
	
	private String stuName;
	private String[] programsList;
	
	/**
	 * It is a default constructor.
	 */
	public Student() {
	}
	
	/**
	 * It is a constructor used to initialize student class attributes.
	 * @param stuName Student name
	 * @param programsList programs list of students.
	 */
	public Student (String stuName, String[] programsList) {
		this.stuName = stuName;
		this.programsList = programsList;
	}
	
	/**
	 * It is a getter method used to return student name.
	 * @return student name
	 */
	public String getStudentName() {
		return stuName;
	}
	
	/**
	 * It is a getter method to return programsList of student.
	 * @return programList of students.
	 */
	public String[] getProgramsList() {
		return programsList;
	}
}
