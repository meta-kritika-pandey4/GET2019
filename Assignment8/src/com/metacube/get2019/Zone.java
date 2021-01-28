package com.metacube.get2019;

/**
 * It is zone class with attributes category and cageCapacity.
 * @author Kritika
 *
 */
public class Zone {
	
	public String category;
	public int cageCapacity;
	public int zoneCount;
	
	/**
	 * It is a constructor used to initialize zone attributes.
	 * @param category category of zone
	 * @param cageCapacity cage capacity of zone.
	 */
	public Zone(String category , int cageCapacity){
		this.category = category;
		this.cageCapacity= cageCapacity;
	
	}
	
	/**
	 * It is a method used to count number of zone.
	 * @return zoneCount.
	 */
	public int getZoneCount() {
		return zoneCount;
	}
		
}
	
