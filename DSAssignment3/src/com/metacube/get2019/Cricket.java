package com.metacube.get2019;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * It is the class with the main method
 * @author kritika
 *
 */
public class Cricket {
	public static void main( String args[] ){
		Scanner sc = new Scanner(System.in);
		try{
			Bowler b;
			System.out.println("Enter the total no of balls :");
			int totalBalls = sc.nextInt();
			System.out.println("Enter the total no of bowlers :");
			int totalBowlers = sc.nextInt();
			BowlerHeap bowlSeq = new BowlerHeap(totalBowlers);
			System.out.println("Enter the quota of balls for every bowler");
			for( int i = 0; i < totalBowlers; i++){
				System.out.println("Enter the name of the Bowler :");
				sc.nextLine();
				String name = sc.nextLine();
				System.out.println(name);
				
				System.out.print("No of balls for "+ name + " :");
				int quota = sc.nextInt();
				b = new Bowler( name, quota );
				
				bowlSeq.insert(b);
			}
			
			//Sequencing the bowlers entry
			System.out.println("Sequence of bowlers in which they give their balls :-");
			for( int i = 0; i < totalBalls; i++ ){
				b = bowlSeq.extractMax();
				System.out.println(b.getBallQuota());
				System.out.println(b.getName());
				b.setBallQuote();
				if(!(b.getBallQuota()==0)){
					bowlSeq.insert(b);
				}
			}
		} catch ( InputMismatchException e){
			System.out.println(e.getStackTrace());
		} finally {
			sc.close();
		}
	}
}	
