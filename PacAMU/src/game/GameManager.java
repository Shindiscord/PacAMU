package game;

import java.io.IOException;

import amuEngine.GameRoom;
import amuEngine.UI.TextBox;
import game.map.Grid;
import game.map.TileManager;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public abstract class GameManager {
	
	private static Stage _window;
	
	private static GameRoom currentRoom;
	
	private static int score = 0;
	
	public static GameRoom getCurrentRoom() {
		return currentRoom;
	}
	
	public static void addScore(int n) {
		score += n;
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

		_window.setTitle("test1");
        GameRoom gameMenu = new GameRoom(40);
        ButtonChapter1 chapter1 = new ButtonChapter1(new Image("/img/buttons/chapter1.png"));
        ButtonInstruction instructions = new ButtonInstruction(new Image("/img/buttons/instructions.png"));
        ButtonQuitGame quitGame = new ButtonQuitGame(new Image("/img/buttons/quitGame.png"));
        chapter1.setPos(230, 100);
        instructions.setPos(230, 200);
        quitGame.setPos(230,300);
        currentRoom = gameMenu;
        chapter1.addToRoom(gameMenu);
        instructions.addToRoom(gameMenu);
        quitGame.addToRoom(gameMenu);
        gameMenu.start(_window, 640, 480);
        //room.start(_window, grid.getLargeur()*32, grid.getHauteur()*32);
	}
	
	public static void quitGame() {
		_window.close();
	}
}
