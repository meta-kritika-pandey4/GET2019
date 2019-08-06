package com.metacube.get2019;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * It is a class with main method
 * @author Kritika
 *
 */
public class DictionaryMain {

	/**
	 * It is a main method.
	 * @param args unused
	 * @throws Exception
	 */
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		boolean isExit = false;
		String key;
		DictImp dictObj1 = null;
		List<Value> valueList = new ArrayList<Value>();
		List<Value> rangeValueList = new ArrayList<Value>();
		try {
			do {
				System.out.println("1. Insert into dictionary.");
				System.out.println("2. Delete a key from dictionary");
				System.out.println("3. Get value of key.");
				System.out.println("4. Get sorted list of key value pair.");
				System.out.println("5. Get sorted list of key value pair within a range.");
				System.out.println("6. Exit");
				System.out.print("Enter your choice : ");
				int choice = sc.nextInt();
				sc.nextLine();
				switch(choice) {
				case Constant.ONE:
					Object obj = new JSONParser().parse(new FileReader(Constant.JSON_FILEPATH)); 
					JSONObject jsonObj = (JSONObject) obj;
					dictObj1 = new DictImp(jsonObj);	  
					break;
				case Constant.TWO :
					System.out.print("Enter the key which you want to delete : ");
					key = sc.nextLine();
					dictObj1.delete(key);
					break;
				case Constant.THREE :
					System.out.print("Enter the key whose value you want to find : ");
					key = sc.nextLine();
					String value = dictObj1.getValue(key);
					System.out.println("Value of key "+ key + " : "+value);
					break;
				case Constant.FOUR :
					valueList = dictObj1.getAll();
					dictObj1.showList(valueList);
					break;
				case Constant.FIVE :
					System.out.print("Enter the starting key of range : ");
					String key1 = sc.nextLine();
					System.out.print("Enter the ending key of range : ");
					String key2 = sc.nextLine();
					rangeValueList = dictObj1.getBetween(key1, key2);
					dictObj1.showList(rangeValueList);
					break;
				case Constant.SIX :
					isExit = true;
					System.out.println("Successfully Exit!!!");
					break;
				default :
					System.out.println("Invalid choice.");
				}

			} while (!isExit);

		} catch (InputMismatchException e) {
			System.out.println(e.getStackTrace());
		}finally {
			sc.close();
		}
	}
}