package game.map;

import java.util.Random;

import amuEngine.GameRoom;
import javafx.scene.image.Image;

public class TileManager {

	static Image[] grass = new Image[6];;		

	static Image ground_basic = new Image("/img/Ground/Walkable/basic.png");
	static Image ground_u = new Image("/img/Ground/Walkable/u.png");
	static Image ground_l = new Image("/img/Ground/Walkable/l.png");
	static Image ground_r = new Image("/img/Ground/Walkable/r.png");
	static Image ground_d = new Image("/img/Ground/Walkable/d.png");
	static Image ground_dlu = new Image("/img/Ground/Walkable/dlu.png");
	static Image ground_dr = new Image("/img/Ground/Walkable/dr.png");
	static Image ground_ld = new Image("/img/Ground/Walkable/ld.png");
	static Image ground_ldr = new Image("/img/Ground/Walkable/ldr.png");
	static Image ground_lr = new Image("/img/Ground/Walkable/lr.png");
	static Image ground_lu = new Image("/img/Ground/Walkable/lu.png");
	static Image ground_lur = new Image("/img/Ground/Walkable/lur.png");
	static Image ground_ud = new Image("/img/Ground/Walkable/ud.png");
	static Image ground_ur = new Image("/img/Ground/Walkable/ur.png");
	static Image ground_urd = new Image("/img/Ground/Walkable/urd.png");


	
	private static void init() {
		for( int i=1 ; i<7 ; i++ ) {
			String name = "/img/Ground/Unwalkable/grass" + i + ".png";
			TileManager.grass[i-1] = new Image(name);
		}
	}
	
	public static void placeTiles(GameRoom room, Grid grid, int tile_width, int tile_height) {
		init();
		Random r = new Random();
		
		for( int i=0 ; i<grid.getLargeur() ; i++ ) {
			for( int j=0 ; j<grid.getHauteur() ; j++) {
				if( grid.getTile(i, j) == 'm') {
					room.addObject(new Tile(grass[r.nextInt(5)], tile_width, tile_height, 1, i, j));
				}
				if ( grid.getTile(i, j) == '0') {
					char above = grid.getTile(i, (j-1)%grid.getHauteur());
					char below = grid.getTile(i, (j+1)%grid.getHauteur());
					char right = grid.getTile(((i+1)%grid.getLargeur()), j);
					char  left = grid.getTile(((i-1)%grid.getLargeur()), j);
								
					//cas où tout les cotés sont des chemins
					if( above != 'm' && below != 'm' && right != 'm' && left != 'm')
						room.addObject(new Tile(ground_basic, tile_width, tile_height, 1, i, j));
					//cas où mur a gauche
					if( above != 'm' && below != 'm' && right != 'm' && left == 'm')
						room.addObject(new Tile(ground_l, tile_width, tile_height, 1, i, j));

					//cas où mur a droite
					if( above != 'm' && below != 'm' && right == 'm' && left != 'm')
						room.addObject(new Tile(ground_r, tile_width, tile_height, 1, i, j));

					//cas où mur a haut
					if( above == 'm' && below != 'm' && right != 'm' && left != 'm')
						room.addObject(new Tile(ground_u, tile_width, tile_height, 1, i, j));

					//cas où mur a bas
					if( above != 'm' && below == 'm' && right != 'm' && left != 'm')
						room.addObject(new Tile(ground_d, tile_width, tile_height, 1, i, j));

					//cas où mur a gauche et en haut
					if( above == 'm' && below != 'm' && right != 'm' && left == 'm')
						room.addObject(new Tile(ground_lu, tile_width, tile_height, 1, i, j));									
				
					//cas où mur en haut et a droite
					if( above == 'm' && below != 'm' && right == 'm' && left != 'm')
						room.addObject(new Tile(ground_ur, tile_width, tile_height, 1, i, j));
					
					//cas où mur a droite et en bas
					if( above != 'm' && below == 'm' && right == 'm' && left != 'm')
						room.addObject(new Tile(ground_dr, tile_width, tile_height, 1, i, j));
					
					//cas où mur a gauche et en bas 
					if( above != 'm' && below == 'm' && right != 'm' && left == 'm')
						room.addObject(new Tile(ground_ld, tile_width, tile_height, 1, i, j));
					
					//cas où mur a gauche et a droite
					if( above != 'm' && below != 'm' && right == 'm' && left == 'm')
						room.addObject(new Tile(ground_lr, tile_width, tile_height, 1, i, j));
					
					//cas où mur en haut et en bas
					if( above == 'm' && below == 'm' && right != 'm' && left != 'm')
						room.addObject(new Tile(ground_ud, tile_width, tile_height, 1, i, j));
					
					//cas où mur a gauche, haut et droite
					if( above == 'm' && below != 'm' && right == 'm' && left == 'm')
						room.addObject(new Tile(ground_lur, tile_width, tile_height, 1, i, j));
					
					//cas où mur en haut, droite et en bas
					if( above == 'm' && below == 'm' && right == 'm' && left != 'm')
						room.addObject(new Tile(ground_urd, tile_width, tile_height, 1, i, j));
					
					//cas où mur a gauche, bas et a droite
					if( above != 'm' && below == 'm' && right == 'm' && left == 'm')
						room.addObject(new Tile(ground_ldr, tile_width, tile_height, 1, i, j));
					
					//cas où mur a gauche, haut et en bas
					if( above == 'm' && below == 'm' && right != 'm' && left == 'm')
						room.addObject(new Tile(ground_dlu, tile_width, tile_height, 1, i, j));
				}
			}
		}
	}
}
