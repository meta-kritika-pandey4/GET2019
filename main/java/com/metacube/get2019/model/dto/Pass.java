package com.metacube.get2019.model.dto;

import javax.validation.constraints.NotBlank;

/**
 * DTO class for the Pass 
 * @author Kritika
 *
 */
public class Pass {
	
	private String vehicleType;
	
	private String currencyType;
	
	//validation constraint
	@NotBlank(message="{passValidation}")
	private String passPrice;
	
	//getters and setters
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
	public String getCurrencyType() {
		return currencyType;
	}
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	public String getPassPrice() {
		return passPrice;
	}
	public void setPassPrice(String passPrice) {
		this.passPrice = passPrice;
	}
	
	/**
	 * Method for calculating the pass price 
	 * @param currencyType
	 * @param passPrice
	 * @return price
	 */
	public double billPassPrice(String currencyType, String passPrice) {
		double price = 0;
		 if( currencyType.equalsIgnoreCase("USD")) {
			 price =Double.parseDouble(passPrice);
	     } else if(currencyType.equalsIgnoreCase("YEN")) {
	         price=Double.parseDouble(passPrice) * 107.70;
	     } else if(currencyType.equalsIgnoreCase("INR" )) {
	         price = Math.round(Double.parseDouble(passPrice)) * 71.43;
	     }
		 return price;
	} 
}


