package com.metacube.get2019;

public class CartItem {
	private int pid,quant;
	private double price;
	private String product;
	 
	public CartItem(int pid,int quant,double price,String product)
	{
		this.pid=pid;
		this.quant=quant;
		this.price=price;
		this.product=product;
	}
	public String getCartItemName()
	{
		return product;
	}
		/*
	 * This method is used to return value of id.
	 * @return id of item
	 */
	public int getpid()
	{
		return pid;
	}
	/*
	 * This method is used to return the price of the item.
	 * @return price of item
	 */
	public double getprice()
	{
		return price;
	}

}
