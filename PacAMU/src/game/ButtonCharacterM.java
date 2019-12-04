package game;

import amuEngine.UI.Clickable;
import javafx.scene.image.Image;

public class ButtonCharacterM extends Clickable {

	public ButtonCharacterM(String name) {
		super(name);
		this.getButton().setMaxSize(50, 50);
	}
	
	public ButtonCharacterM(Image img) {
		super(img);
		this.getButton().setMaxSize(50, 50);
	}
	
	
	public void onClick() {
		//System.out.println("j'ai cliqué");
	}
}
