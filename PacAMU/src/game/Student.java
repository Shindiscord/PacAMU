package game;

import amuEngine.graphics.*;
import amuEngine.*;
import amuEngine.physics.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;

import java.lang.Math;
import game.map.Grid;


class Student  extends MovableObject implements amuGameObject, KeyboardListener, Collidable{
	
	private double gridSize;
	private boolean updateSprite;
	
	private KeyCode currentDirection;
	private KeyCode nextDirection;
	
	private int vies = 3;
	
	private Grid map;
	
	private double startingX;
	private double startingY;
	
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
	
	Student(double x, double y, int bordureH, int bordureV, Grid map){
		this.updateSprite = false;
		s =  new ChangeableSprite(rightSprite);
		s.setPosition(x, y);
		this.setPos(x, y);
		this.gridSize = 32;
		this.currentDirection = KeyCode.RIGHT;
		this.nextDirection = KeyCode.RIGHT;
		this.setHspeed(4);
		this.bordureH = bordureH;
		this.bordureV = bordureV;
		this.startingX = x;
		this.startingY = y;
		this.map = map;
	}
	
	public Rectangle getHitbox() {
		return new Rectangle(this.getX(), this.getY(), 20, 20);
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
		case P:
			GameManager.getCurrentRoom().pause();
		default:
			
		}
	}
	
	public void onKeyReleased(KeyCode key) {

	}
	
	public void onCollide(Collidable c) {
		if(c instanceof Boar) {
			this.vies--;
			if(this.vies > 0)
				this.setPos(startingX, startingY);
			else
				GameManager.gameOver();
			
			System.out.println("Vies : " + this.vies);
		}
	}
	
	public void update(long msSinceLastCall){
		
		double currentGridX = Math.floor(this.getX()/this.gridSize);
		double currentGridY = Math.floor(this.getY()/this.gridSize);
		
		
		
		if((this.getX()%this.gridSize == 0 && this.getY()%this.gridSize == 0)){
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
		
		
		
		
		this.s.setPosition(this.getX(), this.getY()-20);
		this.updateSprite = !this.updateSprite;
		if(this.updateSprite)
			this.s.nextSubimage();
	}
}