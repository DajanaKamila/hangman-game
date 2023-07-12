package wordgenerators;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class WordFromFileGenerator implements WordGenerator {
	
	private static final String FILE_PATH = "src/main/resources/words.txt";
	private String word;
	private List<String> words = new ArrayList<String>();;
	private Random random;
	
	public WordFromFileGenerator() {
		random = new Random();
	}
	
	private void readWordsFromFile() {
		String line;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
			while ((line = reader.readLine()) != null) {
				words.add(line.trim());
			}
			reader.close();
		} catch (FileNotFoundException e) {
			System.err.println("Could not find the file. " + e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public String getWord() {
		readWordsFromFile();
		if (words.isEmpty()) {
			return null;
		}
		
		if (word == null) {
			int randomNumber = random.nextInt(words.size());
			word = words.get(randomNumber);
		}
		
		return word;
	}
	
}
