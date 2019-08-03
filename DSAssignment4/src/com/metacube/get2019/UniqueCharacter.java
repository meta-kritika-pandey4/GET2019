package com.metacube.get2019;

import java.util.HashMap;

/**
 * This class handles string with unique characters
 * @author Kritika
 *
 */
public class UniqueCharacter {

	HashMap<String, Integer> map = new HashMap<>(); 

	/**
	 * This method gives the total no of unique characters in the string
	 * @param str
	 * @return noOfChar no of unique characters
	 */
	public int noOfUniqueChar(String str) {
		if (map.containsKey(str)) {
			return map.get(str);
		}
		else {
			boolean count[] = new boolean[Character.MAX_VALUE];
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == ' '){
					continue;
				}
				count[str.charAt(i)] = true;
			}
			int noOfChar = 0;
			for (int i = 0; i < count.length; i++) {
				if (count[i]) {
					noOfChar++;
				}
			}
			map.put(str, noOfChar);
			return noOfChar;
		}
	}
}