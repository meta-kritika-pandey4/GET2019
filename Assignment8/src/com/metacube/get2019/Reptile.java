package com.metacube.get2019;

/**]
 * It is a class which extends animal class.
 * @author Kritika
 *
 */
public abstract class Reptile extends Animal {

	public String speciality;
	
	/**
	 * It is a Reptile class constructor.
	 */
	public Reptile() {
	}
	
	/**
	 * This method is to store speciality of the animal type
	 * @param speciality
	 */
	public void getSpeciality(String speciality) {
		this.speciality = speciality;
	}
}

