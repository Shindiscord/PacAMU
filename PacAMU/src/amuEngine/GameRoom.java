package amuEngine;

import java.util.ArrayList;

import amuEngine.UI.GameScene;
import amuEngine.UI.KeyboardManager;
import amuEngine.UI.TextBox;
import amuEngine.physics.*;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.stage.Stage;

public class GameRoom{
	private GameScene scene;
	private PhysicsEngine pEngine;
	private AnimationTimer timer;
	private ArrayList<amuGameObject> objectList;
	private long prevTime = 0;
	private KeyboardManager kManager;
	
	private boolean isPaused = false;
	
	private int width;
	private int height;
	
	public int getWidth() {
		return this.width;
	}
	public int getHeight() {
		return this.height;
	}
	
	public GameRoom(int refreshRate) {
		this.scene = new GameScene();
		this.kManager = new KeyboardManager();
		this.pEngine = new PhysicsEngine(refreshRate);
		this.objectList = new ArrayList<>();
		this.timer = new AnimationTimer() {
            public void handle(long currentNanoTime){
            	try{
            		if(prevTime == 0)
            			prevTime = currentNanoTime;
            		if((currentNanoTime - prevTime)/1000000 >= 1000/refreshRate){
            			for(amuGameObject o: objectList) {
            				o.update((currentNanoTime-prevTime)/1000000);
            			}            		
            			pEngine.update((currentNanoTime-prevTime)/1000000);
            			prevTime = currentNanoTime;
            		}
            	} catch ( java.util.ConcurrentModificationException exception) {  }
            }
		};
		
	}
	
	public void addObject(amuGameObject o) {
		scene.addSprite(o.getSprite());
		if(o instanceof PhysicalObject)
			pEngine.addObject((PhysicalObject)o);
		if(o instanceof KeyboardListener) {
			this.kManager.addListener((KeyboardListener)o);
		}
		this.objectList.add(o);
	}
	
	public void addBackground(Image bg) {
		this.scene.getPane().setBackground(new Background(new BackgroundImage(bg, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT)));
	}
	
	public void removeObject(amuGameObject o) {
		if(o instanceof PhysicalObject)
			pEngine.removeObject((PhysicalObject)o);
		if(o instanceof KeyboardListener)
			this.kManager.removeListener((KeyboardListener)o);
		this.scene.removeSprite(o.getSprite());
		this.objectList.remove(o);
	}
	
	public void addText(TextBox tb) {
		tb.addToScene(this.scene);
	}
	
	public void addButton(Button b) {
		scene.getPane().getChildren().add(b);
	}
	
	public void start(Stage window, int width, int height) {
		window.setScene(new Scene(scene.getPane(), width, height));
		this.kManager.start(window);
		timer.start();
		this.width = width;
		this.height = height;
		window.show();
		
	}
	
	public void pause() {
		this.isPaused = !this.isPaused;
		if(this.isPaused) {
			this.timer.stop();
		}else {
			this.timer.start();
		}
	}
	
	public void stop() {
		this.kManager = null;
		timer.stop();
	}
}