package game.map;
import amuEngine.*;
import amuEngine.graphics.*;
import javafx.scene.image.Image;

public class Tile implements amuGameObject{
	
	private Sprite s;
	
	public Tile(Image img, int width, int height, int nbImage, int gridX, int gridY) {
		this.s = new SingleSprite(img, width, height, nbImage);
		this.s.setPosition(width * gridX, height * gridY);
	}
	
	public void update(long ms) {}
	public Sprite getSprite() {return this.s;}
}
