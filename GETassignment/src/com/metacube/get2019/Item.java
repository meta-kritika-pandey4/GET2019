package com.metacube.get2019;

/*
 * The class item is here with attributes id(Product id),
 * itemName(Product name)m and price of the product. 
 * This fetches these attributes for the items.
 */
public class Item 
{	
	public int id;
	public String itemName;
	public double price;
	/*
	 * This method is used to set values of 3 properties and to print them.
	 * @param id This is first parameter to set id of item
	 * @param itemName this is second parameter to set itemname
	 * @param price this is third parameter to set price of item
	 */
	public Item(int id, String itemName, double price)
	{
		this.id=id;
		this.itemName=itemName;
		this.price=price;
		System.out.println(id+"\t\t"+itemName+"\t\t"+price);
	}
	/*
	 * This method is used to return value of itemname
	 * @return string type itemname
	 */
	public String getItemName()
	{
		return itemName;
	}
		/*
	 * This method is used to return value of id.
	 * @return id of item
	 */
	public int getid()
	{
		return id;
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

