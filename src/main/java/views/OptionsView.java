package views;

public class OptionsView implements View {

	public void printOptions() {
		System.out.println("What would you like to do? \n1. Show all words to guess \n2. Add word to guess \n3. Delete word to guess \n4. Exit ");
	}
	
	public void printInvalidData() {
		System.out.println("Sorry, invalid data.");
	}
	
	public void printLine() {
		System.out.println("\n----------------------------------------------\n");
	}
	
	public void printSingleWordInput() { 
		System.out.println("Please type a single word longer than 1 sign");
	}
	
	public void printGoodbye() {
		System.out.println("Goodbye! See you soon!");
	}
	
	public void printSuccessfullyDeleted() {
		System.out.println("The word has been successfully deleted.");
	}
	
	public void printSuccessfullyAdded() {
		System.out.println("Word has been successfully added.");
	}
}
