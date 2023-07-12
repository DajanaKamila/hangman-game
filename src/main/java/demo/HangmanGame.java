package demo;

import java.util.Scanner;

import controllers.GameController;
import controllers.OptionsController;
import views.GameView;
import views.OptionsView;

public class HangmanGame {
	
	private OptionsView optionsView;
	private GameView gameView;
	private GameController gameController;
	private OptionsController optionsController;
	
	public HangmanGame() {
		gameView = new GameView();
		optionsView = new OptionsView();
		gameController = new GameController(gameView);
		optionsController = new OptionsController(optionsView);
	}

	
	public void play() {
    	gameView.printMenu();
    	   
		Scanner scanner = new Scanner(System.in);
		int gameOrConfig = scanner.nextInt();
		
		if (gameOrConfig == 1) {
			gameController.playGame();
		} else if (gameOrConfig == 2) {
			optionsController.showOptions();
		} else {
			gameView.printInvalidData();
		}
		scanner.close();
    }	


	public static void main(String[] args) {	
        HangmanGame hangmanGame = new HangmanGame();
        hangmanGame.play();
	}
	
	

}
