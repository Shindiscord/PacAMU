package amuEngine.physics;

import java.util.ArrayList;

public class PhysicsEngine {
	
	ArrayList<PhysicalObject> objectList;
	ArrayList<Collidable> collidableList;
	
	public PhysicsEngine(int refreshRate) {
		this.objectList = new ArrayList<>();
		this.collidableList = new ArrayList<>();
	}

	public void update(long msSinceLastCall) {
		for(PhysicalObject o: objectList) {
			if(o instanceof MovableObject) {
				((MovableObject)o).updatePos();
			}
			this.checkCollision();
		}
	}
	public void addObject(PhysicalObject o) {
		if(o instanceof MovableObject) 
			this.objectList.add(o);
		if(o instanceof Collidable)
			this.collidableList.add((Collidable)o);
			
	}
	
	public void removeObject(PhysicalObject o) {
		if(o instanceof MovableObject) {
			objectList.remove(o);
		}
		if(o instanceof Collidable) {
			collidableList.remove(o);
		}
	}

	public void checkCollision(){
		for(int i = 0; i < collidableList.size()-1; i++) {
			for(int j = 0; j < collidableList.size(); j++) {
				Collidable c1 = collidableList.get(i);
				Collidable c2 = collidableList.get(j);
				
				if(c1.getHitbox().getBoundsInParent().intersects(c2.getHitbox().getBoundsInParent())) {
					c1.onCollide(c2);
					c2.onCollide(c1);
				}

			}
		}
		
	}

}
