package com.metacube.get2019;

import static org.junit.Assert.*;
import org.junit.Test;

/**
 * It is a test case class for BowlerHeap class
 * @author Kritika
 *
 */
public class TestFindBowlerSequence {
	BowlerHeap b;
	
	@Test
	public void testFindBowlerSequence() {
		Bowler[] bowlerList=new Bowler[3];
		bowlerList[0]=new Bowler("Pandya",2);
		bowlerList[1]=new Bowler("Malinga",3);
		bowlerList[2]=new Bowler("Jadeja",4);
		assertEquals("Jadeja Malinga Jadeja Malinga Jadeja Pandya Jadeja Pandya Malinga",b.findSequence(bowlerList.length, bowlerList, 9));
	}
	@Test(expected=AssertionError.class)
	public void testFindBowlerSequenceForZeroBalls() {
		Bowler[] bowlerList=new Bowler[3];
		bowlerList[0]=new Bowler("B01",2);
		bowlerList[1]=new Bowler("B02",3);
		bowlerList[2]=new Bowler("B03",4);
		b.findSequence(bowlerList.length, bowlerList, 0);

	}
	@Test(expected=AssertionError.class)
	public void testFindBowlerSequenceForZeroBowlers() {
		Bowler[] bowlerList=new Bowler[3];
		b.findSequence(bowlerList.length, bowlerList, 0);

	}
}
