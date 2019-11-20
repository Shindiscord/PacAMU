import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import amuEngine.graphics.*;
import amuEngine.*;
import amuEngine.physics.*;
import java.lang.Math;


class PacManTest  extends MovableObject implements amuGameObject, KeyboardListener{
	
<<<<<<< HEAD
	private double gridSize;
	
	private KeyCode currentDirection;
	private KeyCode nextDirection;
	
	private double prevGridX;
	private double prevGridY;
	
=======

>>>>>>> refs/remotes/origin/Alix
	private final SingleSprite sideSprite = new SingleSprite(
			new Image("/img/testLink.png")
			,48, 48, 10);
	private final SingleSprite verticalSprite = new SingleSprite(
			new Image("/img/testLink_down.png")
			,48, 48, 10);
	
	ChangeableSprite s;
	private int bordureH, bordureV;
	
	public Sprite getSprite() {
		return this.s;
	}
	PacManTest(){
		s =  new ChangeableSprite(sideSprite);
		this.setPos(100, 60);
		s.setPosition(100, 60);
		this.setHspeed(5);
<<<<<<< HEAD
		this.gridSize = 32.0;
		this.currentDirection = KeyCode.LEFT;
		this.nextDirection = KeyCode.LEFT;
		this.prevGridX = 0.0;
		this.prevGridY = 0.0;
=======
		
>>>>>>> refs/remotes/origin/Alix
	}
	PacManTest(double x, double y){
		s =  new ChangeableSprite(sideSprite);
		s.setPosition(x, y);
		this.setPos(x, y);
		this.setHspeed(5);
	}
	
<<<<<<< HEAD
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
=======
	PacManTest( double x, double y, int bordureH, int bordureV){
		this.bordureH = bordureH;
		this.bordureV = bordureV;
	}
	
	public void onKeyPressed(KeyCode key) {
		switch(key) {
		case UP:
			this.setHspeed(0);
			this.setVspeed(-5);
			this.s.switchTo(verticalSprite);
			break;
		case DOWN:
			this.setHspeed(0);
			this.setVspeed(5);
			this.s.switchTo(verticalSprite);
			break;
		case LEFT:
			this.setHspeed(-5);
			this.setVspeed(0);
			this.s.switchTo(sideSprite);
			break;
		case RIGHT:
			this.setHspeed(5);
			this.setVspeed(0);
			this.s.switchTo(sideSprite);
>>>>>>> refs/remotes/origin/Alix
			break;
		default:
			
		}
	}
	
	public void onKeyReleased(KeyCode key) {

	}
	
	public void update(long msSinceLastCall){
<<<<<<< HEAD
		
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
						this.s.switchTo(verticalSprite);
						break;
					case DOWN:
						this.setVspeed(5);
						this.setHspeed(0);
						this.s.switchTo(verticalSprite);
						break;
					case LEFT:
						this.setHspeed(-5);
						this.setVspeed(0);
						this.s.switchTo(sideSprite);
						break;
					case RIGHT:
						this.setHspeed(5);
						this.setVspeed(0);
						this.s.switchTo(sideSprite);
						break;
					default:
				}
=======
			this.s.nextSubimage();
			this.s.setPosition(getX() - 24, getY() - 34);
			PacManTest pmt = new PacManTest(100, 100, 640, 480);
			
			if(getX() >= pmt.bordureH) { 
				this.setPos(0, getY());
>>>>>>> refs/remotes/origin/Alix
			}
<<<<<<< HEAD
			this.prevGridX = currentGridX;
			this.prevGridY = currentGridY;
		}
		this.s.setPosition(this.getX()-24, this.getY()-24);
		this.s.nextSubimage();
			
=======
			else if(getX() <= 0) {
				this.setPos(pmt.bordureH, getY());
			}
			else if(getY() >= pmt.bordureV) {
				this.setPos(getX(), 0);
			}
			else if(getY() <= 0) {
				this.setPos(getX(), pmt.bordureV);
			}
		
>>>>>>> refs/remotes/origin/Alix
	}
}

class TileSetTest implements amuGameObject{
	private Sprite s = new SingleSprite(new Image("/img/tilesetTest.png")
			,546, 418, 1);
	public Sprite getSprite() {return this.s;}
	public void update(long time) {
	}
}

public class Test extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("test1");
        GameRoom room = new GameRoom(30);
        room.addObject(new TileSetTest());
        room.addObject(new PacManTest());
        room.start(primaryStage, 640, 480);
    }
}
