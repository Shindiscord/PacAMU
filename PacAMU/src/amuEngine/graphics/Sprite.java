package amuEngine.graphics;

import javafx.scene.image.ImageView;

public interface Sprite {
	public ImageView getImageView();
	public void setPosition(double x, double y);
	public void nextSubimage();
}
