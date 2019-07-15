/*
 * package com.metacube.
 */
package com.metacube.get2019;
import java.util.*;

/*
 * The items available are shown and choice of the operation is taken input from the customer
 */
public class Shop
{
	public static void main(String args[])
	{
		ArrayList<Item> itemList=new ArrayList<Item>();
		ShoppingCart obj=new ShoppingCart();
		int choice;
		System.out.println("The items available in the shop are:");
		System.out.println("PID\tPRODUCT\tPRICE\t");
		System.out.println("----------------------------------------");
		itemList.add(new Item(1,"Book",1000.00));
		itemList.add(new Item(2,"Pen",5.00));
		itemList.add(new Item(3,"Ball",100.00));
		itemList.add(new Item(4,"Dress",3000.00));
		itemList.add(new Item(5,"Shoes",1500.00));
		itemList.add(new Item(6,"Mobile",6000.00));
		itemList.add(new Item(7,"Bottle",200.00));
		try
		{
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
					sc.close();
			}while(choice!=6);
		}
		catch(InputMismatchException e)
		{
			System.out.println("Invalid input!!");
		}
	}
}				
				
		
			
		
	

