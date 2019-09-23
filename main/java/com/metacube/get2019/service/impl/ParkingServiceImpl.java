package com.metacube.get2019.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.get2019.dao.ParkingDao;
import com.metacube.get2019.model.dto.Pass;
import com.metacube.get2019.model.dto.SignUpForm;
import com.metacube.get2019.model.dto.VehicleForm;
import com.metacube.get2019.model.pojo.Employee;
import com.metacube.get2019.service.ParkingService;

@Service
public class ParkingServiceImpl implements ParkingService{

	@Autowired
	ParkingDao parkingDao;
	
	@Override
	public boolean validateEmployee(String email, String password) {
		return parkingDao.validateEmployee(email, password);
	}

	@Override
	public Employee getEmployee(String email) {
		return parkingDao.getEmployee(email);
	}

	@Override
	public boolean addEmployee(SignUpForm signUpForm) {
		return parkingDao.addEmployee(signUpForm);
	}

	@Override
	public boolean addVehicle(VehicleForm vehicleform) {
		return parkingDao.addVehicle(vehicleform);
	}

	@Override
	public boolean addPass(Pass pass) {
		return parkingDao.addPass(pass);
	}

}
