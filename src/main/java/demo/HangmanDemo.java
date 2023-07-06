package demo;

import words.WordFromFileGenerator;
import words.WordFromUserGenerator;
import words.WordGenerator;


public class HangmanDemo {
	
	public static void main(String[] args) {
		WordGenerator wordFileGenerator = new WordFromFileGenerator();
		String wordFile = wordFileGenerator.getWord();
		System.out.println(wordFile);
		
		
		System.out.println("----------------------------------------");
		WordGenerator wordUserGenerator = new WordFromUserGenerator();
		String wordUser = wordUserGenerator.getWord();
		System.out.println(wordUser);
	}
	


}
