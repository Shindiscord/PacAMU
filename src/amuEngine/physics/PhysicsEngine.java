package amuEngine.physics;

import java.util.ArrayList;
import javafx.scene.shape.Rectangle;

public class PhysicsEngine {
	
	ArrayList<PhysicalObject> objectList;
	ArrayList<PhysicalObject> collectibleList;
	MovableObject playerObject;
	
	public PhysicsEngine(final int refreshRate) {
		this.objectList = new ArrayList<>();
		this.collectibleList = new ArrayList<>();
	}

	public void update(final long msSinceLastCall) {
		for (final PhysicalObject o : objectList) {
			if (o instanceof MovableObject) {
				((MovableObject) o).updatePos();
			}
			this.checkEntityCollisions();
			this.checkCollection();
		}
	}

	public void addObject(final PhysicalObject o) {
		if (this.objectList.isEmpty()) {
			this.playerObject = (MovableObject) o;
		}
		if (o instanceof MovableObject)
			this.objectList.add(o);
		else if (o instanceof CollectibleObject)
			this.collectibleList.add(o);
	}

	public int checkEntityCollisions() {
		final Rectangle playerBounds = this.playerObject.getBounds(); // Récupère les limites du sprite du joueur
		int death = 0;
		for (final PhysicalObject o : objectList) {
			if (o instanceof UncontrollableObject) { // Pour chaque ennemi
				final Rectangle entityBounds = o.getBounds(); // Recupere les limites du sprite
				if ((playerBounds.getBoundsInParent()).intersects(entityBounds.getBoundsInParent())) {
					if (((UncontrollableObject) o).getFoe()) {
						this.playerObject.death();
						death = 1;
					} else {
						final int addScore = this.playerObject.kill(); // TODO : ajouter addScore au score du joueur
						((UncontrollableObject) o).reset_position();

						System.out.println("boop PAS ENNEMI");
					}
					return 0;
				}
			}
		}
		return 1;
	}

	public int checkCollection() {
		final Rectangle playerBounds = this.playerObject.getBounds();
		for (final PhysicalObject o : collectibleList) {
			final Rectangle itemBounds = o.getBounds();
			if((playerBounds.getBoundsInParent()).intersects(itemBounds.getBoundsInParent())) {
				return 0;
				//this.playerObject.effect(o.getEffect()); 
			}
		}
		return 1;
	}

	public int get_current_player_lives(){
		return this.playerObject.get_lives();
	}

}
