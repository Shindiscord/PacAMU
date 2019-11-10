package amuEngine;

import java.util.ArrayList;

import amuEngine.UI.GameScene;
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
	
	public GameRoom(int refreshRate) {
		scene = new GameScene();
		pEngine = new PhysicsEngine(refreshRate);
		this.objectList = new ArrayList<>();
		this.timer = new AnimationTimer() {
            public void handle(long currentNanoTime){
            	if(prevTime == 0)
            		prevTime = currentNanoTime;
            	if(currentNanoTime - prevTime > 1000000) {
            		pEngine.update((currentNanoTime-prevTime)/1000000);
            		for(amuGameObject o: objectList) {
            			o.update((currentNanoTime-prevTime)/1000000);
            		}
            		prevTime = currentNanoTime;
            	}
            }
		};
	}
	
	public void addObject(amuGameObject o) {
		scene.addSprite(o.getSprite());
		if(o instanceof PhysicalObject)
			pEngine.addObject((PhysicalObject)o);
		this.objectList.add(o);
	}
	
	
	public void start(Stage window, int width, int height) {
		window.setScene(new Scene(scene.getPane(), 500, 250));
		timer.start();
		window.show();
	}
	
	public void stop() {
		timer.stop();
	}
}