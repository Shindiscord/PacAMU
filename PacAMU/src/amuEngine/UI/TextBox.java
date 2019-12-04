package amuEngine.UI;

import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class TextBox {
	private Text javafxText;
	private StackPane parent;
	
	public void setPos(double x, double y){
		javafxText.setTranslateX(x);
		javafxText.setTranslateY(y);
	}
	
	public void setText(String text) {
		javafxText.setText(text);
	}
	
	public void remove() {
		if(parent != null)
			parent.getChildren().remove(this.javafxText);
	}
	
	public void addToScene(GameScene scene) {
		if( this.parent != null)
			this.remove();
		this.parent = scene.getPane();
		this.parent.getChildren().add(javafxText);
	}
	
	public TextBox(double x, double y) {
		this.javafxText = new Text();
		this.setPos(x, y);
	}
	
	public void setSize(int size) {
		this.javafxText.setFont(new Font(size));
	}
	
}
