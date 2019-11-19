package amuEngine.graphics;

import javafx.scene.image.ImageView;

public class ChangeableSprite implements Sprite{
	Sprite tgt;
	protected ImageView iv;
	public ChangeableSprite(Sprite origin) {
		this.iv = new ImageView();
		this.switchTo(origin);
	}
	public void switchTo(Sprite s) {
		this.tgt = s;
		this.iv.setImage(s.getImageView().getImage());
		this.iv.setViewport(s.getImageView().getViewport());
	}
	
	public ImageView getImageView() {
		return this.iv;
	};
	
	public void setPosition(double x, double y) {
		this.iv.setTranslateX(x);
		this.iv.setTranslateY(y);
	};
	public void nextSubimage() {
		this.tgt.nextSubimage();
		this.iv.setViewport(this.tgt.getImageView().getViewport());
	}

}
