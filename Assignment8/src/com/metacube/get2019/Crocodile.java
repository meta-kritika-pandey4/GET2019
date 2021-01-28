package com.metacube.get2019;

/**
 * It is an crocodile class which extends reptile class.
 * @author Kritika
 *
 */
class Crocodile extends Reptile {
	
	/**
	 * It is a constructor used to initialize crocodile attributes.
	 * @param id id of crocodile.
	 * @param name name of crocodile.
	 */
	public Crocodile(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String getSound() {

		return "Hiss";
	}

}