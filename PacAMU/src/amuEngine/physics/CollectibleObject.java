package amuEngine.physics;

import javafx.scene.shape.Rectangle;

public class CollectibleObject implements PhysicalObject {
	private  double x;
	private  double y;
    private  int size;
    private  int effectId;
	
	public void setObj(double x, double y, int size, int effectId) {
		this.x = x;
		this.y = y;
        this.size=size;
        this.effectId=effectId;
	}

	public Rectangle getBounds(){
		Rectangle r = new Rectangle(this.x,this.y, this.size, this.size);
		return r;
    }

    public double getX(){ return this.x;};
	public double getY(){ return this.y;};

    public int getEffect(){
        return this.effectId;
    }

}