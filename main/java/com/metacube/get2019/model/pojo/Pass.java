package com.metacube.get2019.model.pojo;

import javax.validation.constraints.NotBlank;

/**
 * DTO class for the Pass 
 * @author Kritika
 *
 */
public class Pass {
	
	private String vehicleNumber;
	
	private String price;
	private int employeeId;
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
}	


