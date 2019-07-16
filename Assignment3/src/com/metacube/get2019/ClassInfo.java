package com.metacube.get2019;

import java.util.*;


/**
 * It is a class with main method.
 * @author Kritika
 *
 */
public class ClassInfo{
	public static void main(String args[]){
	
		Scanner sc=new Scanner(System.in);
		Marksheet m=new Marksheet();
		try{
			System.out.println("Enter the no of students in the class");
			int n=sc.nextInt();
			float marks[]=new float[n];
			m.getMarks(marks,n);
			float avg=m.avgGrade(marks,n);
			System.out.printf("Average of all the grades is %.2f",avg);
			System.out.println();
			float max=m.getMax(marks,n);
			System.out.printf("Maximum of all the grades is %.2f",max);
			System.out.println();
			float min=m.getMin(marks,n);
			System.out.printf("Minimum of all the grades is %.2f",min);
			System.out.println();
			float pass=m.passPer(marks,n);
			System.out.printf("Percentage of students passed is %.2f",pass);
			System.out.println();
		}
		catch(InputMismatchException e){
			System.out.println("Wrong input!!");
		}
		finally{
			sc.close();
		}
	}

}