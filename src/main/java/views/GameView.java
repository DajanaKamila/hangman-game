package views;

import java.util.List;

public class GameView implements View {
	
    public static final String[] HANGMANPICS = new String[]{
            "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "========"
    };
	
	public void printHangman(int incorrectAnswers) {
		System.out.println(HANGMANPICS[incorrectAnswers]);
	}
	
	public void printMenu() {
		System.out.println("Welcome to the Hangman Game! \n"
				+ "1. Start game \n2. Options");
	}
	
	public void printInvalidData() {
		System.out.println("Sorry, invalid data.");
	}
	
	public void printUnimplementedOption() {
		System.out.println("Sorry! This page in unavailable now :(");
	}
	
	public void printWordToGuess(StringBuilder wordToGuess) {
		System.out.println(wordToGuess);
	}
	
	public void printWinner() {
		System.out.println("Congrats! You win!");
	}
	
	public void printIncorrectAnswer() {
		System.out.println("Upsss! Wrong answer. Try again!");
	}
	
	
	public void printGuessedLetters(List<String> guessedLetters) {
		System.out.println("To date you typed those letters: " + guessedLetters.toString().replace(",", ""));
	}
	
	public void printLose() {
		System.out.println("Sorry, you lost! Good luck next time!");
	}
	

	
	
}
