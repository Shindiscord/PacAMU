import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import amuEngine.graphics.*;
import amuEngine.*;
import amuEngine.UI.GameScene;
import amuEngine.physics.*;



class PacManTest  extends MovableObject implements amuGameObject{
	
	private double nextVspeed;
	private double nextHspeed;
	private long timeSinceLastUpdate = 0;
	private int nextDirectionUpdate = 20;
	private final SingleSprite sideSprite = new SingleSprite(
			new Image("/img/testLink.png")
			,48, 48, 10);
	private final SingleSprite verticalSprite = new SingleSprite(
			new Image("/img/testLink_down.png")
			,48, 48, 10);
	
	ChangeableSprite s;
	
	public Sprite getSprite() {
		return this.s;
	}
	PacManTest(){
		s =  new ChangeableSprite(sideSprite);
		this.setPos(5, 10);
		s.setPosition(5, 10);
		this.nextHspeed = 0;
		this.nextVspeed = 5;
		this.setHspeed(5);
	}
	public void update(long msSinceLastCall){
		timeSinceLastUpdate += msSinceLastCall;
		if(timeSinceLastUpdate >= 40) {
			this.s.nextSubimage();
			this.s.setPosition(getX(), getY());
			this.timeSinceLastUpdate = 0;
			this.nextDirectionUpdate --;
			if(this.nextDirectionUpdate <= 0) {
				this.setHspeed(this.nextHspeed);
				this.setVspeed(this.nextVspeed);
				if(this.nextHspeed != 0) {
					this.s.switchTo(sideSprite);
					this.nextVspeed = this.nextHspeed;
					this.nextHspeed = 0;
				}else {
					this.s.switchTo(verticalSprite);
					this.nextHspeed = -this.nextVspeed;
					this.nextVspeed = 0;
				}
				this.nextDirectionUpdate = 20;
			}
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
