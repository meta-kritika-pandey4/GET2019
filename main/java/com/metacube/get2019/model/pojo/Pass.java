package com.metacube.get2019.model.pojo;


/**
 * DTO class for the Pass 
 * @author Kritika
 *
 */
public class Pass {
	
	private String vehicleNumber;
	private double price;
	private int employeeId;
	
	
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
}	


