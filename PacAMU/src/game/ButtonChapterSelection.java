package game;

import java.io.IOException;

import amuEngine.GameRoom;
import amuEngine.UI.Clickable;
import amuEngine.UI.TextBox;
import game.map.Grid;
import game.map.TileManager;
import javafx.scene.image.Image;

public class ButtonChapterSelection extends Clickable{

		
		
	public ButtonChapterSelection(Image image) {
		super(image);
	}
	
	public ButtonChapterSelection(String name) {
		super(name);
		this.button.setMaxSize(220, 50);
	}

		
	public void onClick() {
		GameRoom gameMenu = new GameRoom(40);
		gameMenu.addBackground(new Image("/img/fond.png"));
        ButtonChapter1 chapter1 = new ButtonChapter1(new Image("/img/buttons/chapter1.png"));
        chapter1.setPos(210, 150);
        ButtonChapter2 chapter2 = new ButtonChapter2(new Image("/img/buttons/chapter2.png"));
        chapter2.setPos(210, 250);
        ButtonChapter3 chapter3 = new ButtonChapter3(new Image("/img/buttons/chapter3.png"));
        chapter3.setPos(210, 350);
        
        chapter1.addToRoom(gameMenu);
        chapter2.addToRoom(gameMenu);
        chapter3.addToRoom(gameMenu);
	    GameManager.changeRoom(gameMenu);
	}
}
