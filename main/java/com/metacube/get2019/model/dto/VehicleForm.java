package com.metacube.get2019.model.dto;

import javax.validation.constraints.NotBlank;

/**
 * DTO class for the VehicleRegistrationForm
 * @author Kritika
 *
 */
public class VehicleForm {
	
	//validation constraints
	@NotBlank(message="{requiredField}")
	private String vehicleName;
	
	@NotBlank(message="{requiredField}")
	private String vehicleType;
	
	@NotBlank(message="{requiredField}")
	private String vehicleNumber;
	
	private int employeeId;
	
	private String identification;
	
	//getters and setters
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
}
