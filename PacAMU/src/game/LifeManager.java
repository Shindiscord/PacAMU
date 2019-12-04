package game;

public class LifeManager {
	
	private int nbLifes;

	
	public LifeManager(int nbLifes) {
		nbLifes = 3;
	}
	
	public int getLifes() {
		return this.nbLifes;
	}
	
	public void setLifes(int nbLifes) {
		this.nbLifes = nbLifes;
	}
	
	public void incrementLifes() {
		nbLifes ++;
	}
	
	public void decrementLifes() {
		nbLifes --;
	}
}
