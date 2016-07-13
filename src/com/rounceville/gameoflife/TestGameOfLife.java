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
	
	private boolean allDead(GridMatrix gmToTest) {
		for(int x=0;x<gmToTest.getWidth();x++)
			for(int y=0; y < gmToTest.getHeight();y++)
				if(gmToTest.getAt(x, y))
					return false;
		
		return true;
	}
	
	
	@Test
	public void testAnyLiveCellWithFewerThanTwoLiveNeighborsDiesTest1() {
		GridMatrix gm = new GridMatrix(3,4);
		gm.setAt(1, 1, true);
		assertEquals(true, allDead(GameOfLife.nextGeneration(gm)));
		
	}
	
	@Test
	public void testAnyLiveCellWithFewerThanTwoLiveNeighborsDiesTest2() {
		GridMatrix gm = new GridMatrix(3,4);
		gm.setAt(0, 0, true);
		gm.setAt(2, 0, true);
		gm.setAt(0, 3, true);		
		gm.setAt(2, 3, true);
		assertEquals(true, allDead(GameOfLife.nextGeneration(gm)));		
	}	

	@Test
	public void testAnyLiveCellWithFewerThanTwoLiveNeighborsDiesTest3() {
		GridMatrix gm = new GridMatrix(3,4);
		gm.setAt(0, 0, true);
		gm.setAt(2, 0, true);
		gm.setAt(0, 3, true);		
		gm.setAt(2, 3, true);
		gm.setAt(1, 1, true);		
		assertEquals(false, allDead(GameOfLife.nextGeneration(gm)));		
	}	
	
	
}
