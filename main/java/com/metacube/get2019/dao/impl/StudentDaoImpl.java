package com.metacube.get2019.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Repository;

import com.metacube.get2019.dao.StudentDao;
import com.metacube.get2019.model.dto.StudentCommands;
import com.metacube.get2019.model.dto.UpdateStudentCommands;
import com.metacube.get2019.model.pojo.Student;
import com.metacube.get2019.utils.StudentMapper;

@Repository
public class StudentDaoImpl implements StudentDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public boolean addStudent(StudentCommands studentCommands) {
		Session session = this.sessionFactory.getCurrentSession();
		Student student=StudentMapper.mapStudent(studentCommands);
		try {
			session.save(student);
			return true;
		} catch(DataIntegrityViolationException e) {
			return false;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public List<Student> getAllStudents() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Student> studentList=session.createQuery("from Student").list();
		return studentList;
	}

	@Override
	public boolean updateStudentDetails(UpdateStudentCommands updateStudentCommands) {
		Session session= this.sessionFactory.getCurrentSession();
		try {
			Student student=StudentMapper.mapUpdateStudent(updateStudentCommands);
			session.update(student);
			return true;
		}catch(DataIntegrityViolationException e) {
			return false;
		}
	}

	@Override
	public Student getStudentDetails(int studentId) {
		Session session = this.sessionFactory.getCurrentSession();
		Student student=session.get(Student.class,studentId);
		return student;
	}

	@Override
	public List<Student> getStudentByName(String firstName, String lastName) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql="from Student student where firstName like :firstName and lastName like :lastName";
		Query query=session.createQuery(hql);
		query.setParameter("firstName","%"+firstName+"%");
		query.setParameter("lastName","%"+lastName+"%");
		List<Student> studentList=(List<Student>)query.list();
		return studentList;
	}

	@Override
	public List<Student> getStudentByClass(String className) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql="from Student student where className like :className";
		Query query=session.createQuery(hql);
		query.setParameter("className","%"+className+"%");
		List<Student> studentList=(List<Student>)query.list();
		return studentList;
	}
}
