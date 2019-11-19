package amuEngine.physics;

import java.util.ArrayList;

public class PhysicsEngine {
	
	ArrayList<PhysicalObject> objectList;
	
	public PhysicsEngine(int refreshRate) {
		this.objectList = new ArrayList<>();
	}
	public void update(long msSinceLastCall) {
		for(PhysicalObject o: objectList) {
			if(o instanceof MovableObject) {
				((MovableObject)o).updatePos();
			}
		}
	}
	public void addObject(PhysicalObject o) {
		this.objectList.add(o);
	}
}
