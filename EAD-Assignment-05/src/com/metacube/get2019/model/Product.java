package com.metacube.get2019.model;
/**
 * POJO class for Product
 * @author Kritika
 *
 */
public class Product {

	private int productCode;
	private String productName;
	private String productType;
	private double price;
	private int availableQuantity;
	
	public Product(int productCode, String productName, String productType, double price, int availableQuantity) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productType = productType;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	public int getProductCode() {
		return productCode;
	}
	public String getProductName() {
		return productName;
	}
	public String getProductType() {
		return productType;
	}
	public double getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return productCode+"\t\t"+productName+"\t\t "+productType+"\t\t"+availableQuantity+"\t\t"+price;
	}
}