package amuEngine.UI;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import amuEngine.GameRoom;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Button;
public abstract class Clickable {
	
	protected Button button;
	String name;
	Image img;
	
	
	public abstract void onClick();
	
	public Button getButton() {
		return this.button;
	}
	
	public void addToRoom(GameRoom room) {
		//this.button.setMaxSize(220, 50);
		room.addButton(this.button);
	}
	
	public Clickable(String name) {
		this.button = new Button(name);
		this.button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onClick();
            }
        });
	}
	
	public Clickable(Image img) {
		this.img = img;
		this.button = new Button();
		this.button.setGraphic(new ImageView(img));
		this.button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                onClick();
            }
        });
	}
	
	public void setPos(double x, double y) {
		this.button.setTranslateX(x);
		this.button.setTranslateY(y);
	}

}
