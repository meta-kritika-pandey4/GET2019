package com.metacube.get2019;


import java.util.ArrayList;
import java.util.Scanner;
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
	void addItem()
	{
		System.out.println("Enter the SID of the product to be added\n");
		int id=ab.nextInt();
		System.out.println("Enter the quantity required\n");
		int no=ab.nextInt();
		switch(id)
		{
			case 1:
				pid.add(1);
				pro.add("Book");
				quant.add(no);
				price.add(1000.00);
				break;
			case 2:
				pid.add(2);
				pro.add("Pen");
				quant.add(no);
				price.add(5.00);
				break;
			case 3:
				pid.add(3);
				pro.add("Ball");
				quant.add(no);
				price.add(100.00);
				break;
			case 4:
				pid.add(4);
				pro.add("Dress");
				quant.add(no);
				price.add(3000.00);
				break;
			case 5:
				pid.add(5);
				pro.add("Shoes");
				quant.add(no);
				price.add(1500.00);
				break;
			case 6:
				pid.add(6);
				pro.add("Mobile");
				quant.add(no);
				price.add(6000.00);
				break;
			case 7:
				pid.add(7);
				pro.add("Bottle");
				quant.add(no);
				price.add(00.00);
				break;
			default:
				System.out.println("Product not found!!\n");
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
		
		ShoppingCart obj=new ShoppingCart();
		int choice;
		System.out.println("The items available in the shop are:");	//Items in the shop are displayed
		System.out.println("SID\tProduct\tPrice");	
		System.out.println("1.Book\tRs.1000");
		System.out.println("2.Pen\tRs.50");
		System.out.println("3.Ball\tRs.100");
		System.out.println("4.Dress\tRs.3000");
		System.out.println("5.Shoes\tRs.1500");
		System.out.println("6.Mobile\tRs.6000");
		System.out.println("7.Bottle\tRs.200");
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
					obj.addItem();
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
				
		
	
