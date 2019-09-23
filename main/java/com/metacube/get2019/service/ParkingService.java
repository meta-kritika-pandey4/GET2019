package com.metacube.get2019.service;

import com.metacube.get2019.model.dto.Pass;
import com.metacube.get2019.model.dto.SignUpForm;
import com.metacube.get2019.model.dto.VehicleForm;
import com.metacube.get2019.model.pojo.Employee;

public interface ParkingService {
	boolean validateEmployee(String email, String password);
	Employee getEmployee(String email);
	boolean addEmployee(SignUpForm signUpForm);
	boolean addVehicle(VehicleForm vehicleform);
	boolean addPass(Pass pass);

}
