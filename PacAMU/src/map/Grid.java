package map;

import java.util.ArrayList;


enum TileType{WALL, PATH, NOTYLE}

public class Grid {
	private TileType[][] grid;
	
	
	public Grid(int width, int height) {
		this.grid = new TileType[width][height];
		for(int i = 0; i < width; i++) {
			for(int j = 0; i < height; i++){
				grid[i][j] = TileType.NOTYLE;
			}
		}
	}
	
	public void setTile(int x, int y, TileType type) {
		this.grid[x][y] = type; 
	}
	public TileType getTile(int x, int y) {
		return this.grid[x][y];
	}
}
