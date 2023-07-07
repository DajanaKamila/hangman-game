package demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import words.WordGenerator;

public class GameController {
	
	private static final int MAX_ANSWERS = 6; 
	private GameView gameView;
	private WordGenerator wordGenerator;
	private String word; 
	private int incorrectAnswers; 
	private StringBuilder wordOnScreen;
	private List<String> guessedLetters; 
	
	public GameController(GameView gameView, WordGenerator wordGenerator) {
		this.gameView = gameView;
		this.wordGenerator = wordGenerator;
	}

	public void playGame(GameView gameView){
		
		word = wordGenerator.getWord();
		wordOnScreen = new StringBuilder();
		guessedLetters = new ArrayList<String>();
		incorrectAnswers = 0;
		
		for (int i = 0; i < word.length(); i++) {
			wordOnScreen.append("- ");
		}
		
		while(incorrectAnswers < MAX_ANSWERS) {
			gameView.printHangman(incorrectAnswers);
			gameView.printWordToGuess(wordOnScreen);
			
			Scanner scanner = new Scanner(System.in);
			String playerGuess = scanner.next();
			
			if (playerGuess.length() == 1) {
				compareLetterWithWord(playerGuess, word);
			} else if (playerGuess.length() > 1) {
				compareWholeWords(playerGuess, word);
			} else {
				
			}
			
			scanner.close();
			
		}
		
		gameView.printLose();
	}
		
	public void compareWholeWords(String playerGuess, String correctWord) {
		if (playerGuess.equalsIgnoreCase(correctWord)) { 
			gameView.printWinner();
		} else {
			gameView.printIncorrectAnswer();
			incorrectAnswers++;
		}
	}
	
	public void compareLetterWithWord(String playerGuess, String correctWord) {
//		char letter = playerGuess.charAt(0);
		guessedLetters.add(playerGuess);
		if (correctWord.contains(playerGuess)) {
			updateWordOnScreen(wordOnScreen, playerGuess, correctWord);
			if (!wordOnScreen.toString().contains("-")) {
				gameView.printWinner();
				return;
			}
		
		} else {
			incorrectAnswers++;
			gameView.printIncorrectAnswer();
		}
		
		gameView.printGuessedLetters(guessedLetters);
		
	}
	
	public void updateWordOnScreen(StringBuilder wordOnScreen, String playerGuess, String word) {
		char guessedLetter = playerGuess.charAt(0);
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == guessedLetter) {
				wordOnScreen.setCharAt(i, guessedLetter);
			}
		}
	}
	

}
