package amuEngine;

import amuEngine.graphics.*;

public interface amuGameObject {
	public void update(long msSinceLastCall);
	public Sprite getSprite();
}
