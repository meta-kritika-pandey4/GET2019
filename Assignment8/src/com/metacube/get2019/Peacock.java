package com.metacube.get2019;

/**
 * It is a peacock class which extends bird class.
 * @author Kritika
 *
 */
class Peacock extends Bird{
	
	/**
	 * It is a constructor used to initialize peacock attributes.
	 * @param id id of peacock.
	 * @param name name of peacock
	 */
	public Peacock(int id ,String name){
		this.id = id;
		this.name = name;
	}
	@Override
	public String getSound() {
		return "Scream";
	}

}