package game;

import javafx.scene.image.Image;
import amuEngine.GameRoom;
import amuEngine.UI.Clickable;

public class ButtonBack extends Clickable{
	
	public ButtonBack(String name) {
		super(name);
	}
	
	public ButtonBack(Image img) {
		super(img);
	}
	
	public void onClick() {
		 GameRoom gameMenu = new GameRoom(40);
	     ButtonChapter1 chapter1 = new ButtonChapter1("Chapter 1");
	     ButtonInstruction instructions = new ButtonInstruction(" Instructions ");
	     ButtonQuitGame quitGame = new ButtonQuitGame("Quit Game");
	     gameMenu.addBackground(new Image("/img/fond.png"));
	     chapter1.setPos(230, 100);
	     instructions.setPos(230, 200);
	     quitGame.setPos(230,300);
	     chapter1.addToRoom(gameMenu);
	     instructions.addToRoom(gameMenu);
	     quitGame.addToRoom(gameMenu);
	     GameManager.changeRoom(gameMenu);
	}
}
