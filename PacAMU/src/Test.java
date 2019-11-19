import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import amuEngine.graphics.*;
import amuEngine.*;
import amuEngine.physics.*;


class PacManTest  extends MovableObject implements amuGameObject, KeyboardListener{
	

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
		
	}
	PacManTest(double x, double y){
		s =  new ChangeableSprite(sideSprite);
		s.setPosition(x, y);
		this.setPos(x, y);
		this.setHspeed(5);
	}
	
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
			break;
		default:
			
		}
	}
	
	public void onKeyReleased(KeyCode key) {

	}
	
	public void update(long msSinceLastCall){
			this.s.nextSubimage();
			this.s.setPosition(getX() - 24, getY() - 34);
			PacManTest pmt = new PacManTest(100, 100, 640, 480);
			
			if(getX() >= pmt.bordureH) { 
				this.setPos(0, getY());
			}
			else if(getX() <= 0) {
				this.setPos(pmt.bordureH, getY());
			}
			else if(getY() >= pmt.bordureV) {
				this.setPos(getX(), 0);
			}
			else if(getY() <= 0) {
				this.setPos(getX(), pmt.bordureV);
			}
		
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
        room.addObject(new PacManTest());
        room.start(primaryStage, 640, 480);
    }
}
