package game.map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Grid {

	private File f;
	private FileReader fr;
	private BufferedReader br;
	private char[][] map;
	private int largeur;
	private int hauteur;
	
	public int getLargeur() {
		return this.largeur;
	}
	
	public int getHauteur() {
		return this.hauteur;
	}
	
	public char getTile(int x, int y) {
		return this.map[x][y];
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
