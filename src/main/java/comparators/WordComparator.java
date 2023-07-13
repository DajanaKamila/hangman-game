package comparators;

import java.util.ArrayList;
import java.util.List;

import views.GameView;

public class WordComparator {
	
	private WordUpdater wordUpdater;
	private GameView gameView;
	private List<String> guessedLetters = new ArrayList<String>(); 
	
	public WordComparator(GameView gameView) {
		this.gameView = gameView;
		wordUpdater = new WordUpdater();
	} 
	
	public int compareWholeWords(String playerGuess, String correctWord, int incorrectAnswers, StringBuilder wordOnScreen) {
		if (playerGuess.equalsIgnoreCase(correctWord)) { 
			wordUpdater.updateWordOnScreenByWord(wordOnScreen, playerGuess);
		} else {
			gameView.printIncorrectAnswer();
			incorrectAnswers++;
		}
		
		return incorrectAnswers;
	}
	
	public int compareLetterWithWord(String playerGuess, String correctWord, int incorrectAnswers, StringBuilder wordOnScreen) {
		guessedLetters.add(playerGuess);
		if (correctWord.contains(playerGuess)) {
			wordUpdater.updateWordOnScreenByLetter(wordOnScreen, playerGuess, correctWord);
		} else {
			incorrectAnswers++;
			gameView.printIncorrectAnswer();
		}
		
		gameView.printGuessedLetters(guessedLetters);
		return incorrectAnswers;
		
	}
	

}
