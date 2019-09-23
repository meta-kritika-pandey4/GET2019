package com.metacube.get2019.utils;

import com.metacube.get2019.model.dto.StudentCommands;
import com.metacube.get2019.model.dto.UpdateStudentCommands;
import com.metacube.get2019.model.pojo.Student;

/**
 * Utility class 
 * @author Kritika
 *
 */
public class StudentMapper {
	
	public static Student mapStudent(StudentCommands studentCommands) {
		return new Student(studentCommands.getFirstName(),studentCommands.getLastName(),studentCommands.getEmail(),studentCommands.getFatherName(),studentCommands.getClassName(),studentCommands.getAge());
	}

	public static Student mapUpdateStudent(UpdateStudentCommands studentCommands) {
		return new Student(studentCommands.getStudentId(),studentCommands.getFirstName(),studentCommands.getLastName(),studentCommands.getEmail(),studentCommands.getFatherName(),studentCommands.getClassName(),studentCommands.getAge());
	}
}
