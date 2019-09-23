package com.metacube.get2019.dao;

import com.metacube.get2019.model.dto.Pass;
import com.metacube.get2019.model.dto.SignUpForm;
import com.metacube.get2019.model.dto.VehicleForm;
import com.metacube.get2019.model.pojo.Employee;

public interface ParkingDao {
	boolean validateEmployee(String email, String password);
	public Employee getEmployee(String email);
	public boolean addEmployee(SignUpForm signUpForm);
	boolean addVehicle(VehicleForm vehicleform);
	boolean addPass(Pass pass);
}
