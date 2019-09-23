package com.metacube.get2019.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.metacube.get2019.model.dto.StudentCommands;
import com.metacube.get2019.model.dto.UpdateStudentCommands;
import com.metacube.get2019.model.pojo.Student;
import com.metacube.get2019.repository.StudentRepository;
import com.metacube.get2019.utils.StudentMapper;

/**
 * Service class for Student application
 * @author Kritika
 *
 */
@Service
public class StudentService {
	
	@Autowired
	StudentRepository studentRepository;
	
	/**
	 * method to addStudent to the database
	 * @param student
	 * @return true if student added
	 */
	public boolean addStudent(StudentCommands studentCommands) {
		Student student=StudentMapper.mapStudent(studentCommands);
		try {
			studentRepository.save(student);
			return true;
		} catch(DataIntegrityViolationException e) {
			return false;
		}
	}
	
	/**
	 * method to get all students from the database
	 * @return list of students
	 */
	public List<Student> getAllStudents() {
			return (List<Student>)studentRepository.findAll();
	}
	
	/**
	 * This is the method to update student in the database
	 * @param updateStudentCommands 
	 * @return true if student updated
	 */
	public Optional<Student> getStudentDetails(int studentId) {
		Optional<Student> student=null;
		try {
		student=studentRepository.findById(studentId);
		} catch(EmptyResultDataAccessException e) {
			e.printStackTrace();
		}
		return student;
	}
	
	/**
	 * method to get the student details by id
	 * @param studentId
	 * @return student
	 */
	public boolean updateStudentDetails(UpdateStudentCommands updateStudentCommands) {
		Student student=StudentMapper.mapUpdateStudent(updateStudentCommands);
		try {
			studentRepository.save(student);
			return true;
		} catch(DataIntegrityViolationException e) {
			return false;
		}
	}
	
	/**
	 * method to search students by name
	 * @param firstName
	 * @param lastName
	 * @return student list
	 */
	public List<Student> getStudentByName(String firstName, String lastName) {
		return studentRepository.getStudentByFirstNameOrLastName(firstName, lastName);
	}
	
	/**
	 * method to search students by class
	 * @param className
	 * @return student list
	 */
	public List<Student> getStudentByClass(String className) {
		return studentRepository.getStudentByClassName(className);	
	}
}
