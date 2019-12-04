package game;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import amuEngine.graphics.*;
import game.map.Grid;
import game.map.TileManager;

import java.io.IOException;

import amuEngine.*;
import amuEngine.UI.TextBox;

/*class TileSetTest implements amuGameObject{
	private Sprite s = new SingleSprite(new Image("/img/tilesetTest.png")
			,546, 418, 1);
	public Sprite getSprite() {return this.s;}
	public void update(long time) {
	}
}*/

public class Test extends Application {
    public static void main(String[] args) {
    	launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	/*
    	Grid grid = null;
		try {
			grid = new Grid("res/mapFiles/map1.txt", 18, 14);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	grid.print();
        primaryStage.setTitle("test1");
        GameRoom room = new GameRoom(40);
        TileManager.placeTiles(room, grid, 32, 32);
        room.addObject(new Student(32, 32, 32*17, 32*13, grid));
        room.addObject(new BoarLvl1(32*3, 32, 32*17, 32*13,grid ,1));
        TextBox tb = new TextBox(100,100);
        tb.setText("AHIOHAOIBFOZA");
        tb.setSize(20);
        room.addText(tb);
        room.start(primaryStage, grid.getLargeur()*32,grid.getHauteur()*32);*/
    	GameManager.init(primaryStage);
    	GameManager.startGame();
    }
}
