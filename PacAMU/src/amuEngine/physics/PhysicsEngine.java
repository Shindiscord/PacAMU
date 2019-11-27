package amuEngine.physics;

import java.util.ArrayList;
import javafx.scene.shape.Rectangle;

public class PhysicsEngine {
	
	ArrayList<PhysicalObject> objectList;
	ArrayList<PhysicalObject> collectibleList;
	PhysicalObject playerObject;
	
	public PhysicsEngine(int refreshRate) {
		this.objectList = new ArrayList<>();
		this.collectibleList = new ArrayList<>();
	}

	public void update(long msSinceLastCall) {
		for(PhysicalObject o: objectList) {
			if(o instanceof MovableObject) {
				((MovableObject)o).updatePos();
			}
			this.checkEntityCollisions();
			this.checkCollection();
		}
	}
	public void addObject(PhysicalObject o) {
		if(this.objectList.isEmpty()){
			this.playerObject = o;
		}
		if(o instanceof MovableObject) 
			this.objectList.add(o);
		else if(o instanceof CollectibleObject)
			this.collectibleList.add(o);
	}

	public int checkEntityCollisions(){
		Rectangle playerBounds=this.playerObject.getBounds(); // Récupère les limites du sprite du joueur
		for(PhysicalObject o: objectList){
			if(o instanceof UncontrollableObject) { //Pour chaque ennemi
				Rectangle entityBounds = o.getBounds(); //Recupere les limites du sprite
				if((playerBounds.getBoundsInParent()).intersects(entityBounds.getBoundsInParent())) {
					System.out.println("boop");
					return 0;
					//o.getFoe() ? this.playerObject.death() : this.playerObject.kill(); //Condition bonus/vanilla
				}
			}
		}
		return 1;
	}

	public int checkCollection(){
		Rectangle playerBounds=this.playerObject.getBounds(); 
		for(PhysicalObject o: collectibleList){
			Rectangle itemBounds = o.getBounds(); 
			if((playerBounds.getBoundsInParent()).intersects(itemBounds.getBoundsInParent())) {
				return 0;
				//this.playerObject.effect(o.getEffect()); 
			}
		}
		return 1;
	}

}
