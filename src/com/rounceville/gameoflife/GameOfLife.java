package com.rounceville.gameoflife;

public class GameOfLife {

	public static GridMatrix nextGeneration(GridMatrix gm) {
		GridMatrix gm2 = new GridMatrix(gm.getWidth(), gm.getHeight());
		return gm2;
	}

}
