package game;

import java.io.IOException;

import amuEngine.GameRoom;
import amuEngine.UI.Clickable;
import amuEngine.UI.TextBox;
import game.map.Grid;
import game.map.TileManager;
import javafx.scene.image.Image;

public class ButtonChapter1 extends Clickable{

	
	
	public ButtonChapter1(String name) {
		super(name);
		this.button.setMaxSize(220, 50);
	}
	
	public ButtonChapter1(Image img) {
		super(img);
		this.button.setMaxSize(220, 50);
	}
	
	
	public void onClick() {
		GameRoom chapter1 = new GameRoom(40);
        
    	Grid grid = null;
		try {
			grid = new Grid("res/mapFiles/map1.txt", 20, 14);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	grid.print();
    	
        TileManager.placeTiles(chapter1, grid, 32, 32);
        TileManager.placeCollectables(chapter1, grid, 32, 32);
        Student stud = null;
        for(int i=0 ; i<grid.getLargeur() ; i++) {
        	for(int j=0 ; j<grid.getHauteur() ; j++) {
        		if(grid.getTile(i, j) == '1') {
        			stud = new Student(32*i, 32*j, 32*19, 32*13, grid);
        			chapter1.addObject(stud);
        		}
        	}
        }
        for( int i=0 ; i<grid.getLargeur() ; i++) {
        	for( int j=0 ; j<grid.getHauteur() ; j++) {
        		if(grid.getTile(i, j) == '3') {
        	        chapter1.addObject(new BoarLvl2(32*i, 32*j, 32*19, 32*13,grid ,1, stud));
        		}
        		else if (grid.getTile(i, j) == '2'){
        	        chapter1.addObject(new BoarLvl1(32*i, 32*j, 32*19, 32*13,grid ,1));
        		}
        	}
        }
        TextBox tb_life = new TextBox(100,100);
        tb_life.setText("Vie :");
        tb_life.setPos(20, 450);
        tb_life.setSize(20);
        
        stud.setlifeText(tb_life);
        chapter1.addText(tb_life);
        
        TextBox tb_score = new TextBox(100,100);
        tb_score.setText("Score :");
        tb_score.setPos(100, 450);
        tb_score.setSize(20);
        
        stud.setScoreText(tb_score);
        chapter1.addText(tb_score);
        
        TextBox tb_pouvoirs = new TextBox(100,100);
        tb_pouvoirs.setText("Pouvoirs :");
        tb_pouvoirs.setPos(220, 450);
        tb_pouvoirs.setSize(20);
        
        chapter1.addText(tb_pouvoirs);

        /*
        ButtonRestart restart = new ButtonRestart("restart");
        restart.addToRoom(chapter1);
        restart.setPos(500, 400);
        
        ButtonBack back = new ButtonBack("back");
        back.addToRoom(chapter1);
        back.setPos(400, 400);
        */
        GameManager.changeRoom(chapter1);
             
             
        
	}
}
