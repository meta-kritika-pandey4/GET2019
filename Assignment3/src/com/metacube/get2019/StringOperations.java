package com.metacube.get2019;

/**
 * The class has methods to
 * perform operations on Strings
 * @author Kritika
 *
 */
public class StringOperations {

	/**
	 * This is a method which is used to reverse a string without using API function
	 * @param str It is the string which is to be reverse.
	 * @return reverseString 
	 */
	public String reverse(String str) {
		String reverseString = "";
		for (int i=(str.length())-1; i>=0; i--){
			reverseString += str.charAt(i);
		}
		return reverseString;
	}
	
	/**
	 * It is method which is used to compare 2 string for equality
	 * @param str1 First String
	 * @param str2 Second String
	 * @return 1 if strings are equal and 0 if not equal.
	 */
	public int compare2String(String str1, String str2) {
		int len1 = str1.length();
		int len2 = str2.length();
		if(len1 != len2) {
			return 0;
		}
		boolean flag = true;
		for (int i=0; i<len1; i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				flag = false;
				break;
			}
		}
		if (flag){
			return 1;
		}
		else{
			return 0;
		}
	}
	
	/**
	 * It is method which is used to reverse case of string without using API.
	 * @param str String 
	 * @return reversed case String.
	 */
	public String reverseCase(String str) {
		String reverseCaseString = "";
		for (int i=0; i<(str.length()); i++) {
			char ch = str.charAt(i);
			if ( ch >= 65 && ch <= 90) {
				ch = (char)(ch + 32);
			}
			else if (ch >= 97 && ch <= 122) {
				ch = (char)(ch -32);
			}
			reverseCaseString += ch ;
		}
		return reverseCaseString;
	}
	
	/**
	 * It is a method which is used to return largest word among a string.
	 * @param str string
	 * @return largest word of string
	 */
	public String largestWordOfString(String str) {
		String largestWord;
		String[] words = str.split(" ");
		int length = words.length;
		largestWord = words[0];
		for (int i=1; i<length; i++) {
			if (largestWord.length() <= (words[i].length())) {
				largestWord = words[i];
			}
		}
		return largestWord;
	}
}

