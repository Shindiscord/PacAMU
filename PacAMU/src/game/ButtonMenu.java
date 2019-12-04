package game;

import amuEngine.GameRoom;
import amuEngine.UI.Clickable;
import amuEngine.UI.TextBox;

public class ButtonMenu extends Clickable {
	
	public ButtonMenu(String nom) {
		super(nom);
	}

	
	public void onClick() {
		GameRoom chapters = new GameRoom(40);
		
		TextBox tb = new TextBox(100, 100);
		tb.setText("Hello");
		tb.setSize(40);
		GameManager.changeRoom(chapters);
	}
	
}
