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
		GridMatrix gm2 = GameOfLife.nextGeneration(gm);
		assertEquals(false, allDead(gm2));
		assertEquals(true, gm2.getAt(1, 1));
		assertEquals(false, gm2.getAt(0, 0));		
		assertEquals(false, gm2.getAt(2, 0));		
		assertEquals(false, gm2.getAt(0, 3));
		assertEquals(false, gm2.getAt(2, 3));		
	}	
	
	@Test
	public void testAnyLiveCellWithMoreThanThreeLiveNeighborsDiesTest() {
		GridMatrix gm = new GridMatrix(3,4);
		gm.setAt(1, 1, true);
		gm.setAt(0, 0, true);		
		gm.setAt(0, 2, true);
		gm.setAt(2, 2, true);		
		gm.setAt(2, 0, true);
		GridMatrix gm2 = GameOfLife.nextGeneration(gm);
		assertEquals(true, allDead(gm2));
	}
	
	@Test
	public void testAnyLiveCellWithMoreThanThreeLiveNeighborsDiesTest2() {
		GridMatrix gm = new GridMatrix(3,4);
		gm.setAt(1, 0, true);
		gm.setAt(0, 0, true);		
		gm.setAt(0, 1, true);
		gm.setAt(1, 1, true);		
		gm.setAt(2, 1, true);
		GridMatrix gm2 = GameOfLife.nextGeneration(gm);
		assertEquals(false, gm2.getAt(1, 0));
		assertEquals(false, gm2.getAt(1, 1));		
	}
	
	@Test
	public void testAnyLiveCellWithMoreThanThreeLiveNeighborsDiesTest3() {
		GridMatrix gm = new GridMatrix(3,4);
		gm.setAt(1, 1, true);
		gm.setAt(1, 0, true);		
		gm.setAt(0, 1, true);
		gm.setAt(1, 2, true);		
		gm.setAt(2, 1, true);
		GridMatrix gm2 = GameOfLife.nextGeneration(gm);
		assertEquals(false, gm2.getAt(1, 1));
	}

	@Test
	public void testAnyLiveCellWithTwoOrThreeLiveNeighborsLivesOnToTheNextGenerationTest1() {
		GridMatrix gm = new GridMatrix(3,4);
		gm.setAt(0, 0, true);	
		gm.setAt(1, 0, true);
		gm.setAt(2, 0, true);
		GridMatrix gm2 = GameOfLife.nextGeneration(gm);
		assertEquals(false, gm2.getAt(0, 0));
		assertEquals(true,  gm2.getAt(1, 0));
		assertEquals(false, gm2.getAt(2, 0));
	}

	@Test
	public void testAnyLiveCellWithTwoOrThreeLiveNeighborsLivesOnToTheNextGenerationTest2() {
		GridMatrix gm = new GridMatrix(3,4);
		gm.setAt(0, 0, true);	
		gm.setAt(1, 0, true);
		gm.setAt(2, 0, true);
		gm.setAt(1, 1, true);		
		GridMatrix gm2 = GameOfLife.nextGeneration(gm);
		assertEquals(true , gm2.getAt(0, 0));
		assertEquals(true,  gm2.getAt(1, 0));
		assertEquals(true, gm2.getAt(2, 0));
		assertEquals(true, gm2.getAt(1, 1));		
	}
	
}
