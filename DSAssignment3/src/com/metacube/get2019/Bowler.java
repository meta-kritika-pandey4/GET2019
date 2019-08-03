package com.metacube.get2019;

/**
 * It is a class having attributes for the bowlers
 * @author kritika
 *
 */
public class Bowler {
	private String name;
	private int ballQuota;

	/**
	 * It is a constructor for the Bowler class
	 * @param name
	 * @param ballQuota
	 */
	public Bowler (String name, int ballQuota) {
		this.name = name;
		this.ballQuota = ballQuota;
	}

	/**
	 * It is a getter method for name
	 * @return name of the bowler
	 */
	public String getName(){
		return name;
	}

	/**
	 * It is a getter method for ball quota
	 * @return ballQuota 
	 */
	public int getBallQuota(){
		return ballQuota;
	}

	/**
	 * It is a setter method for the ballQuota
	 */
	public void setBallQuota() {
		this.ballQuota--;
	}
}