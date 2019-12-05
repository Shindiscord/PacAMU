package game;

import amuEngine.graphics.*;
import amuEngine.*;
import amuEngine.UI.TextBox;
import amuEngine.physics.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.shape.Rectangle;

import java.lang.Math;
import game.map.Grid;


public class Student  extends MovableObject implements amuGameObject, KeyboardListener, Collidable{
	
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
	private TextBox lifeText;
	private TextBox scoreText;
	
	private SingleSprite leftSprite;
	private SingleSprite upSprite;
	
	private SingleSprite rightSprite;
	private SingleSprite downSprite;
	
	ChangeableSprite s;
	
	private Coffee coffeePowaIcon;
	private Boots bootsPowaIcon;
	
	private int bordureH, bordureV;
	
	public Sprite getSprite() {
		return this.s;
	}
	
	private boolean coffeePowa;
	private long coffeePowaUsage;
	private boolean bootsPowa;
	private boolean bootsPowaIsUsed;
			
	public boolean getCoffeePowaState() {
		return coffeePowa;
	}
	
	public void setCoffeeState(boolean state) {
		this.coffeePowa = state;
		if (state) {
			coffeePowaUsage = 5_000;
			coffeePowaIcon = new Coffee(310,450);
			GameManager.getCurrentRoom().addObject(coffeePowaIcon);
		}
		else {
			GameManager.getCurrentRoom().removeObject(coffeePowaIcon);
		}
		if (state) System.out.println("L'étudiant s'excite");
	}
	
	public void setBootsState(boolean state) {
		this.bootsPowa = state;
		if (state) {
			System.out.println("L'étudiant mets des bottes");
			bootsPowaIcon = new Boots(350,450);
			GameManager.getCurrentRoom().addObject(bootsPowaIcon);
		}
		else {
			GameManager.getCurrentRoom().removeObject(bootsPowaIcon);
		}
	}
	
	
	public void setlifeText(TextBox t) {
		this.lifeText = t;
		t.setText("Vies : " + this.vies);
	}
	
	public void setScoreText(TextBox t) {
		this.scoreText = t;
		t.setText("Score : " + GameManager.getScore());
	}
		
	
	Student(double x, double y, int bordureH, int bordureV, Grid map){
		this.updateSprite = false;
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
		this.coffeePowa = false;
		this.bootsPowa = false;
		this.bootsPowaIsUsed = false;
		this.coffeePowaUsage = 0;
		if(GameManager.getIsFemale()) {
			this.leftSprite = new SingleSprite(
					new Image("/img/Player/girl_l_30_51.png")
					,30, 51, 8);
			this.upSprite = new SingleSprite(
					new Image("/img/Player/girl_u_30_51.png")
					,30, 51, 8);
			
			this.rightSprite = new SingleSprite(
					new Image("/img/Player/girl_r_30_51.png")
					,30, 51, 8);
			this.downSprite = new SingleSprite(
					new Image("/img/Player/girl_d_30_51.png")
					,30, 51, 8);
		}
		else {
			this.leftSprite = new SingleSprite(
					new Image("/img/Player/male_l_30_51_8.png")
					,30, 51, 8);
			this.upSprite = new SingleSprite(
					new Image("/img/Player/male_u_30_51_8.png")
					,30, 51, 8);
			
			this.rightSprite = new SingleSprite(
					new Image("/img/Player/male_r_30_51_8.png")
					,30, 51, 8);
			this.downSprite = new SingleSprite(
					new Image("/img/Player/male_d_30_51_8.png")
					,30, 51, 8);
		}
		s =  new ChangeableSprite(rightSprite);
		s.setPosition(x, y);
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
			if ( coffeePowa ) {
				GameManager.addScore(500);
				this.scoreText.setText("Score : " + GameManager.getScore());
				GameManager.getCurrentRoom().removeObject((amuGameObject) c); 
			}
			else {
				this.vies--;
				if(this.vies > 0) {
					this.setPos(startingX, startingY);
					this.lifeText.setText("Vies : " + this.vies);
				}else
					GameManager.gameOver();
			
				System.out.println("Vies : " + this.vies);
			}
		}
	}
	
	public void update(long msSinceLastCall){
		
		if ( coffeePowa ) {
			coffeePowaUsage -= msSinceLastCall;
			if(coffeePowaUsage <= 0) {
				coffeePowaUsage = 0;
				setCoffeeState(false);
			}
		}
		
		double currentGridX = Math.floor(this.getX()/this.gridSize);
		double currentGridY = Math.floor(this.getY()/this.gridSize);
		
		//check collectables
		this.map.pickCollectable(this, (int) (this.getX()/this.gridSize), (int) (this.getY()/this.gridSize));
		this.scoreText.setText("Score : " + GameManager.getScore());
		if( this.map.getNbSheetsRemaining() <= 0 ) {
			GameManager.victory();
		}

		
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
			if(bootsPowa == false && this.map.nextIsAWall((int) currentGridX, (int)currentGridY, this.currentDirection)) {
				this.setVspeed(0);
				this.setHspeed(0);
			}
			if(bootsPowa && this.map.getTile((int) currentGridX, (int) currentGridY) == 'm') {
				this.bootsPowaIsUsed = true;
			}
			if(bootsPowa && bootsPowaIsUsed && this.map.getTile((int) currentGridX, (int) currentGridY) != 'm') {
				this.setBootsState(false);
				this.bootsPowaIsUsed = false;
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