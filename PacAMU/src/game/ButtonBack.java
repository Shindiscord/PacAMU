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
        ButtonChapter1 chapter1 = new ButtonChapter1(new Image("/img/buttons/chapter1.png"));
        ButtonInstruction instructions = new ButtonInstruction(new Image("/img/buttons/instructions.png"));
        ButtonQuitGame quitGame = new ButtonQuitGame(new Image("/img/buttons/quitGame.png"));
    	gameMenu.addBackground(new Image("/img/fond.png"));
        chapter1.setPos(210, 150);
        instructions.setPos(180, 250);
        quitGame.setPos(210,350);
        chapter1.addToRoom(gameMenu);
        instructions.addToRoom(gameMenu);
        quitGame.addToRoom(gameMenu);
	    GameManager.changeRoom(gameMenu);
	}
}
