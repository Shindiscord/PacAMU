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
			grid = new Grid("res/mapFiles/map1.txt", 19, 14);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	grid.print();
    	
        TileManager.placeTiles(chapter1, grid, 32, 32);
        TileManager.placeCollectables(chapter1, grid, 32, 32);
        Student stud = new Student(64, 32, 32*18, 32*13, grid);
        chapter1.addObject(stud);
        chapter1.addObject(new BoarLvl2(32*7, 32*4, 32*18, 32*13,grid ,1, stud));
        chapter1.addObject(new BoarLvl1(32*8, 32*4, 32*18, 32*13,grid ,1));
        TextBox tb = new TextBox(100,100);
        tb.setText("Vie :");
        tb.setPos(20, 420);
        tb.setSize(20);
        stud.setlifeText(tb);
        
        chapter1.addText(tb);
        GameManager.changeRoom(chapter1);
        
	}
}
