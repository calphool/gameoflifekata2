package com.rounceville.gameoflife;

public class GridMatrix {

	int iMyWidth = 0;
	int iMyHeight = 0;
	
	public GridMatrix(int iWidth, int iHeight) {
		iMyWidth = iWidth;
		iMyHeight = iHeight;
	}

	public int getWidth() {
		return iMyWidth;
	}

	public int getHeight() {
		return iMyHeight;	}

}
