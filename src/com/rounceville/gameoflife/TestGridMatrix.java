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

	

}
