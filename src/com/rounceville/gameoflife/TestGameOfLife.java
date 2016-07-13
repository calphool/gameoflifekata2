package com.rounceville.gameoflife;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestGameOfLife {

	@Test
	public void testNextGenerationExists() {
		GridMatrix gm = new GridMatrix(3,4);
		GameOfLife.nextGeneration(gm);
		assertEquals(3, gm.getWidth());
	}

	@Test
	public void testNextGenerationProducesNewGridMatrix() {
		GridMatrix gm = new GridMatrix(3,4);
		GridMatrix gm2 = GameOfLife.nextGeneration(gm);
		assertNotEquals(gm, gm2);		
		assertEquals(GridMatrix.class, gm2.getClass());
	}

	
}
