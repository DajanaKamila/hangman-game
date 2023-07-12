package comparators;

public class WordUpdater {
	
	public void updateWordOnScreenByLetter(StringBuilder wordOnScreen, String playerGuess, String wordToGuess) {
		char guessedLetter = playerGuess.charAt(0);
		for (int i = 0; i < wordToGuess.length(); i++) {
			if (wordToGuess.charAt(i) == guessedLetter) {
				wordOnScreen.setCharAt(i, guessedLetter);
			}
		}
	}
	
	public void updateWordOnScreenByWord(StringBuilder wordOnScreen, String playerGuess) {
		wordOnScreen.replace(0, wordOnScreen.length(), playerGuess);
	}

}
