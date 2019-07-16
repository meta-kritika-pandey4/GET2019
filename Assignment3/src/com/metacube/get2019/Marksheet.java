package com.metacube.get2019;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * It is a class to perform operations
 * on the marks of the students
 * of a class
 * @admin Kritika
 */
public class Marksheet{

	/**
	 * It is a method used to get all the marks of the students
	 * @param marks[]
	 * @param n
	 * @param ab4
	 */
	public void getMarks(float[] marks,int n,Scanner ab){
		try{
			System.out.println("Enter marks of students from 0 to100");
			for(int i=0;i<n;i++){
				float score=ab.nextFloat();
				if(score >=0 && score<=100){
					marks[i]=score;
				}
				else{
					i--;
					System.out.println("Wrong marks");
					System.out.println("If marks are to be entered enter 1");
					int choice=ab.nextInt();
					if(choice==1){
						continue;
					}
					else{
						System.exit(0);
					}
				}
			}
		}
		catch(InputMismatchException e){
			System.out.println("Invalid input.Program is stopped");
		}
	}
	
	/**
	 * It is a method to find the average marks of the class
	 * @param marks[]
	 * @param n
	 * @return avg
	 */
	public float avgGrade(float[] marks,int n){
		float avg=0,sum=0;
		for(int i=0;i<n;i++){
			sum+=marks[i];
		}
		avg=sum/n;
		return avg;
	}
	
	/**
	 * It is a method used to find the maximum marks 
	 * @param marks[]
	 * @param n
	 * @return max
	 */
	public float getMax(float[] marks,int n){
		float max=0;
		for(int i=0;i<n;i++){
			if(marks[i]>max){
				max=marks[i];
			}
		}
		return max;
	}
	
	/**
	 * It is a method used to find the minimum marks 
	 * @param marks[]
	 * @param n
	 * @return min
	 */
	public float getMin(float[] marks,int n){
		float min=getMax(marks,n);
		for(int i=0;i<n;i++){
			if(marks[i]<min){
				min=marks[i];
			}
		}
		return min;
	}
	
	/**
	 * It is a method used to find the percentage of students that passed
	 * @param marks[]
	 * @param n
	 * @return per
	 */
	public float passPer(float[] marks,int n){
		int m=0;
		float per=0;
		for(int i=0;i<n;i++){
			if(marks[i]>=40.00){
				m++;
			}
		}
		per=((float)m/(float)n)*100;
		return per;
	}
}
