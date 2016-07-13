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
	

}
