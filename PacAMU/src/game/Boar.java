package game;

import amuEngine.amuGameObject;
import amuEngine.graphics.ChangeableSprite;
import amuEngine.graphics.SingleSprite;
import amuEngine.graphics.Sprite;
import amuEngine.physics.Collidable;
import amuEngine.physics.MovableObject;
import game.map.Grid;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;

public abstract class Boar extends MovableObject implements amuGameObject, Collidable {
	
	protected double startingX;
	protected double startingY;

	protected int colorIteration;
	
	protected double gridSize;
	protected boolean updateSprite;
	
	protected KeyCode currentDirection;
	protected KeyCode nextDirection;
	
	protected Grid map;
	
	protected double prevGridX;
	protected double prevGridY;
	
	protected SingleSprite leftSprite;
	protected SingleSprite upSprite;
	protected SingleSprite rightSprite;
	protected SingleSprite downSprite;
	
	protected ChangeableSprite s;
	protected int bordureH, bordureV;
	
	public void onCollide(Collidable c) {
		if(c instanceof Student) {
			//this.setPos(startingX, startingY);
		}
	}
	
	public Rectangle getHitbox() {
		return new Rectangle(this.getX(), this.getY(), 25, 25);
	}

	
	public Boar (double x, double y,int bordureH, int bordureV,Grid map ,int iteration) {
		this.colorIteration = iteration;
		this.bordureH = bordureH;
		this.bordureV = bordureV;
		this.gridSize = 32;
		this.startingX = x;
		this.startingY = y;
		this.setPos(x, y);
		this.map = map;
		this.currentDirection = KeyCode.UP;
		this.chooseDirection(this.getX()/32, this.getY()/32);
		this.nextDirection = this.currentDirection;
	}
	
	protected abstract KeyCode chooseDirection(double currentGridX, double currentGridY);
	
	
	public void update(long msSinceLastCall){
		
		double currentGridX = Math.floor(this.getX()/this.gridSize);
		double currentGridY = Math.floor(this.getY()/this.gridSize);
		
		if((this.getX()%this.gridSize == 0 && this.getY()%this.gridSize == 0)){
			
			this.nextDirection = this.chooseDirection(currentGridX, currentGridY);
			
			if(this.currentDirection != this.nextDirection) {
				this.currentDirection = this.nextDirection;
				switch(this.nextDirection) {
					case UP:
						this.setVspeed(-4);
						this.setHspeed(0);
						this.s.switchTo(upSprite);
						break;
					case DOWN:
						this.setVspeed(4);
						this.setHspeed(0);
						this.s.switchTo(downSprite);
						break;
					case LEFT:
						this.setHspeed(-4);
						this.setVspeed(0);
						this.s.switchTo(leftSprite);
						break;
					case RIGHT:
						this.setHspeed(4);
						this.setVspeed(0);
						this.s.switchTo(rightSprite);
						break;
					default:
				}
			}
			//Check for walls
			if(this.map.nextIsAWall((int) currentGridX, (int)currentGridY, this.currentDirection)) {
				this.setVspeed(0);
				this.setHspeed(0);
			}
		}
		//Checks for edges of screen
		if(this.getX() >= this.bordureH+1) {
			this.setPos(0, this.getY());
		}
		if(this.getX() <= -1) {
			this.setPos(this.bordureH, this.getY());
		}
		if(this.getY() >= this.bordureV+1) {
			this.setPos(this.getX(), 0);
		}
		if(this.getY() <= -1) {
			this.setPos(this.getX(), this.bordureV);
		}
				
		this.s.setPosition(this.getX(), this.getY()-7);
		this.updateSprite = !this.updateSprite;
		if(this.updateSprite)
			this.s.nextSubimage();
	}
	
	public Sprite getSprite() {
		return this.s;
	}
}
