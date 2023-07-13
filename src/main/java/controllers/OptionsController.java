package controllers;

import java.util.Scanner;

import views.OptionsView;

public class OptionsController {
	
	private OptionsView optionsView;
	private WordsController wordsController;
	
	public OptionsController(OptionsView optionsView) {
		this.optionsView = optionsView;
		this.wordsController = new WordsController(optionsView);
	}

	public void showOptions() {
		optionsView.printOptions();
		
		Scanner scanner = new Scanner(System.in);
		String optionStr = scanner.nextLine();
		int option = Integer.parseInt(optionStr);
		
		if (option == 1) {
			wordsController.showAllWords();
			optionsView.printLine();
			showOptions();
		} else if (option == 2) {
			optionsView.printSingleWordInput();
			String newWord = scanner.nextLine();
			wordsController.addWordToList(newWord);
			optionsView.printLine();
			showOptions();
		} else if (option == 3) {
			optionsView.printSingleWordInput();
			String wordToDelete = scanner.nextLine();
			wordsController.deleteWordFromList(wordToDelete);
			optionsView.printLine();
			showOptions();
		} else if (option == 4) {
			optionsView.printGoodbye();
		} else {
			optionsView.printInvalidData();
		}
	}

}
