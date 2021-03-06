package com.rounceville.gameoflife;

import java.util.BitSet;

public class GridMatrix {

	private BitSet[] bsRowArray;
	int iMyWidth = 0;
	int iMyHeight = 0;
	
	public GridMatrix(int iWidth, int iHeight) {
		iMyWidth = iWidth;
		iMyHeight = iHeight;
		bsRowArray = new BitSet[iHeight];
		for (int i = 0; i < iHeight; i++)
			bsRowArray[i] = new BitSet(iWidth);		
	}

	public int getWidth() {
		return iMyWidth;
	}

	public int getHeight() {
		return iMyHeight;	
	}

	public void setAt(int x, int y, boolean b) {
		if(b)
			bsRowArray[y].set(x);
		else
			bsRowArray[y].clear(x);
	}

	public boolean getAt(int x, int y) {
		return bsRowArray[y].get(x);
	}
	
	public void print() {
		for(int y=0;y<getHeight();y++) {		
			for(int x=0;x<getWidth();x++) {
				if(getAt(x,y))
					System.out.print("*");
				else
					System.out.print(".");
			}
			System.out.println("\n");
		}
				
	}

	public int countLiveNeighborsAt(int x, int y) {
		int iNumLiveNeighbors = 0;
		
		if(x-1 >= 0 && y-1 >= 0 && getAt(x-1, y-1))
			iNumLiveNeighbors++;
		if(y-1 >= 0 && getAt(x  , y-1))
			iNumLiveNeighbors++;
		if(x+1 < getWidth() && y-1 >= 0 && getAt(x+1, y-1))
			iNumLiveNeighbors++;
		if(x-1 >= 0 && getAt(x-1, y))
			iNumLiveNeighbors++;
		if(x+1 < getWidth() && getAt(x+1, y))
			iNumLiveNeighbors++;
		if(x-1 >= 0 && y+1 < getHeight() && getAt(x-1, y+1))
			iNumLiveNeighbors++;
		if(y+1 < getHeight() && getAt(x, y+1))
			iNumLiveNeighbors++;
		if(x+1 < getWidth() && y+1 < getHeight() && getAt(x+1, y+1))
			iNumLiveNeighbors++;

		
		return iNumLiveNeighbors;
	}

}
