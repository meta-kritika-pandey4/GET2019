package com.metacube.get2019.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.get2019.dao.StudentDao;
import com.metacube.get2019.model.dto.StudentCommands;
import com.metacube.get2019.model.dto.UpdateStudentCommands;
import com.metacube.get2019.model.pojo.Student;
/**
 * Service class for Student application
 * @author Kritika
 *
 */
@Service
public class StudentService {
	
	@Autowired
	StudentDao studentDao;
	
	/**
	 * method to addStudent to the database
	 * @param student
	 * @return true if student added
	 */
	public boolean addStudent(StudentCommands student) {
		return studentDao.addStudent(student);
	}
	
	/**
	 * method to get all students from the database
	 * @return list of students
	 */
	public List<Student> getAllStudents() {
		
		return studentDao.getAllStudents();
	}
	
	/**
	 * This is the method to update student in the database
	 * @param updateStudentCommands 
	 * @return true if student updated
	 */
	public Student getStudentDetails(int studentId) {
		
		return studentDao.getStudentDetails(studentId);
	}
	
	/**
	 * method to get the student details by id
	 * @param studentId
	 * @return student
	 */
	public boolean updateStudentDetails(UpdateStudentCommands updateStudentCommands) {
		return studentDao.updateStudentDetails(updateStudentCommands);
	}
	
	/**
	 * method to search students by name
	 * @param firstName
	 * @param lastName
	 * @return student list
	 */
	public List<Student> getStudentByName(String firstName, String lastName) {
		return studentDao.getStudentByName(firstName,lastName);
	}
	
	/**
	 * method to search students by class
	 * @param className
	 * @return student list
	 */
	public List<Student> getStudentByClass(String className) {
		return studentDao.getStudentByClass(className);
	}
}
