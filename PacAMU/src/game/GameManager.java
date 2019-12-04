package game;

import java.io.IOException;

import amuEngine.GameRoom;
import amuEngine.UI.TextBox;
import game.map.Grid;
import game.map.TileManager;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public abstract class GameManager {
	
	private static Stage _window;
	
	private static GameRoom currentRoom;
	
	public static GameRoom getCurrentRoom() {
		return currentRoom;
	}
	
	public static void gameOver() {
		currentRoom.stop();
		GameRoom gameOverRoom = new GameRoom(40);
		TextBox tb = new TextBox(100, 100);
		tb.setText("GAME OVER");
		tb.setColor(Color.DARKRED);
		tb.setSize(40);
		gameOverRoom.addText(tb);
		gameOverRoom.start(_window,currentRoom.getWidth() , currentRoom.getHeight());
		
		currentRoom = gameOverRoom;
	}
	
	public static void changeRoom(GameRoom newRoom) {
		currentRoom.stop();
		newRoom.start(_window, currentRoom.getWidth(), currentRoom.getHeight());
		currentRoom = newRoom;
	}
	
	public static void init(Stage window) {
		_window = window;
	}
	
	public static void startGame() {
    	Grid grid = null;
		try {
			grid = new Grid("res/mapFiles/map1.txt", 18, 14);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	grid.print();
		_window.setTitle("test1");
        GameRoom room = new GameRoom(40);
        TileManager.placeTiles(room, grid, 32, 32);
        Student stud = new Student(32, 32, 32*17, 32*13, grid);
        room.addObject(stud);
        room.addObject(new BoarLvl2(32*7, 32*4, 32*17, 32*13,grid ,1, stud));
        //room.addObject(new BoarLvl1(32*8, 32*4, 32*17, 32*13,grid ,1));
        TextBox tb = new TextBox(100,100);
        tb.setText("AHIOHAOIBFOZA");
        tb.setSize(20);
        
        room.addText(tb);
        room.start(_window, grid.getLargeur()*32, grid.getHauteur()*32);
        currentRoom = room;
	}
}
