package com.metacube.get2019;

/**
 * It is a Mammal class which extends animal class.
 * @author Kritika
 *
 */
public abstract class Mammal extends Animal {

	public String speciality;
	
	/**
	 * It is a Mammal class constructor.
	 */
	public Mammal() {
	}
	
	/**
	 * This method is to store speciality of the animal type
	 * @param speciality
	 */
	public void getSpeciality(String speciality) {
		this.speciality = speciality;
	}

}
