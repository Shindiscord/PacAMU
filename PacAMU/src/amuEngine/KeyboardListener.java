package amuEngine;

import javafx.scene.input.KeyCode;

public interface KeyboardListener {
	public void onKeyPressed(KeyCode key);
	public void onKeyReleased(KeyCode key);
}
