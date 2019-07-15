package com.metacube.get2019;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * It is a class with main method.
 * @author Admin
 *
 */
public class Hex {

	public static void main(String args[]) {
		HexFunctions obj = new HexFunctions();
		Scanner sc = new Scanner(System.in);
		String hex1, hex2;
		int base, n;
		try {
			boolean exit = false;
			do {
				System.out.println("------------------------");
				System.out.println("Enter your choice\n ");
				System.out.println("1. Addition of hexadecimal number");
				System.out.println("2. Subtraction of hexadecimal number");
				System.out.println("3. Multiplication of hexadecimal number");
				System.out.println("4. Division of hexadecimal number");
				System.out.println("5. Compare 2 hexadecimal number");
				System.out.println("6. Hexadecimal to decimal conversion");
				System.out.println("7. Decimal to hexadecimal conversion");
				System.out.println("8. Exit the program");
				System.out.println("------------------------");
				int choice = sc.nextInt();
				sc.nextLine();
				switch (choice) {
				case 1:
					System.out.print("Enter the no of terms you want to add = ");
					n = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter the base = ");
					base = sc.nextInt();
					if(base!=16){
						break;
					}
					else{
						sc.nextLine();
						obj.hexAddition(n,base);
					}
					break;
				case 2:
					System.out.print("Enter the first hexadecimal String = ");
					hex1 = sc.nextLine();
					System.out.print("Enter the second hexadecimal String = ");
					hex2 = sc.nextLine();
					System.out.print("Enter the base = ");
					base = sc.nextInt();
					if(base!=16){
						System.out.println("Only base 16 is applicable");
						break;
					}
					else{
						sc.nextLine();
						obj.hexSubtraction(hex1, hex2, base);
					}
					break;
				case 3:
					System.out.print("Enter the no of terms you want to multiply = ");
					n = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter the base = ");
					base = sc.nextInt();
					if(base!=16){
						System.out.println("Only base 16 is applicable");
						break;
					}
					else{
						sc.nextLine();
						obj.hexMultiplication(n,base);
					}
					break;
				case 4:
					System.out.print("Enter the first hexadecimal String = ");
					hex1 = sc.nextLine();
					System.out.print("Enter the second hexadecimal String = ");
					hex2 = sc.nextLine();
					System.out.print("Enter the base = ");
					base = sc.nextInt();
					if(base!=16){
						System.out.println("Only base 16 is applicable");
						break;
					}
					else{
						sc.nextLine();
						obj.hexDivision(hex1, hex2, base);
					}
					break;
				case 5:
					System.out.print("Enter the first hexadecimal String = ");
					hex1 = sc.nextLine();
					System.out.print("Enter the second hexadecimal String = ");
					hex2 = sc.nextLine();
					System.out.print("Enter the base = ");
					base=sc.nextInt();
					if(base!=16){
						System.out.println("Only base 16 is applicable");
						break;
					}
					else{
						base = sc.nextInt();
						sc.nextLine();
						obj.compareHexStringss(hex1, hex2);
					}
					break;
				case 6:
					System.out.print("Enter the hexadecimal String = ");
					hex1 = sc.nextLine();
					System.out.print("Enter the base = ");
					base = sc.nextInt();
					if(base!=16){
						System.out.println("Only base 16 is applicable");
						break;
					}
					else{
						sc.nextLine();
						int value = obj.hexToDec(hex1, base);
						System.out.println("Decimal representation = "+value);
					}
					break;
				case 7:
					System.out.print("Enter the decimal number = ");
					int dec1 = sc.nextInt();
					sc.nextLine();
					System.out.print("Enter the base = ");
					base = sc.nextInt();
					if(base!=16){
						System.out.println("Only base 16 is applicable");
						break;
					}
					else{
						sc.nextLine();
						String hexValue = obj.decTohex(dec1, base);
						System.out.println("Hexadeciaml value = "+hexValue);
					}
					break;
				case 8:
					exit = true;
					HexFunctions ob=new HexFunctions();
					ob.showMessage("Succesfully exited");
					break;
				default:
					HexFunctions obj1=new HexFunctions();
					obj1.showMessage("Succesfully exited");
				}
			} while (!exit);
		} catch (InputMismatchException e) {
			System.out.println(e.getStackTrace());
		}
		
	}
}
