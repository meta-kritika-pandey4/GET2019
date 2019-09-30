package com.metacube.get2019.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.get2019.dao.ParkingDao;
import com.metacube.get2019.model.dto.Pass;
import com.metacube.get2019.model.dto.VehicleForm;
import com.metacube.get2019.model.pojo.Employee;
import com.metacube.get2019.model.pojo.Vehicle;
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
	public boolean addEmployee(Employee employee) {
		try {
			parkingDao.addEmployee(employee);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean addVehicle(VehicleForm vehicleform) {
		try {
			parkingDao.addVehicle(vehicleform);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public boolean addPass(Pass pass) {
		try {
			parkingDao.addPass(pass);
			return true;
		}catch(Exception e) {
			return false;
		}
	}

	@Override
	public Vehicle getVehicle(int id) {
		return parkingDao.getVehicle(id);
	}

	@Override
	public Pass getPass(int id) {
		return parkingDao.getPass(id);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		try {
			parkingDao.updateEmployee(employee);
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Employee> getFriends(String email) {
		return parkingDao.getFriends(email);
	}
}
