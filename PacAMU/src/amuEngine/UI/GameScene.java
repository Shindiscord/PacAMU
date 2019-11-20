package amuEngine.UI;


import amuEngine.graphics.*;
import javafx.geometry.Pos;
import javafx.scene.layout.StackPane;

public class GameScene {
	StackPane currentPane;
	
	public void addSprite(Sprite s){
		this.currentPane.getChildren().add(s.getImageView());

	}
	public void removeSprite(Sprite s) {
		this.currentPane.getChildren().remove(s.getImageView());
	}
	
	public GameScene() {
		this.currentPane = new StackPane();
		this.currentPane.setAlignment(Pos.TOP_LEFT);
	}
	public void clear() {
		this.currentPane.getChildren().removeAll(this.currentPane.getChildren());
	}
	public StackPane getPane() {
		return this.currentPane;
	}
}
