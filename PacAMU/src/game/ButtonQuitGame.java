package game;

import javafx.scene.image.Image;
import amuEngine.GameRoom;
import amuEngine.UI.Clickable;

public class ButtonQuitGame extends Clickable {

	public ButtonQuitGame(String name) {
		super(name);
	}
	
	public ButtonQuitGame(Image img) {
		super(img);
	}
	
	public void onClick() {
		GameManager.quitGame();
	}
	
}
