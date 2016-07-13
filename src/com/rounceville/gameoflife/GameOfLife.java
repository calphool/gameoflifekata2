package com.rounceville.gameoflife;

public class GameOfLife {

	public static GridMatrix nextGeneration(GridMatrix gm) {
		GridMatrix gm2 = cloneGridMatrix(gm);
		
		for(int x=0;x<gm.getWidth();x++) {
			for(int y=0;y<gm.getHeight();y++) {
				if(gm.countLiveNeighborsAt(x, y) < 2)
					gm2.setAt(x, y, false);
			}
		}
		
		return gm2;
	}
	
	private static GridMatrix cloneGridMatrix(GridMatrix gm) {
		GridMatrix newGridMatrix = new GridMatrix(gm.getWidth(), gm.getHeight());
		for(int x=0;x<gm.getWidth();x++)
			for(int y=0;y<gm.getHeight();y++)
				newGridMatrix.setAt(x, y, gm.getAt(x, y));
		return newGridMatrix;
	}

}
