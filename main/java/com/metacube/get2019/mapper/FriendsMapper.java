package com.metacube.get2019.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.get2019.model.pojo.Employee;

/**
 * This class maps the friends result set to Employee
 * @author Kritika
 *
 */
public class FriendsMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

		Employee employee = new Employee();
		employee.setEmployeeId(resultSet.getInt("employee_id"));
		employee.setFullName(resultSet.getString("full_name"));
		employee.setEmail(resultSet.getString("email_id"));
		return employee;
	}
}
