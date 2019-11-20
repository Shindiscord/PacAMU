package game;

import amuEngine.graphics.*;
import amuEngine.*;
import amuEngine.physics.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

import java.lang.Math;


class Student  extends MovableObject implements amuGameObject, KeyboardListener{
	
	private double gridSize;
	private boolean updateSprite;
	
	private KeyCode currentDirection;
	private KeyCode nextDirection;
	
	private double prevGridX;
	private double prevGridY;
	
	private final SingleSprite leftSprite = new SingleSprite(
			new Image("/img/Player/male_l_30_51_8.png")
			,30, 51, 8);
	private final SingleSprite upSprite = new SingleSprite(
			new Image("/img/Player/male_u_30_51_8.png")
			,30, 51, 8);
	
	private final SingleSprite rightSprite = new SingleSprite(
			new Image("/img/Player/male_r_30_51_8.png")
			,30, 51, 8);
	private final SingleSprite downSprite = new SingleSprite(
			new Image("/img/Player/male_d_30_51_8.png")
			,30, 51, 8);
	
	ChangeableSprite s;
	private int bordureH, bordureV;
	
	public Sprite getSprite() {
		return this.s;
	}
	
	Student(double x, double y, int bordureH, int bordureV){
		this.updateSprite = false;
		s =  new ChangeableSprite(rightSprite);
		s.setPosition(x, y);
		this.setPos(x, y);
		this.gridSize = 32;
		this.currentDirection = KeyCode.RIGHT;
		this.nextDirection = KeyCode.RIGHT;
		this.setHspeed(5);
		this.bordureH = bordureH;
		this.bordureV = bordureV;
	}
	
	public void onKeyPressed(KeyCode key) {
		switch(key) {
		case UP:
			this.nextDirection = KeyCode.UP;
			break;
		case DOWN:
			this.nextDirection = KeyCode.DOWN;
			break;
		case LEFT:
			this.nextDirection = KeyCode.LEFT;
			break;
		case RIGHT:
			this.nextDirection = KeyCode.RIGHT;
			break;
		default:
			
		}
	}
	
	public void onKeyReleased(KeyCode key) {

	}
	
	public void update(long msSinceLastCall){
		
		double currentGridX = Math.floor(this.getX()/this.gridSize);
		double currentGridY = Math.floor(this.getY()/this.gridSize);
		
		if(this.currentDirection == KeyCode.LEFT) {
			currentGridX += 1.0;
		}
		if(this.currentDirection == KeyCode.UP) {
			currentGridY += 1.0 ;
		}
		
		if(currentGridX != this.prevGridX || currentGridY != this.prevGridY) {
			if(this.currentDirection != this.nextDirection) {
				this.setPos(currentGridX*this.gridSize,currentGridY*this.gridSize);
				this.currentDirection = this.nextDirection;
				switch(this.nextDirection) {
					case UP:
						this.setVspeed(-5);
						this.setHspeed(0);
						this.s.switchTo(upSprite);
						break;
					case DOWN:
						this.setVspeed(5);
						this.setHspeed(0);
						this.s.switchTo(downSprite);
						break;
					case LEFT:
						this.setHspeed(-5);
						this.setVspeed(0);
						this.s.switchTo(leftSprite);
						break;
					case RIGHT:
						this.setHspeed(5);
						this.setVspeed(0);
						this.s.switchTo(rightSprite);
						break;
					default:
				}
			}
			this.prevGridX = currentGridX;
			this.prevGridY = currentGridY;
			
		}
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
		this.s.setPosition(this.getX()-15, this.getY()-25);
		this.updateSprite = !this.updateSprite;
		if(this.updateSprite)
			this.s.nextSubimage();
	}
}