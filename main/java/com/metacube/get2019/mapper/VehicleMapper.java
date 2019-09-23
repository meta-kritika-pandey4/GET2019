package com.metacube.get2019.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.get2019.model.pojo.Vehicle;


public class VehicleMapper implements RowMapper<Vehicle> {

	@Override
	public Vehicle mapRow(ResultSet resultSet, int i) throws SQLException {

		Vehicle vehicle = new Vehicle();
		vehicle.setEmployeeId(resultSet.getInt("employee_id"));
		vehicle.setVehicleName(resultSet.getString("vehicle_name"));
		vehicle.setVehicleNumber(resultSet.getString("vehicle_number"));
		vehicle.setVehicleType(resultSet.getString("vehicle_type"));
		vehicle.setIdentification(resultSet.getString("identification"));
		return vehicle;
	}
}
