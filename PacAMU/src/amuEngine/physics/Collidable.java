package amuEngine.physics;

import javafx.scene.shape.Rectangle;

public interface Collidable extends PhysicalObject{
	public Rectangle getHitbox();
	public void onCollide(Collidable c2);
}
