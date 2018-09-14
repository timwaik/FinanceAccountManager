import java.util.ArrayList;
import java.util.Scanner;

public class Accounts {
	static ArrayList<Accounts> acc = new ArrayList<Accounts>();
	static Scanner input = new Scanner(System.in);
	private static int numberOfAccounts = 0;
	private static int currentAccountNumber = 0;
	private String name;
	private int accountNumber;
	private int bankBalance;
	
	
	//CONSTRUCTOR
	public Accounts(String name, int accountNumber, int initialBankBalance) {
		this.name = name;
		this.accountNumber = accountNumber;
		this.bankBalance = initialBankBalance;
		numberOfAccounts++;
	}
	//END
	
	
	private static int getNumberofAccounts() {
		return numberOfAccounts;
	}
	
	private static void reduceNumberOfAccounts() {
		numberOfAccounts--;
	}
	
	public static void retreiveAccountDetails(int accountNumber) {
		
		System.out.println("Name of Accountholder: ");
	}
	public String toString() {
		return "Name: " + this.name + "\nBank balance: " + this.bankBalance;
	}
	
	//ADD ACCOUNT METHODS
	public static void addAccount() {
		int accountNumberAdd;
		System.out.println("How many accounts would you like to add?");
		System.out.print("Number of accounts: ");
		accountNumberAdd = input.nextInt();
		input.nextLine();
		addAccountDetails(accountNumberAdd);
		System.out.println("All new accounts added!");
		System.out.println("Going back to main menu...\n");
	}
	private static void addAccountDetails(int accountNumberAdd) {
		for (int i = 0; i < accountNumberAdd; i++) {
			System.out.println("Type in the name of the new account holder. [" + i + "]");
			System.out.print("Name: ");
			String newName = input.nextLine();
			System.out.println("Type in the balance of this account.");
			System.out.print("Balance: ");
			int newBankBalance = input.nextInt();
			input.nextLine();
			System.out.println();
			currentAccountNumber++;
			acc.add(new Accounts(newName, currentAccountNumber, newBankBalance));
		}
	}
	//
	
	//DELETE ACCOUNT METHODS
	public static void deleteAccount() {
		String IDOrName;
		String accountDeleteName;
		int accountDeleteID;
		IDOrName = deleteAccountIDOrName();
		
		switch(IDOrName.toUpperCase()) {
		
		case "ID":
			System.out.println("Which account would you like to delete?");
			System.out.print("ID number: ");
			accountDeleteID = input.nextInt();
			input.nextLine();
			acc.remove(accountDeleteID);
			reduceNumberOfAccounts();
			System.out.println("Account deleted! Heading back to the main menu..\n");
			break;
			
		case "NAME":
			System.out.println("Which account would you like to delete?");
			System.out.print("Name of account: ");
			accountDeleteName = input.nextLine();
			//acc.remove;
			//This does not work yet do not try
			break;
		}
	}
	
	private static String deleteAccountIDOrName() {
		String IDOrName;
		int doWhileLoop = 0;
		do {
			System.out.println("Find account to delete by: \n-Account ID? \t -Accountholder name?");
			System.out.println("Type in either [ID] or [Name].");
			IDOrName = input.nextLine();
			if (IDOrName.equalsIgnoreCase("ID")) {
				doWhileLoop = 1;
			}
			else if (IDOrName.equalsIgnoreCase("Name")) {
				doWhileLoop = 1;
			}
			else {
				System.out.println("Invalid input. Type again please.\n");
				doWhileLoop = 0;
			}
		} while (doWhileLoop == 0);
		return IDOrName;		
	}
	//
	
	//MANAGE ACOCUNT METHODS
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
		int accountFrom;
		int accountTo;
		int transferAmount;
		System.out.println("Which account to transfer money out of?");
		System.out.print("Account (From): ");
		accountFrom = input.nextInt();
		input.nextLine();
		System.out.println("Which account to transfer money to?");
		System.out.print("Account (To): ");
		accountTo = input.nextInt();
		input.nextLine();
		System.out.println("How much money do you want to transfer?");
		transferAmount = input.nextInt();
		input.nextLine();
		System.out.println("Transferring money...");
		acc.get(accountTo).addMoneyAccount(transferAmount);
		acc.get(accountFrom).removeMoneyAccount(transferAmount);
		System.out.println("Transfer Complete!");
	}
	private static void removeMoney() {
		String accountHolder;
		int accountID;
		int removeMoney;
		System.out.println("Choose account to remove money from:");
		System.out.print("Enter ID of account: ");
		//System.out.print("Enter name of accountholder: ");
		//accountHolder = input.nextLine();
		accountID = input.nextInt();
		input.nextLine();
		System.out.println("How much do you want to remove?");
		System.out.println("Enter amount to remove: ");
		removeMoney = input.nextInt();
		input.nextLine();
		System.out.println("Removing Money...");
		acc.get(accountID).removeMoneyAccount(removeMoney);
		System.out.println("Money successfully removed!");
		// add code to remove money from this account
	}
	
	private void removeMoneyAccount(int removeMoney) {
		this.bankBalance -= removeMoney;
	}


	private static void addMoney() {
		String accountHolder;
		int accountID;
		int addMoney;
		System.out.println("Choose account to add money to:");
		System.out.print("Enter ID of account: ");
		//System.out.print("Enter name of accountholder: ");
		//accountHolder = input.nextLine();
		accountID = input.nextInt();
		input.nextLine();
		System.out.println("How much do you want to add?");
		System.out.println("Enter amount to add: ");
		addMoney = input.nextInt();
		input.nextLine();
		System.out.println("Adding Money...");
		acc.get(accountID).addMoneyAccount(addMoney);
		System.out.println("Money successfully added!");
		// add code to add money to this account
	}
	
	
	private void addMoneyAccount(int addMoney) {
		this.bankBalance += addMoney;
	}
	//

	public static void other() {
		int answer;
		do {
			System.out.println("You are in the 'other' menu. What would you like to do?");
			System.out.println("1. Display total number of accounts.\n"
					+ "2. Display next account number.\n"
					+ "3. View account details.\n"
					+ "4. Go back.");
			System.out.println("Enter either '1' , '2' or '3' for corresponding action.");
			answer = input.nextInt();
			input.nextLine();
			
			if (answer == 1) {
				int numberOfAccounts = getNumberofAccounts();
				System.out.println("The total number of accounts active are " + numberOfAccounts);
			}
			else if (answer == 2) {
				int nextAccountNumber = getNumberofAccounts() + 1;
				System.out.println("The next account number is: " + nextAccountNumber);
			}
			else if (answer == 3) {
				int accountNumber;
				String accountDetails;
				System.out.println("Which account details would you like to see?");
				accountNumber = input.nextInt();
				input.nextLine();
				accountDetails = acc.get(accountNumber).toString();
				System.out.println(accountDetails);
				//retreiveAccountDetails(accountNumber);
			}
			else if (answer == 4) {
				System.out.println("Going back to the main menu.\n");
			}
			else {
				System.out.println("Invalid input. Type again please.\n");
			}
			
		} while (answer != 4);

	}
}
