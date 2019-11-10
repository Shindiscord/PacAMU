package amuEngine.graphics;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Rectangle2D;

public class Sprite {
	Image spriteSheet;
	Rectangle2D[] subImages;
	int currentSubImage;
	ImageView iv;
	
	public Sprite(Image img, int subWidth, int subHeight, int nSub) {
		this.spriteSheet = img;
		if(nSub * subWidth <= this.spriteSheet.getWidth()) {
			this.subImages = new Rectangle2D[nSub];
			for (int i = 0; i<nSub; i++) {
				this.subImages[i] = new Rectangle2D(
						i*subWidth
						, 0
						, subWidth
						, subHeight
						);
			}
			this.currentSubImage = -1;
			this.iv = new ImageView(this.spriteSheet);
			this.iv.setViewport(subImages[0]);
		}
	}
	
	public void nextSubimage() {
		currentSubImage = (currentSubImage+1)%subImages.length;
		this.iv.setViewport(subImages[currentSubImage]);
	}
	
	
	public ImageView getImageView() {
		return this.iv;
	}
	
	public void setPosition(double x, double y) {
		this.iv.setTranslateX(x);
		this.iv.setTranslateY(y);
	}
	
}
