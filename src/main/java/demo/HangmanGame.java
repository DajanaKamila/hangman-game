package demo;

import java.util.Scanner;

import words.WordFromFileGenerator;
import words.WordGenerator;

public class HangmanGame {
	
	private GameView gameView;
	private WordGenerator wordGenerator;
	private GameController gameController;
	
	public HangmanGame() {
		gameView = new GameView();
		wordGenerator = new WordFromFileGenerator();
		gameController = new GameController(gameView, wordGenerator);
	}

	
	public void play() {
    	gameView.printMenu();
    	   
		Scanner scanner = new Scanner(System.in);
		int gameOrConfig = scanner.nextInt();
		
		if (gameOrConfig == 1) {
			gameController.playGame(gameView);
		} else if (gameOrConfig == 2) {
			gameView.printUnimplementedOption();
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
