package game.map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javafx.scene.input.KeyCode;

public class Grid {

	private File f;
	private FileReader fr;
	private BufferedReader br;
	private char[][] map;
	private int largeur;
	private int hauteur;
	
	
	public char getTile(int x, int y) {
		return this.map[x][y];
	}
	
	public boolean isAWall(int x, int y) {
		if(x < 0 || x >= this.largeur || y < 0 || y >= this.hauteur)
			return false;
		if(this.map[x][y] == 'm')
			return true;
		return false;
	}
	
	public boolean nextIsAWall(int x, int y, KeyCode direction) {
		switch(direction) {
			case UP:
				return isAWall(x, y-1);
			case DOWN:
				return isAWall(x, y+1);
			case LEFT:
				return isAWall(x-1, y);
			case RIGHT:
				return isAWall(x+1, y);
			default:
				System.out.println("Not a direction for a wall");
				return false;
		}
	}
	
	public Grid(String address, int x, int y) throws IOException {
		this.f = new File(address);
		this.fr = new FileReader(this.f);
		this.br = new BufferedReader(this.fr);
		this.map = new char[x][y];
		this.largeur = x;
		this.hauteur = y;
		
		int c = 0; int i = 0; int j = 0;
		
		while((c = br.read()) != -1) {
			if(Character.isWhitespace(c)) {
				continue;
			}
			this.map[i][j] = (char) c; //conversion integer -> char
			
			i++;

			if ( i >= x){
				i = 0;
				j++;
				if(j >= y) {
					break;
				}
			}
		}
	}
	
	public void print() {
		for(int i = 0 ; i < hauteur ; i++) {
			for(int j = 0 ; j < largeur ; j++) {
				System.out.print(map[j][i] + " ");
			}
			System.out.println("");
		}
	}
}
