package game;

import amuEngine.physics.PhysicalObject;
import game.map.Grid;
import javafx.scene.input.KeyCode;

public class BoarLvl2 extends Boar{
	
	private PhysicalObject target;
	
	protected KeyCode chooseDirection(double currentGridX, double currentGridY) {
		if(target == null) {
			return KeyCode.UP;
		}
		
		double dx = currentGridX*32 - target.getX();
		double dy = currentGridY*32 - target.getY();
		
		KeyCode[] direction = new KeyCode[4];
		
		//Order direction from furthest to nearest
		if(Math.abs(dx) > Math.abs(dy)) {
			if(dx > 0) {
				direction[0] = KeyCode.LEFT;
				direction[3] = KeyCode.RIGHT;
			}else{
				direction[0] = KeyCode.RIGHT;
				direction[3] = KeyCode.LEFT;
			}
			if(dy > 0) {
				direction[1] = KeyCode.UP;
				direction[2] = KeyCode.DOWN;
			}else {
				direction[2] = KeyCode.UP;
				direction[1] = KeyCode.DOWN;
			}
		}else {
			if(dx > 0) {
				direction[1] = KeyCode.LEFT;
				direction[2] = KeyCode.RIGHT;
			}else{
				direction[1] = KeyCode.RIGHT;
				direction[2] = KeyCode.LEFT;
			}
			if(dy > 0) {
				direction[0] = KeyCode.UP;
				direction[3] = KeyCode.DOWN;
			}else {
				direction[3] = KeyCode.UP;
				direction[0] = KeyCode.DOWN;
			}
		}
		
		for(int i = 0; i < 4; i++) {
			if(!map.nextIsAWall((int)currentGridX, (int)currentGridY, direction[i])) {
				return direction[i];
			}
		}
		return KeyCode.RIGHT;
	
	}
	
	public BoarLvl2 (double x, double y,int bordureH, int bordureV,Grid map ,int iteration, PhysicalObject target) {
		super(x, y, bordureH, bordureV, map, iteration);
		this.target = target;
	}

}
