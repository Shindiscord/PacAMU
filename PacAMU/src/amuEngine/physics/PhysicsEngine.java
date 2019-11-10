package amuEngine.physics;

import java.util.ArrayList;

public class PhysicsEngine {
	private long period;
	private long timeSinceLastUpdate;
	ArrayList<PhysicalObject> objectList;
	
	public PhysicsEngine(int refreshRate) {
		this.period = 1000/refreshRate;
		this.timeSinceLastUpdate = 0;
		this.objectList = new ArrayList<>();
	}
	public void update(long msSinceLastCall) {
		timeSinceLastUpdate += msSinceLastCall;
		if(timeSinceLastUpdate >= period) {
			for(PhysicalObject o: objectList) {
				if(o instanceof MovableObject) {
					((MovableObject)o).updatePos();
				}
			}
			timeSinceLastUpdate = timeSinceLastUpdate - period;
		}
	}
	public void addObject(PhysicalObject o) {
		this.objectList.add(o);
	}
}
