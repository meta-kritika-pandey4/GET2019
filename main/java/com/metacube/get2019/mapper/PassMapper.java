package com.metacube.get2019.mapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.metacube.get2019.model.dto.Pass;


public class PassMapper implements RowMapper<Pass> {

	@Override
	public Pass mapRow(ResultSet resultSet, int i) throws SQLException {

		Pass pass = new Pass();
		pass.setVehicleNumber(resultSet.getString("vehicle_number"));
		pass.setEmployeeId(resultSet.getInt("employee_id"));
		pass.setPassPrice(resultSet.getString("price"));
		return pass;
	}
}
