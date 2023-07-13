package controllers;

import java.util.Scanner;

import comparators.WordComparator;
import views.GameView;
import wordgenerators.WordFromFileGenerator;
import wordgenerators.WordGenerator;

public class GameController {
	
	private GameView gameView;
	private WordGenerator wordGenerator;
	private WordComparator wordComparator;
	
	private static final int MAX_ANSWERS = 6; 
	private int incorrectAnswers; 
	private String wordToGuess; 
	private StringBuilder wordOnScreen;

	
	public GameController(GameView gameView) {
		this.gameView = gameView;
		this.wordGenerator = new WordFromFileGenerator();
		this.wordComparator = new WordComparator(gameView);
	}

	public void playGame(){
		
		wordToGuess = wordGenerator.getWord();
		wordOnScreen = new StringBuilder();
		incorrectAnswers = 0;
		
		for (int i = 0; i < wordToGuess.length(); i++) {
			wordOnScreen.append("-");
		}
		
		Scanner scanner = new Scanner(System.in);
		
		while(incorrectAnswers < MAX_ANSWERS) {
			
			gameView.printHangman(incorrectAnswers);
			gameView.printWordToGuess(wordOnScreen);
			
			String playerGuess = scanner.next();
			
			if (playerGuess.length() == 1) {
				incorrectAnswers = wordComparator.compareLetterWithWord(playerGuess, wordToGuess, incorrectAnswers, wordOnScreen);
			} else if (playerGuess.length() > 1) {
				incorrectAnswers = wordComparator.compareWholeWords(playerGuess, wordToGuess, incorrectAnswers, wordOnScreen);
			} else {
				gameView.printInvalidData();
			}
			
			if (!wordOnScreen.toString().contains("-")) {
				gameView.printWinner();
				break;
			}
		}
		
		if (incorrectAnswers >= MAX_ANSWERS) {
			gameView.printHangman(incorrectAnswers);
			gameView.printLose();
		}
		
		scanner.close();
	}
		
}
