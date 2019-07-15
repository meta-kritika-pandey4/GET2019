/*
 * package com.metacube.
 */
package com.metacube.get2019;
import java.util.*;

/*
 * This class has the attributes pro(Product),quant(Quantity), 
 * pid(ProductID) and price(Cost) 
 * This class also has all the functions of a Shopping Cart
 */
public class ShoppingCart 
{
	//ArrayList are for storing the input
	ArrayList<String> pro=new ArrayList<String>();
	ArrayList<Integer> quant=new ArrayList<Integer>();
	ArrayList<Integer> pid=new ArrayList<Integer>();
	ArrayList<Double> price=new ArrayList<Double>();
	ArrayList<CartItem> cart=new ArrayList<CartItem>();

	/*
	 * addItem() adds items in the cart 
	 * while taking the input from the customer
	 */
	public void addItem(ArrayList<Item> itemList)
	{
		Scanner ab=new Scanner(System.in);
		
		try
		{
			System.out.print("Enter the product id of the product");
			int itemId=ab.nextInt();
			Iterator<Item> iterator=itemList.iterator();
			while(iterator.hasNext())
			{	
				Item i=(Item)iterator.next();
				if (i.getid()==itemId)
				{
					pro.add(i.getItemName());
					System.out.print("Enter quantity for the item");
					int itemQuantity=ab.nextInt();
					quant.add(itemQuantity);
					price.add(i.getprice());
					pid.add(i.getid());
					System.out.println("Item is successfully added into cart.");
					CartItem c=new CartItem(i.getid(),itemQuantity,i.getprice(),i.getItemName());
				}
			}
		}
		catch(InputMismatchException e)
		{
			System.out.println("Wrong input");
		}
		finally
		{
			ab.close();
		}
		
	}
	/*
	 * update() is for changing the quantity of a particular item in the cart
	 * as required by the customer
	 */
	public void update()
	{
		if(pid.size()==0)
		{
			System.out.println("No item in the cart!! Please first enter some!!");
		}
		else
		{
			Scanner ab=new Scanner(System.in);
			try
			{
				System.out.println("Enter the Product id of the product to be updated");
				int i=ab.nextInt();
				System.out.println("Enter the quantity to be updated");
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
			catch(InputMismatchException e)
			{
				System.out.println("Wrong input");
			}
			finally
			{
				ab.close();
			}
		}
	}
	/*
	 * When customer wants to remove an item
	 * removeItem() will be used
	 */
	public void removeItem()
	{
		if(pid.size()==0)
		{
			System.out.println("Cart is already empty");
		}
		else
		{
			Scanner ab=new Scanner(System.in);
			try
			{
				System.out.println("Enter the product id of the item to be removed");
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
			catch(InputMismatchException e)
			{
				System.out.println("Wrong input");
			}
			finally
			{
				ab.close();	
			}
		}
	}
	/*
	 * showCart() is for viewing the cart and its items
	 * whenever required
	 */
	public void showCart()
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
	public void makeBill()
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

