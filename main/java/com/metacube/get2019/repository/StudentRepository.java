package com.metacube.get2019.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.metacube.get2019.model.pojo.Student;

/**
 * Interface for Base Repository
 * @author Kritika
 *
 */
@Repository
public interface StudentRepository extends CrudRepository<Student,Integer>{
	
	/**
	 * method to get students by class name
	 * @param className
	 * @return
	 */
	List<Student> getStudentByClassName(String className);
	
	/**
	 * Method to get student list by first name or last name
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	@Query("from Student where firstName like %:firstName% and lastName like %:lastName%")
	List<Student> getStudentByFirstNameOrLastName(@Param("firstName")String firstName, @Param("lastName")String lastName);
	
}
