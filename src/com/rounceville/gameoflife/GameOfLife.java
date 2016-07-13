package com.rounceville.gameoflife;

public class GameOfLife {

	public static GridMatrix nextGeneration(GridMatrix gm) {
		GridMatrix gm2 = cloneGridMatrix(gm);
		
		for(int x=0;x<gm.getWidth();x++) {
			for(int y=0;y<gm.getHeight();y++) {
				int iLiveNeighborCount = gm.countLiveNeighborsAt(x, y);
				if(iLiveNeighborCount < 2 && gm.getAt(x, y))
					gm2.setAt(x, y, false);
				if(iLiveNeighborCount > 3 && gm.getAt(x, y))
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
