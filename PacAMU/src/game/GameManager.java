package game;

import java.io.IOException;

import amuEngine.GameRoom;
import amuEngine.UI.TextBox;
import game.map.Grid;
import game.map.TileManager;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;

public abstract class GameManager {
	
	private static Stage _window;
	
	private static GameRoom currentRoom;

	private static boolean isFemale;
	
	private static int score = 0;
		
	public static GameRoom getCurrentRoom() {
		return currentRoom;
	}
	
	public static void addScore(int n) {
		score += n;
		System.out.println(score);
	}
	
	public static void setMale() {
		isFemale = false;
	}
	
	public static void setFemale() {
		isFemale = true;
	}
	
	public static boolean getIsFemale() {
		return isFemale;
	}
	
	public static int getScore() {
		return score;
	}
	
	public static void gameOver() {
		currentRoom.stop();
		GameRoom gameOverRoom = new GameRoom(40);
		gameOverRoom.addBackground(new Image("/img/defaite.png"));
		ButtonRestart restart = new ButtonRestart(new Image("/img/buttons/restart.png"));
		restart.addToRoom(gameOverRoom);
		restart.setPos(270, 250);
		restart.getButton().setMaxSize(100, 50);
        ButtonBack back = new ButtonBack(new Image("/img/buttons/back.png"));
        back.addToRoom(gameOverRoom);
        back.setPos(400, 400);
        TextBox tb_score = new TextBox(100,100);
        tb_score.setText("Score : " + score);
        tb_score.setPos(250, 200);
        tb_score.setSize(20);
        gameOverRoom.addText(tb_score);
		gameOverRoom.start(_window,currentRoom.getWidth() , currentRoom.getHeight());
		
		currentRoom = gameOverRoom;
	}
	
	public static void victory() {
		currentRoom.stop();
		GameRoom victoryRoom = new GameRoom(40);
		victoryRoom.addBackground(new Image("/img/victoire.png"));
		ButtonRestart restart = new ButtonRestart(new Image("/img/buttons/restart.png"));
		restart.addToRoom(victoryRoom);
		restart.setPos(270, 250);
		restart.getButton().setMaxSize(100, 50);
	    ButtonBack back = new ButtonBack(new Image("/img/buttons/back.png"));
	    back.addToRoom(victoryRoom);
	    back.setPos(400, 400);
        TextBox tb_score = new TextBox(100,100);
        tb_score.setText("Score : " + score);
        tb_score.setPos(250, 200);
        tb_score.setSize(20);
        victoryRoom.addText(tb_score);
		victoryRoom.start(_window,currentRoom.getWidth() , currentRoom.getHeight());
			
		currentRoom = victoryRoom;
		
	}
	
	public static void chapterSelection() {
		currentRoom.stop();
		GameRoom gameMenu = new GameRoom(40);
		gameMenu.addBackground(new Image("/img/fond.png"));
        ButtonChapter1 chapter1 = new ButtonChapter1(new Image("/img/buttons/chapter1.png"));
        chapter1.setPos(210, 150);
        ButtonChapter1 chapter2 = new ButtonChapter1("/img/buttons/chapter2.png");
        chapter1.setPos(210, 250);
        ButtonChapter1 chapter3 = new ButtonChapter1("/img/buttons/chapter3.png");
        chapter1.setPos(210, 350);

	}
		
	public static void changeRoom(GameRoom newRoom) {
		currentRoom.stop();
		newRoom.start(_window, currentRoom.getWidth(), currentRoom.getHeight());
		currentRoom = newRoom;
	}
	
	public static void init(Stage window) {
		_window = window;
	}
	
	/*
	public int getScore() {
		return this.score;
	}
	
	public void setScoreText(TextBox t) {
		this.scoreText = t;
		t.setText("Score : " + this.getScore());
		
	}*/
	
	public static void startGame() {

		_window.setTitle("test1");
        GameRoom gameMenu = new GameRoom(40);
        ButtonChapterSelection chapterselector = new ButtonChapterSelection(new Image("/img/buttons/selection.png"));
        ButtonInstruction instructions = new ButtonInstruction(new Image("/img/buttons/instructions.png"));
        ButtonQuitGame quitGame = new ButtonQuitGame(new Image("/img/buttons/quitGame.png"));
        ButtonCharacterM characterMale = new ButtonCharacterM(new Image("/img/Player/male_portrait_50_50.png"));
        ButtonCharacterF characterFemale = new ButtonCharacterF(new Image("/img/Player/female_portrait_50_50.png"));
    	gameMenu.addBackground(new Image("/img/fond.png"));
        chapterselector.setPos(150, 150);
        instructions.setPos(180, 250);
        quitGame.setPos(210,350);
        characterMale.setPos(250, 420);
        characterFemale.setPos(330, 420);
        currentRoom = gameMenu;
        chapterselector.addToRoom(gameMenu);
        instructions.addToRoom(gameMenu);
        quitGame.addToRoom(gameMenu);
        characterMale.addToRoom(gameMenu);
        characterFemale.addToRoom(gameMenu);
        gameMenu.start(_window, 640, 480);
        //room.start(_window, grid.getLargeur()*32, grid.getHauteur()*32);
	}
	
	public static void quitGame() {
		_window.close();
	}
}
