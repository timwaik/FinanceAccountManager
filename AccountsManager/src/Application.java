import java.util.ArrayList;
import java.util.Scanner;

public class Application {
	static Scanner input = new Scanner(System.in);
	static int answer;
	
	public static void mainMenu() {
		System.out.println("You are in the main menu, what would you like to do?\n");
		System.out.println("1. Add new account/accounts."
				+ "\n2. Manage accounts."
				+ "\n3. Delete account/accounts."
				+ "\n4. Other");
		System.out.println("Enter either '1', '2', '3', or '4' for corresponding action.");
	}
	public static int query() {
		int userInput = input.nextInt();
		return userInput;
	}
	
	public static void decision() {
		if (answer == 1) {
			Accounts.addAccount();
		}
		else if (answer == 2) {
			Accounts.manageAccount();
		}
		else if (answer == 3) {
			Accounts.deleteAccount();
		}
		else if (answer == 4) {
			System.out.println("Oh no! we have no other options at the moment");
		}
	}

	public static void main(String[] args) {
		
		mainMenu();
		answer = query();
		decision();

	}

}
