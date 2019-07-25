package com.metacube.get2019;

/**
 * it is a bird class which extends animal class.
 * @author Kritika
 *
 */
public abstract class Bird extends Animal {
	
	public String speciality;
	
	/**
	 * It is a bird class constructor.
	 */
	public Bird() {
	}
	
	/**
	 * This method is to store speciality of the animal type
	 * @param speciality
	 */
	public void getSpeciality(String speciality) {
		this.speciality = speciality;
	}
}
