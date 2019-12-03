package amuEngine.physics;

import javafx.scene.shape.Rectangle;

public class UncontrollableObject extends MovableObject implements PhysicalObject {
	private double x;
	private double y;
    private boolean foe=true;
	
	private double hspeed;
	private double vspeed;
	
	public void setPos(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public void setHspeed(double val) {
		this.hspeed = val;
	}
	
	public void setVspeed(double val) {
		this.vspeed = val;
	}
	
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}

    public boolean getFoe(){
        return this.foe;
    }

    public Rectangle getBounds(){
        Rectangle r = new Rectangle(this.x,this.y, 25, 25);
        return r;
    }
	
	public void updatePos() {
		this.x += hspeed;
		this.y += vspeed;
	}

    public void setfoe(boolean b){
        this.foe=b;
	}
	
	public void reset_position(){
		
	}
}
