package words;

import java.util.Scanner;

public class WordFromUserGenerator implements WordGenerator {
	
	private String word;

	public String getWord() {
		setWord();
		return word;
	}
	
	private void setWord() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Type a word for your opponent: ");
		this.word = scanner.next();
		System.out.println("Your word has been saved. Thank you!");
		scanner.close();
	}

}
