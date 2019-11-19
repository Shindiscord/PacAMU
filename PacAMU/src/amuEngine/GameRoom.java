package amuEngine;

import java.util.ArrayList;

import amuEngine.UI.GameScene;
import amuEngine.UI.KeyboardManager;
import amuEngine.physics.*;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameRoom{
	private GameScene scene;
	private PhysicsEngine pEngine;
	private AnimationTimer timer;
	private ArrayList<amuGameObject> objectList;
	private long prevTime = 0;
	private KeyboardManager kManager;
	
	public GameRoom(int refreshRate) {
		this.scene = new GameScene();
		this.kManager = new KeyboardManager();
		this.pEngine = new PhysicsEngine(refreshRate);
		this.objectList = new ArrayList<>();
		this.timer = new AnimationTimer() {
            public void handle(long currentNanoTime){
            	if(prevTime == 0)
            		prevTime = currentNanoTime;
            	if((currentNanoTime - prevTime)/1000000 >= 1000/refreshRate){
            		for(amuGameObject o: objectList) {
            			o.update((currentNanoTime-prevTime)/1000000);
            		}            		
            		pEngine.update((currentNanoTime-prevTime)/1000000);
            		prevTime = currentNanoTime;
            	}
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
	
	
	public void start(Stage window, int width, int height) {
		window.setScene(new Scene(scene.getPane(), width, height));
		this.kManager.start(window);
		timer.start();
		window.show();
	}
	
	public void stop() {
		this.kManager = null;
		timer.stop();
	}
}