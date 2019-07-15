package com.metacube.get2019;


/**
 * It is class for items in the cart.
 * @author Admin
 *
 */
class CartItem {
	String itemName;
	int itemQuantity;
	double itemPrice;
	
	/**
	 * It is an constructor which is used to set attributes of cart items.
	 * @param itemName name of cart item
	 * @param itemQuantity quantity of cart item
	 * @param itemPrice price of cart item
	 */
	public CartItem (String itemName, int itemQuantity, double itemPrice) {
		this.itemName = itemName;
		this.itemQuantity = itemQuantity;
		this.itemPrice = itemPrice;
	}
	
	/**
	 * it is used to set quantity of the cart item.
	 * @param itemQuantity updated quantity of cart item.
	 */
	public void setQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
	
	/**
	 * it is used to return itemName.
	 * @return itemname
	 */
	public String getItemName() {
		return itemName;
	}
	
	/**
	 * It is used +to return item quantity.
	 * @return itemquantity
	 */
	public int getItemQuantity() {
		return itemQuantity;
	}
	
	/**
	 * It is method used to return item price.
	 * @return price of cart item
	 */
	public double getItemPrice() {
		return itemPrice;
	}
}
