package controllers;

import java.util.Scanner;

import views.OptionsView;

public class OptionsController {
	
	private OptionsView optionsView;
	private WordsController wordsController = new WordsController();
	
	public OptionsController(OptionsView optionsView) {
		this.optionsView = optionsView;
	}

	public void showOptions() {
		optionsView.printOptions();
		
		Scanner scanner = new Scanner(System.in);
		String optionStr = scanner.nextLine();
		int option = Integer.parseInt(optionStr);
		
		if (option == 1) {
			wordsController.showAllWords();
			System.out.println("--------------------------------");
			showOptions();
		} else if (option == 2) {
			System.out.println("Type a single word to add: ");
			String newWord = scanner.nextLine();
			wordsController.addWordToList(newWord);
			System.out.println("--------------------------------");
			showOptions();
		} else if (option == 3) {
			System.out.println("Type a word to delete: ");
			String wordToDelete = scanner.nextLine();
			wordsController.deleteWordFromList(wordToDelete);
			System.out.println("--------------------------------");
			showOptions();
		} else if (option == 4) {
			System.out.println("Bye!");
		} else {
			optionsView.printInvalidData();
		}
	}

}
