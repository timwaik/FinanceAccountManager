import java.util.ArrayList;
import java.util.Scanner;

public class Application {
	static Scanner input = new Scanner(System.in);
	
	private static void mainMenuIntro() {
		System.out.println("Welcome to the account manager!");
	}
	
	private static int mainMenu() {
		int answer;
		System.out.println("You are in the main menu, what would you like to do?\n");
		System.out.println("1. Add new account/accounts."
				+ "\n2. Manage accounts."
				+ "\n3. Delete account/accounts."
				+ "\n4. Other."
				+ "\n5. Quit program.");
		System.out.println("Enter either '1', '2', '3', '4' or '5' for corresponding action.");
		answer = query();
		return answer;
	}
	private static int query() {
		int userInput = input.nextInt();
		input.nextLine();
		return userInput;
	}
	
	private static int decision(int answer) {
		int rtnMM = 0;
		if (answer == 1) {
			Accounts.addAccount();
			rtnMM = 1;
		}
		else if (answer == 2) {
			Accounts.manageAccount();
			rtnMM = 1;
		}
		else if (answer == 3) {
			Accounts.deleteAccount();
			rtnMM = 1;
		}
		else if (answer == 4) {
			Accounts.other();
			rtnMM = 1;
		}
		else if (answer == 5) {
			rtnMM = quitConfirmation();
		}
		else {
			System.out.println("That was an invalid command. You can only enter a number "
					+ "between 1-->5. Try again.\n");
			rtnMM = 1;
		}
		return rtnMM;
	}

	private static int quitConfirmation() {
		String confirmation;
		int indicator = 0;
		System.out.println("Are you sure you want to quit?");
		do {
			System.out.println("Type [Yes] or [No].");
			confirmation = input.nextLine();
			if (confirmation.equalsIgnoreCase("Yes")) {
				System.out.println("Goodbye for now! Hope you enjoyed this.");
				indicator = 0;
			}
			else if (confirmation.equalsIgnoreCase("No")) {
				System.out.println("Returning to the main menu then.\n");
				indicator = 1;
			}
			else {
				System.out.println("That was an invalid response, type either 'Yes' or 'No'.");
				indicator = 2;
			}
		} while (indicator == 2);
		return indicator;
	}
	
	public static void main(String[] args) {
		int rtnMM;
		int answer;
		mainMenuIntro();
		answer = mainMenu();
		rtnMM = decision(answer);
		while (rtnMM == 1) {
			answer = mainMenu();
			rtnMM = decision(answer);
		}
	}
}
