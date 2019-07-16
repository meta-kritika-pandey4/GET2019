package com.metacube.get2019;

/**
 * The class has methods for
 * some program based error handling 
 * that is required
 * @author Kritika
 *
 */
public class Utility {
	
	/**
	 * For no entity situation
	 */
	public void isValidate(){
		System.out.println("There is no data present to perform operations");
		System.exit(0);
	}
	
	/**
	 * When a string with no value is passed
	 * then situation is handled
	 * @param str
	 * @return
	 */
	public boolean isValidString(String str){
		if(str.length()==0)
		{
			System.out.println("You didn't enter any string");
			return false;
		}
		return true;
	}

}
