package compare;

import java.util.Collection;
import java.util.HashMap;

public class WordComparator {
	
	private HashMap<Integer, String> mapOfLetters;
	private Collection<String> letters;
	
	public int[] compare(String letterOrWord, String secretWord) {
		
		changeWordToMap(secretWord);
		int[] idx = null; 
		letters = mapOfLetters.values();
		
		if (letterOrWord.length() == 1) {
			
			
			
		} else if (letterOrWord.length() > 1) {
			if (letterOrWord.equals(secretWord)) {
				idx[0] = -2;
			}
		} else {
			System.err.println("Invalid input");
		}	
		return idx;
	}
	
	private void changeWordToMap(String word) {
		char[] letters = word.toCharArray();
		mapOfLetters = new HashMap<Integer, String>();
		for (int i = 0; i < letters.length; i++) {
			String substring = word.substring(i, i+1);
			mapOfLetters.put(i, substring);
		}
	}
	
	

}
