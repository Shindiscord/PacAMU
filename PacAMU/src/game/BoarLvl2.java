package game;

import amuEngine.graphics.ChangeableSprite;
import amuEngine.graphics.SingleSprite;
import amuEngine.physics.PhysicalObject;
import game.map.Grid;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class BoarLvl2 extends Boar{
	
<<<<<<< HEAD
	private Student target;
	
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
		if ( target.getCoffeePowaState() ) {
			for(int i = 3; i >= 0; i--) {
				if(!map.nextIsAWall((int)currentGridX, (int)currentGridY, direction[i])) {
					return direction[i];
				}
			}
		}
		
		else {
			for(int i = 0; i < 4; i++) {
				if(!map.nextIsAWall((int)currentGridX, (int)currentGridY, direction[i])) {
					return direction[i];
				}
			}
		}
		return KeyCode.RIGHT;
	
	}
	
	public BoarLvl2 (double x, double y,int bordureH, int bordureV,Grid map ,int iteration, Student target) {
=======
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
>>>>>>> refs/remotes/origin/Alix
		super(x, y, bordureH, bordureV, map, iteration);
		this.target = target;
		this.leftSprite = new SingleSprite(
				new Image("/img/Boar/boar_red_l_46_30_5.png")
				,46, 30, 5);
		this.upSprite = new SingleSprite(
				new Image("/img/Boar/boar_red_u_32_44_5.png")
				,32, 44, 5);
		
		this.rightSprite = new SingleSprite(
				new Image("/img/Boar/boar_red_r_46_30_5.png")
				,46, 30, 5);
		this.downSprite = new SingleSprite(
				new Image("/img/Boar/boar_red_d_32_38_7.png")
				,32, 36, 7);
		this.s = new ChangeableSprite(upSprite);
		s.setPosition(x, y);
		this.setVspeed(4);
		this.setHspeed(0);
		this.s.switchTo(upSprite);
		this.currentDirection = KeyCode.UP;
	}

}
