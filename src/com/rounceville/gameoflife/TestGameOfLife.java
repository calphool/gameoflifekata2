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

}
