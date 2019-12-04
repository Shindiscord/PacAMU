package game;


import amuEngine.graphics.*;
import amuEngine.*;
import javafx.scene.image.Image;

public class Sheet implements amuGameObject{
	
	private double pos_X;
	private double pos_Y;
	
	public double getPos_X() {
		return pos_X;
	}
	
	public double getPos_Y() {
		return pos_Y;
	}
	
	private final SingleSprite sprite = new SingleSprite(
			new Image("img/Collectable/sheet_30_30_1.png"), 
			30, 30, 1);
	
	public Sprite getSprite() {
		return this.sprite;
	}
	
	public Sheet(double x, double y){
		this.sprite.setPosition(x, y);
		this.pos_X = x;
		this.pos_Y = y;
	}
	
	public void update(long msSinceLastCall) {
		this.sprite.setPosition(this.getPos_X(), this.getPos_Y());
		
	}
}
