package com.metacube.get2019.model;


/**
 * Used to create an entity of cart
 * @author Kritika
 *
 */
public class Cart {		
	private int productCode;
	private String productName;
	private String productType;
	private int productQuantity;
	private float price;
	
	public Cart(int productCode, String productName, String productType,
		int productQuantity, float price) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.productType = productType;
		this.productQuantity = productQuantity;
		this.price = price;
	}
	public int getProductCode() {
		return productCode;
	}
	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public int getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() { 
		return  productCode + "  "+productName + "  " + productType	+ "  " + productQuantity + "  "+ price ;
	}	
}