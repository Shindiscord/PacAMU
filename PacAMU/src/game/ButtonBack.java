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
        ButtonChapterSelection chapterselector = new ButtonChapterSelection(new Image("/img/buttons/selection.png"));
        ButtonInstruction instructions = new ButtonInstruction(new Image("/img/buttons/instructions.png"));
        ButtonQuitGame quitGame = new ButtonQuitGame(new Image("/img/buttons/quitGame.png"));
    	gameMenu.addBackground(new Image("/img/fond.png"));
        chapterselector.setPos(150, 150);
        instructions.setPos(180, 250);
        quitGame.setPos(210,350);
        chapterselector.addToRoom(gameMenu);
        instructions.addToRoom(gameMenu);
        quitGame.addToRoom(gameMenu);
	    GameManager.changeRoom(gameMenu);
	}
}
