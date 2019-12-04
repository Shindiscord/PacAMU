package game;

import amuEngine.graphics.*;
import amuEngine.*;
import javafx.scene.image.Image;

public class Coffee implements amuGameObject{
	
	private boolean updateSprite;
	
	private double pos_X;
	private double pos_Y;
	
	public double getPos_X() {
		return pos_X;
	}
	
	public double getPos_Y() {
		return pos_Y;
	}
	
	private final SingleSprite sprite = new SingleSprite(
			new Image("img/Collectable/covfefe_32_30_6.png"), 
			32, 30, 6);
	
	public Sprite getSprite() {
		return this.sprite;
	}
	
	public Coffee(double x, double y){
		this.updateSprite = false;
		this.sprite.setPosition(x, y);
		this.pos_X = x;
		this.pos_Y = y;
	}
	
	public void update(long msSinceLastCall) {
		this.sprite.setPosition(this.getPos_X(), this.getPos_Y());
		this.updateSprite = !this.updateSprite;
		if(this.updateSprite)
			this.sprite.nextSubimage();
	}
}
