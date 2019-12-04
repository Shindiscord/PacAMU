package game;

import javafx.scene.image.Image;
import amuEngine.UI.Clickable;

public class ButtonCharacterF extends Clickable{
	
	public ButtonCharacterF(String name) {
		super(name);
		this.getButton().setMaxSize(50, 50);
	}
	
	public ButtonCharacterF(Image img) {
		super(img);
		this.getButton().setMaxSize(50, 50);
	}
	
	
	public void onClick() {
		//System.out.println("j'ai cliqué");
	}

}
