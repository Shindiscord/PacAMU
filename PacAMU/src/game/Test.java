package game;
import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import amuEngine.graphics.*;
import amuEngine.*;

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
        GameRoom room = new GameRoom(40);
        room.addObject(new TileSetTest());
        room.addObject(new Student(64, 64, 640, 480));
        room.start(primaryStage, 640, 480);
    }
}