package amuEngine.physics;

public class MovableObject implements PhysicalObject {
	private double x;
	private double y;
	
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
	
	public void updatePos() {
		this.x += hspeed;
		this.y += vspeed;
	}
}
