package com.rounceville.gameoflife;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGridMatrix {

	@Test
	public void testCreateArbitraryGrid() {
		GridMatrix gm = new GridMatrix(3,3);
		assertNotEquals(gm, null);
	}

	@Test
	public void testGridKnowsItsLengthAndWidth() {
		GridMatrix gm = new GridMatrix(3,4);
		assertEquals(3, gm.getWidth());
		assertEquals(4, gm.getHeight());		
	}

	@Test
	public void testGridHasAddressability() {
		GridMatrix gm = new GridMatrix(3,4);
		gm.setAt(0,0,false);
		assertEquals(false, gm.getAt(0,0));
		gm.setAt(0,0, true);
		assertEquals(true, gm.getAt(0,0));
		assertEquals(false, gm.getAt(2,3));		
		gm.setAt(2,3, true);
		assertEquals(true, gm.getAt(2,3));		
	}

	@Test
	public void testGridStartsOutAllFalse() {
		GridMatrix gm = new GridMatrix(3,4);
		for(int x = 0; x < gm.getWidth(); x++) 
			for(int y = 0; y < gm.getHeight(); y++)
				assertEquals(false, gm.getAt(x, y));
	}
	
	@Test
	public void testGridStartsOutAllFalseButCanBeSwappedToAllTrue() {
		GridMatrix gm = new GridMatrix(3,4);
		for(int x = 0; x < gm.getWidth(); x++) 
			for(int y = 0; y < gm.getHeight(); y++)
				assertEquals(false, gm.getAt(x, y));
		
		for(int x = 0; x < gm.getWidth(); x++) 
			for(int y = 0; y < gm.getHeight(); y++)
				gm.setAt(x, y, true);
		
		for(int x = 0; x < gm.getWidth(); x++) 
			for(int y = 0; y < gm.getHeight(); y++)
				assertEquals(true, gm.getAt(x, y));
	}

	@Test
	public void testCanCountNeighbors() {
		GridMatrix gm = new GridMatrix(3,4);
		assertEquals(0, gm.countLiveNeighborsAt(1,1));
	}

	
}
