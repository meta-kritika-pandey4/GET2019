package com.metacube.get2019.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.get2019.model.pojo.Employee;


public class EmployeeMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet resultSet, int i) throws SQLException {

		Employee employee = new Employee();
		employee.setId(resultSet.getInt("employee_id"));
		employee.setFullName(resultSet.getString("full_name"));
		employee.setPassword(resultSet.getString("password"));
		employee.setEmail(resultSet.getString("email_id"));
		employee.setGender(resultSet.getString("gender"));
		employee.setOrganization(resultSet.getString("organization"));
		return employee;
	}
}
