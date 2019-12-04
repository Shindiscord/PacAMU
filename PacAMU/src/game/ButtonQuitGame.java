package game;

import javafx.scene.image.Image;
import amuEngine.GameRoom;
import amuEngine.UI.Clickable;

public class ButtonQuitGame extends Clickable {

	public ButtonQuitGame(String name) {
		super(name);
		this.button.setMaxSize(220, 50);
	}
	
	public ButtonQuitGame(Image img) {
		super(img);
		this.button.setMaxSize(220, 50);
	}
	
	public void onClick() {
		GameManager.quitGame();
	}
	
}
