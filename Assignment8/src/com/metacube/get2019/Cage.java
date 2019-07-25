package com.metacube.get2019;

/**
 * It is a cage class which have attributes cageType and AnimalCapacity
 * @author Kritika
 *
 */
public class Cage {
	public String cageType;
	public int animalCapacity;
	
	/**
	 *It is a constructor used to initialize cage class attributes.
	 * @param cageType type of cage.
	 * @param currentCapacity current capacity of cage.
	 */
	public Cage (String cageType, int currentCapacity) {
		 this.cageType = cageType;
		 this.animalCapacity = currentCapacity;
	 }
	
}

