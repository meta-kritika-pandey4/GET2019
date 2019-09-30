package com.metacube.get2019.model.dto;

import javax.validation.constraints.NotNull;

/**
 * DTO class for the Pass 
 * @author Kritika
 *
 */
public class Pass {
	
	private String vehicleNumber;
	private String vehicleType;
	private int employeeId;
	private String currencyType;
	
	//validation constraint
	@NotNull(message="{passValidation}")
	private double passPrice;
	
	//getters and setters
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getVehicleNumber() {
		return vehicleNumber;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public void setVehicleNumber(String vehicleNumber) {
		this.vehicleNumber = vehicleNumber;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public double getPassPrice() {
		return passPrice;
	}
	public void setPassPrice(double passPrice) {
		this.passPrice = passPrice;
	}
	
	/**
	 * Method for calculating the pass price 
	 * @param currencyType
	 * @param d
	 * @return price
	 */
	public double billPassPrice(String currencyType, double d) {
		double price = 0;
		 if( currencyType.equalsIgnoreCase("USD")) {
			 price =d;
	     } else if(currencyType.equalsIgnoreCase("YEN")) {
	         price=d * 107.70;
	     } else if(currencyType.equalsIgnoreCase("INR" )) {
	         price = Math.round(d * 71.43);
	     }
		 return price;
	} 
}


