package com.metacube.get2019;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
class Item
{
int id;
String itemName;
double price;

/*
* This method is used to set values of 3 properties and to print them.
* @param id This is first parameter to set id of item
* @param itemName this is second parameter to set itemname
* @param price this is third parameter to set price of item
*/
public Item(int id, String itemName, double price){
this.id=id;
this.itemName=itemName;
this.price=price;
System.out.println(id+"\t\t"+itemName+"\t\t"+price);
}

/*
* This method is used to return value of itemname
* @return string type itemname
*/
public String getItemName(){
return itemName;
}

/*
* This method is used to return value of id.
* @return id of item
*/
public int getid(){
return id;
}

/*
* This method is used to return the price of the item.
* @return price of item
*/
public double getprice(){
return price;
}
}

/*
 * This class has the attributes pro(Product),quant(Quantity), 
 * pid(ProductID) and price(Cost) 
 * This class also has all the functions of a Shopping Cart
 */
class ShoppingCart
{
	//ArrayList are for storing the input
	ArrayList<String> pro=new ArrayList<String>();
	ArrayList<Integer> quant=new ArrayList<Integer>();
	ArrayList<Integer> pid=new ArrayList<Integer>();
	ArrayList<Double> price=new ArrayList<Double>();
	Scanner ab=new Scanner(System.in);
	/*
	 * addItem() adds items in the cart 
	 * while taking the input from the customer
	 */
	void addItem(ArrayList<Item> itemList)
	{
		System.out.print("enter the item number = ");
		Scanner ab=new Scanner(System.in);
		int itemId=ab.nextInt();
		Iterator<Item> iterator=itemList.iterator();
		while(iterator.hasNext())
		{	
			Item i=(Item)iterator.next();
			if (i.getid()==itemId)
			{
				pro.add(i.getItemName());
				System.out.print("Enter quantity for the item = ");
				int itemQuantity=ab.nextInt();
				quant.add(itemQuantity);
				price.add(i.getprice());
				pid.add(i.getid());
				System.out.println("Item is successfully added into cart");
			}
		}
	}
	/*
	 * update() is for changing the quantity of a particular item in the cart
	 * as required by the customer
	 */
	void update()
	{
		if(pid.size()==0)
		{
			System.out.println("No item in the cart!! Please first enter some!!");
		}
		else
		{
			System.out.println("Enter the Sid of the product to be updated");
			int i=ab.nextInt();
			System.out.println("Enter the updated quantity");
			int up=ab.nextInt();
			int j=0;
			while(pid.get(j)!=i)
			{
				j++;
				if(j==pid.size())
					break;
			}
			if(j==pid.size())
			{
				System.out.println("Item not found in the cart");
			}
			else
			{
				quant.set(j,up);
				System.out.println("Item updated");
			}
		}
	}
	/*
	 * When customer wants to remove an item
	 * removeItem() will be used
	 */
	void removeItem()
	{
		if(pid.size()==0)
		{
			System.out.println("Cart is already empty");
		}
		else
		{
			System.out.println("Enter the sid of the item to be removed");
			int k=ab.nextInt();
			int j=0;
			while(pid.get(j)!=k)
				j++;
			if(j==pid.size())
				System.out.println("Item not found!");
			else
			{
				pid.remove(j);
				pro.remove(j);
				quant.remove(j);
				price.remove(j);
				System.out.println("Item removed");
			}
		}
	}
	/*
	 * showCart() is for viewing the cart and its items
	 * whenever required
	 */
	void showCart()
	{
		if(pid.size()==0)
		{
			System.out.println("No Item to Show!!");
		}
		else
		{
			int i;
			System.out.println("SID\tPRODUCT\tQUANTITY\tPRICE\n");
			for(i=0;i<pid.size();i++)
			{
				System.out.print(pid.get(i)+"\t");
				System.out.print(pro.get(i)+"\t");
				System.out.print(quant.get(i)+"\t");
				System.out.println(quant.get(i)*price.get(i)+"\t");
			}
		}
	}
	/*
	 * makeBill() will give the total amount of items in the cart
	 */
	void makeBill()
	{
		int i;
		double sum=0;
		for(i=0;i<price.size();i++)
		{
			sum=quant.get(i)*price.get(i)+sum;
		}
		System.out.printf("The total bill is"+sum+"\n");
	}
}

/*
 * The items available are shown and choice of the operation is taken input from the customer
 */
class Shop
{
	public static void main(String args[])
	{
		ArrayList<Item> itemList=new ArrayList<Item>();
		ShoppingCart obj=new ShoppingCart();
		int choice;
		
		System.out.println("The items available in the shop are:");
		itemList.add(new Item(1,"Book",1000.00));
		itemList.add(new Item(2,"Pen",5.00));
		itemList.add(new Item(3,"Ball",100.00));
		itemList.add(new Item(4,"Dress",3000.00));
		itemList.add(new Item(5,"Shoes",1500.00));
		itemList.add(new Item(6,"Mobile",6000.00));
		itemList.add(new Item(7,"Bottle",200.00));
		
	
		do
		{
			System.out.println("Choose the operation needed:");
			System.out.println("1.Add in the cart");
			System.out.println("2.Update the cart");
			System.out.println("3.Remove from the cart");
			System.out.println("4.Show items in the cart");
			System.out.println("5.Make Bill"); 
			System.out.println("6.Exit");
			Scanner sc=new Scanner(System.in);
			choice=sc.nextInt();
			switch(choice)
			{
				case 1:
					
					obj.addItem(itemList);
					break;
				case 2:
					obj.update();
					break;
				case 3:
					obj.removeItem();
					break;
				case 4:
					obj.showCart();
					break;
				case 5:
					obj.makeBill();
					break;
				default:
					System.out.println("Wrong entry\n");
			}
		}while(choice!=6);
	}
}				
				
		
			
		
	
