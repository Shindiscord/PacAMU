package amuEngine.UI;
import java.util.ArrayList;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import amuEngine.KeyboardListener;

public class KeyboardManager {
	ArrayList<KeyboardListener> listeners;
	
	public KeyboardManager() {
		this.listeners = new ArrayList<>();
	}
	
	public void start(Stage scene) {
		scene.addEventHandler(KeyEvent.KEY_PRESSED, (key) -> {
			for(KeyboardListener l:listeners) {
				l.onKeyPressed(key.getCode());
			}
		});
		scene.addEventHandler(KeyEvent.KEY_RELEASED, (key) -> {
			for(KeyboardListener l:listeners) {
				l.onKeyReleased(key.getCode());
			}
		});
	}
	
	public void addListener(KeyboardListener o) {
		this.listeners.add(o);
	}
	public void removeListener(KeyboardListener o) {
		this.listeners.remove(o);
	}
	public void clear() {
		listeners = new ArrayList<>();
	}
	
	
}
