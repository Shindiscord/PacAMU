package game;

import java.util.Random;

import amuEngine.graphics.ChangeableSprite;
import amuEngine.graphics.SingleSprite;
import game.map.Grid;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;

public class BoarLvl1 extends Boar {
	protected KeyCode chooseDirection(double currentGridX, double currentGridY) {
		Random r = new Random();
		if(!this.map.nextIsAWall((int) currentGridX, (int)currentGridY, this.currentDirection)) {
			int val = r.nextInt(100);
			if(val < 85) {
				return this.currentDirection;
			}	
		}
		KeyCode[] direction = new KeyCode[4];
		direction[0] = KeyCode.UP;
		direction[1] = KeyCode.LEFT;
		direction[2] = KeyCode.RIGHT;
		direction[3] = KeyCode.DOWN;
		
		for(int i = 0; i<3; i++) {
			if(direction[i] == this.currentDirection) {
				KeyCode tmp = direction[3];
				direction[3] = direction[i];
				direction[i] = tmp;
				break;
			}
		}
		
		int begin = r.nextInt(3);
		int i = begin;
		
		while(this.map.nextIsAWall((int)currentGridX,(int) currentGridY, direction[i])) {
			i = (i+1)%3;
			if(i == begin)
				return this.currentDirection;
		}
		return direction[i];
		
		/*boolean pathAbove = !this.map.nextIsAWall((int) currentGridX, (int)currentGridY, KeyCode.UP);
		boolean pathBelow = !this.map.nextIsAWall((int) currentGridX, (int)currentGridY, KeyCode.DOWN);
		boolean pathLeft = !this.map.nextIsAWall((int) currentGridX, (int)currentGridY, KeyCode.LEFT);
		boolean pathRight = !this.map.nextIsAWall((int) currentGridX, (int)currentGridY, KeyCode.RIGHT);
		int dirAvailable = 0;
		if(pathAbove) dirAvailable++;
		if(pathBelow) dirAvailable++;
		if(pathLeft) dirAvailable++;
		if(pathRight) dirAvailable++;
		Random r = new Random();
		if(!this.map.nextIsAWall((int) currentGridX, (int)currentGridY, this.currentDirection)) {
			int val = r.nextInt(100);
			if(dirAvailable<=2)
				return this.currentDirection;
			else if(val <= 75)
				return this.currentDirection;
			else {
				if(dirAvailable == 3) {
					if(this.currentDirection == KeyCode.UP || this.currentDirection == KeyCode.DOWN) {
						if(pathLeft) this.currentDirection = KeyCode.LEFT;
						else this.currentDirection = KeyCode.RIGHT;
					}
					else {
						if(pathAbove) this.currentDirection = KeyCode.UP;
						else this.currentDirection = KeyCode.DOWN;
					}
				}
				if(dirAvailable == 4) {
					if(this.currentDirection == KeyCode.UP || this.currentDirection == KeyCode.DOWN) {
						int val2 = r.nextInt(50);
						if(val2 < 50)
					}
				}
			}
				

		}*/

	}
	
	public BoarLvl1 (double x, double y,int bordureH, int bordureV,Grid map ,int iteration) {
		super(x, y, bordureH, bordureV, map, iteration);
		this.leftSprite = new SingleSprite(
				new Image("/img/Boar/boar_brown_l_46_30_5.png")
				,46, 30, 5);
		this.upSprite = new SingleSprite(
				new Image("/img/Boar/boar_brown_u_32_44_5.png")
				,32, 44, 5);
		
		this.rightSprite = new SingleSprite(
				new Image("/img/Boar/boar_brown_r_46_30_5.png")
				,46, 30, 5);
		this.downSprite = new SingleSprite(
				new Image("/img/Boar/boar_brown_d_32_38_7.png")
				,32, 36, 7);
		this.s = new ChangeableSprite(upSprite);
		s.setPosition(x, y);
		this.setVspeed(0);
		this.setHspeed(0);
		this.s.switchTo(upSprite);
		this.currentDirection = KeyCode.UP;
	}
}
