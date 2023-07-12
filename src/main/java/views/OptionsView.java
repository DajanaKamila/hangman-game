package views;

public class OptionsView implements View {

	public void printOptions() {
		System.out.println("What would you like to do? \n1. Show all words to guess \n2. Add word to guess \n3. Delete word to guess \n4. Exit ");
	}
	
	public void printInvalidData() {
		System.out.println("Sorry, invalid data.");
	}
	
}
