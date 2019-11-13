package amuEngine;

import javafx.scene.input.KeyCode;

public interface KeyboardListerner {
	public void onKeyPressed(KeyCode key);
	public void onKeyReleased(KeyCode key);
}
