package com.metacube.get2019.dao;

import java.util.List;

import com.metacube.get2019.model.dto.StudentCommands;
import com.metacube.get2019.model.dto.UpdateStudentCommands;
import com.metacube.get2019.model.pojo.Student;
/**
 * Interface for Base Dao
 * @author Kritika
 *
 */
public interface StudentDao {
	
	/**
	 * method to addStudent to the database
	 * @param student
	 * @return true if student added
	 */
	boolean addStudent(StudentCommands student);
	
	/**
	 * method to get all students from the database
	 * @return list of students
	 */
	List<Student> getAllStudents();
	
	/**
	 * This is the method to update student in the database
	 * @param updateStudentCommands 
	 * @return true if student updated
	 */
	boolean updateStudentDetails(UpdateStudentCommands updateStudentCommands);
	
	/**
	 * method to get the student details by id
	 * @param studentId
	 * @return student
	 */
	Student getStudentDetails(int studentId);
	
	/**
	 * method to search students by name
	 * @param firstName
	 * @param lastName
	 * @return student list
	 */
	List<Student> getStudentByName(String firstName, String lastName);
	
	/**
	 * method to search students by class
	 * @param className
	 * @return student list
	 */
	List<Student> getStudentByClass(String className);

}
