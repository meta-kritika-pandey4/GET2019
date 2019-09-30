package com.metacube.get2019.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.metacube.get2019.dao.ParkingDao;
import com.metacube.get2019.mapper.EmployeeMapper;
import com.metacube.get2019.mapper.FriendsMapper;
import com.metacube.get2019.mapper.PassMapper;
import com.metacube.get2019.mapper.VehicleMapper;
import com.metacube.get2019.model.dto.Pass;
import com.metacube.get2019.model.dto.VehicleForm;
import com.metacube.get2019.model.pojo.Employee;
import com.metacube.get2019.model.pojo.Vehicle;

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
	private static final String GET_VEHICLE = "select * from vehicle where employee_id= ?;";
	private static final String GET_PASS = "select * from pass where employee_id= ?;";
	private static final String UPDATE_EMPLOYEE = "update employee set full_name = ? ,gender =?, organization =?, contact =? where employee_id = ?;";
	private static final String GET_FRIENDS="select distinct e2.employee_id,e2.full_name,e2.email_id from employee e1,"
			+ "employee e2 where ((e1.organization=e2.organization) and (e1.employee_id<>e2.employee_id) "
			+ "and e1.email_id=?)";

	@Override
	public boolean validateEmployee(String email, String password) {
		try {
			jdbcTemplate.queryForObject(VALIDATE_EMPLOYEE, new Object[] { email, password }, new EmployeeMapper());
			return true;
		} catch(DataAccessException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Employee getEmployee(String email) {
		return jdbcTemplate.queryForObject(GET_EMPLOYEE, new Object[] { email}, new EmployeeMapper());
	}

	@Override
	public boolean addEmployee(Employee employee) {
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int row = jdbcTemplate.update(new PreparedStatementCreator() {           
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(ADD_EMPLOYEE,
						new String[] { "employee_id"}); 
				ps.setString(1, employee.getFullName());
				ps.setString(2, employee.getGender());
				ps.setString(3, employee.getEmail());
				ps.setString(4, employee.getPassword());
				ps.setLong(5, employee.getContact());
				ps.setString(6, employee.getOrganization());
				return ps;
			}
		}, keyHolder);
		employee.setEmployeeId(keyHolder.getKey().intValue());	 
		return row > 0 ?true : false;
	}

	@Override
	public boolean addVehicle(VehicleForm vehicleform) {
		int row = jdbcTemplate.update(new PreparedStatementCreator() {           
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(ADD_VEHICLE); 
				ps.setString(1, vehicleform.getVehicleName());
				ps.setString(2, vehicleform.getVehicleType());
				ps.setString(3, vehicleform.getIdentification());
				ps.setString(4, vehicleform.getVehicleNumber());
				ps.setLong(5, vehicleform.getEmployeeId());
				return ps;
			}
		});
		return row > 0 ?true : false;
	}

	@Override
	public boolean addPass(Pass pass) {
		int row = jdbcTemplate.update(new PreparedStatementCreator() {           
			@Override
			public PreparedStatement createPreparedStatement(Connection connection)
					throws SQLException {
				PreparedStatement ps = connection.prepareStatement(ADD_PASS); 
				ps.setString(1, pass.getVehicleNumber());
				ps.setDouble(2, pass.getPassPrice());
				ps.setInt(3, pass.getEmployeeId());
				return ps;
			}
		});
		return row > 0 ?true : false;
	}

	@Override
	public Vehicle getVehicle(int id) {
		return jdbcTemplate.queryForObject(GET_VEHICLE, new Object[] {id}, new VehicleMapper());
	}

	@Override
	public Pass getPass(int id) {
		return jdbcTemplate.queryForObject(GET_PASS, new Object[] {id}, new PassMapper());
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		try {
			return jdbcTemplate.update(UPDATE_EMPLOYEE, employee.getFullName(), employee.getGender(),employee.getOrganization(),employee.getContact(), employee.getEmployeeId()) > 0;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Employee> getFriends(String email) {
		return jdbcTemplate.query(GET_FRIENDS, new Object[] {email}, new FriendsMapper());
	}
}


