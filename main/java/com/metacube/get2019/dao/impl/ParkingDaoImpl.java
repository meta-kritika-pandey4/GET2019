package com.metacube.get2019.dao.impl;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.metacube.get2019.dao.ParkingDao;
import com.metacube.get2019.mapper.EmployeeMapper;
import com.metacube.get2019.mapper.PassMapper;
import com.metacube.get2019.mapper.VehicleMapper;
import com.metacube.get2019.model.dto.Pass;
import com.metacube.get2019.model.dto.SignUpForm;
import com.metacube.get2019.model.dto.VehicleForm;
import com.metacube.get2019.model.pojo.Employee;
import org.springframework.stereotype.Repository;

@Repository
public class ParkingDaoImpl implements ParkingDao {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public ParkingDaoImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	private static final String VALIDATE_EMPLOYEE = "select * from employee where email_id= ? and password= ?;";
	private static final String GET_EMPLOYEE = "select * from employee where email_id= ?;";
	private static final String ADD_EMPLOYEE = "insert into employee(full_name,gender,email_id,password,contact,organization) values(?,?,?,?,?,?);"; 
	private static final String ADD_VEHICLE = "insert into vehicle(vehicle_name,vehicle_type,identification,vehicle_number,employee_id) values(?,?,?,?,?);";
	private static final String ADD_PASS = "insert into pass values(?,?,?)"; 
	
	@Override
	public boolean validateEmployee(String email, String password) {
		try {
		jdbcTemplate.queryForObject(VALIDATE_EMPLOYEE, new Object[] { email, password }, new EmployeeMapper());
		return true;
		}
		catch(DataAccessException e) {
			return false;
		}
	}

	@Override
	public Employee getEmployee(String email) {
		return jdbcTemplate.queryForObject(GET_EMPLOYEE, new Object[] { email}, new EmployeeMapper());
	}

	@Override
	public boolean addEmployee(SignUpForm signUpForm) {
		return (jdbcTemplate.update(ADD_EMPLOYEE, new Object[] {signUpForm.getFullName(),signUpForm.getGender(),signUpForm.getEmail(),signUpForm.getPassword(),signUpForm.getContact(),
				signUpForm.getOrganization()}, new EmployeeMapper())>=1);
	}

	@Override
	public boolean addVehicle(VehicleForm vehicleform) {
		return (jdbcTemplate.update(ADD_VEHICLE, new Object[] {vehicleform.getVehicleName(),vehicleform.getVehicleType(),
				vehicleform.getIdentification(),vehicleform.getVehicleNumber(),vehicleform.getEmployeeId()}, new VehicleMapper())>=1);
	}

	@Override
	public boolean addPass(Pass pass) {
		return (jdbcTemplate.update(ADD_PASS, new Object[] {pass.getVehicleNumber(),pass.getPassPrice(),pass.getEmployeeId()}, new PassMapper())>=1);
	}

}
