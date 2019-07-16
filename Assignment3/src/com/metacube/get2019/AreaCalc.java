package com.metacube.get2019;

import java.util.*;

/**
 * It is a class with main method.
 * @author Kritika
 *
 */
class AreaCalc{
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		Area a=new Area();
		boolean isExit = false;
		try{
			do
			{
				System.out.println("You can calculate the area of the following:-");
				System.out.println("1.Triangle");
				System.out.println("2.Square");
				System.out.println("3.Rectangle");
				System.out.println("4.Circle");
				System.out.println("5.Exit");
				System.out.println("Enter the ID of the shape whose area is to be calculated");
				int choice=sc.nextInt();
				switch(choice){
				
					case 1:
						System.out.println("Enter the height and base of the triangle");
						System.out.print("Height:");
						double height=sc.nextDouble();
						System.out.print("Base:");
						double width=sc.nextDouble();
						double area=a.triangleArea(height,width);
						System.out.println("Area of the triangle is "+area);
						break;
					case 2:
						System.out.println("Enter the width of the square");
						System.out.print("Width:");
						double width1=sc.nextDouble();
						double area1=a.squareArea(width1);
						System.out.println("Area of the square is "+area1);
						break;
					case 3:
						System.out.println("Enter the height and width of the rectangle");
						System.out.print("Height:");
						double height1=sc.nextDouble();
						System.out.print("Width:");
						double width2=sc.nextDouble();
						a.rectangleArea(height1,width2);
						double area2=a.rectangleArea(height1,width2);
						System.out.println("Area of the rectangle is "+area2);
						break;
					case 4:
						System.out.println("Enter the radius of the circle");
						System.out.print("Radius:");
						double radius=sc.nextDouble();
						double area3=a.circleArea(radius);
						System.out.println("Area of the circle is "+area3);
						break;
					case 5:
						isExit = true;
						System.out.println("Exit!!");
						break;
					default:
						System.out.println("ID not matched!!");
				}
			}while(!isExit);
		}
		catch(InputMismatchException e){
			System.out.println("Invalid input");
		}
		finally{
			sc.close();
		}
	}
}
