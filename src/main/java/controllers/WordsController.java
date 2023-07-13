package controllers;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import views.OptionsView;

public class WordsController {
	
	private static final String FILE_PATH = "src/main/resources/words.txt";
	private Scanner scanner = new Scanner(System.in);
	private OptionsView optionsView;
	
	public WordsController(OptionsView optionsView) {
		this.optionsView = optionsView;
	}

	public void showAllWords() {
		List<String> words = readAllWords();
		for (String word : words) {
			System.out.println(word);
		}
	}
	
	public void addWordToList(String newWord) {
		String[] words = newWord.split("\\s+");
		
		if (words.length == 1 && newWord.length() > 1) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
				writer.write(newWord);
				writer.newLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			optionsView.printInvalidData();
			optionsView.printSingleWordInput();
		}
	}
	
	public void deleteWordFromList(String wordToDelete) {
		List<String> words = readAllWords();
		
		if (words.contains(wordToDelete)) {
			words.remove(wordToDelete);
			writeAllWordsToFile(words);
			optionsView.printSuccessfullyDeleted();
		} else {
			optionsView.printInvalidData();
			optionsView.printSingleWordInput();
		}
	}
	
	private List<String> readAllWords() {
		List<String> words = new ArrayList<>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
			String line;
			while ((line = reader.readLine()) != null) {
				words.add(line);
			} 
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return words;
	}
	
	private void writeAllWordsToFile(List<String> words) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, false));
			for (String word : words) {
				addWordToList(word);
			}
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
}
