import java.util.ArrayList;
import java.util.Scanner;

public class Accounts {
	ArrayList<Accounts> acc = new ArrayList<Accounts>();
	static Scanner input = new Scanner(System.in);
	
	public static void addAccount() {
		int accountNumberAdd;
		System.out.println("How many accounts would you like to add?");
		System.out.print("Number of accounts: ");
		accountNumberAdd = input.nextInt();
	}
	public static void deleteAccount() {
		String accountDeleteName;
		System.out.println("Which account would you like to delete?");
		System.out.print("Name of account: ");
		accountDeleteName = input.nextLine();
	}
	public static void manageAccount() {
		int answer;
		int goBack = 0;
		System.out.println("What would you like to manage?\n");
		System.out.println("1. Add account money.\n"
				+ "2. Remove account money.\n"
				+ "3. Transfer money.\n"
				+ "4. Go back.");
		System.out.println("Enter either '1', '2', '3' or '4' for corresponding action.");
		System.out.print("Input: ");
		answer = input.nextInt();
		
		if (answer == 1) {
			addMoney();
		}
		else if (answer == 2) {
			removeMoney();
		}
		else if (answer == 3) {
			transferMoney();
		}
		else if (answer == 4) {
			goBack = 1;
		}
	}
	private static void transferMoney() {
		// TODO Auto-generated method stub
		
	}
	private static void removeMoney() {
		String accountHolder;
		int removeMoney;
		System.out.println("Choose account to remove money from:");
		System.out.print("Enter name of accountholder: ");
		accountHolder = input.nextLine();
		System.out.println("How much do you want to remove?");
		System.out.println("Enter amount to remove: ");
		removeMoney = input.nextInt();
		// add code to remove money from this account
	}
	private static void addMoney() {
		String accountHolder;
		int addMoney;
		System.out.println("Choose account to add money to:");
		System.out.print("Enter name of accountholder: ");
		accountHolder = input.nextLine();
		System.out.println("How much do you want to add?");
		System.out.println("Enter amount to add: ");
		addMoney = input.nextInt();
		// add code to add money to this account
	}
}
