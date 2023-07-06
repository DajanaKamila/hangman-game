package demo;

import java.util.Scanner;

public class MainScreen {
	
	GameController gameController = new GameController();

    
    public void startGame() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to the Hangman Gamee! \n"
				+ "1. Start game \n2. Options");
		int gameOrConfig = scanner.nextInt();
		
		if (gameOrConfig == 1) {
			askForNumberOfPlayers();
		} else if (gameOrConfig == 2) {
			System.out.println("Sorry! This page in unavailable now :(");
		} else {
			System.out.println("Please, type valid number. ");
		}
		scanner.close();
    }
    
	public void askForNumberOfPlayers() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please choose the number of players. \n1. One player \n2. Two players");
		int numberOfPlayers = scanner.nextInt();
		
		if (numberOfPlayers == 1) {
			gameController.singleGame();
		} else if (numberOfPlayers == 2) {
			System.out.println("This option in unavailable now");
		} else {
			System.out.println("Please type a valid number.");
		}
		scanner.close();
	}
	
	
	

}
