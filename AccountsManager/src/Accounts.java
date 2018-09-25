import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Accounts {
	// List of accounts//
	static HashMap<String, Accounts> username = new HashMap<String, Accounts>();
	static ArrayList<String> IDNum = new ArrayList<String>();
	//
	// Scanner//
	static Scanner input = new Scanner(System.in);
	//
	// Variables//
	private String name;
	private String userName;
	private int accountNumber;
	private int bankBalance;
	private static int numberOfAccounts = 0;
	private static int currentAccountNumber = 0;
	//

	// CONSTRUCTOR
	public Accounts(String name, String userName, int accountNumber, int bankBalance) {
		this.name = name;
		this.userName = userName;
		this.accountNumber = accountNumber;
		this.bankBalance = bankBalance;
	}
	// END

	// API METHODS//
	private static int getNumberofAccounts() {
		return numberOfAccounts;
	}

	private static void reduceNumberOfAccounts() {
		numberOfAccounts--;
	}

	private static void increaseNumberOfAccounts() {
		numberOfAccounts++;
	}

	public int getID() {
		return accountNumber;
	}

	private String getUsername() {
		return userName;
	}
	
	private void setUsername(String userName) {
		this.userName = userName;
	}

	public static void retreiveAccountDetails(int accountNumber) {

		System.out.println("Name of Accountholder: ");
	}

	public String toString() {
		String accountDetails = "\nUsername: " + this.userName + "\nAccount Number: " + this.accountNumber + "\nName: "
				+ this.name + "\nBank balance: " + this.bankBalance + "\n";
		return accountDetails;
	}

	private static int searchByIDOrName() {
		String IDOrName;
		int doWhileLoop = 0;
		do {
			System.out.println("Find account by: \n-Account ID? \t -Username?");
			System.out.println("Type in [ID] or [Username].");
			IDOrName = input.nextLine();
			if (IDOrName.equalsIgnoreCase("ID")) {
				doWhileLoop = 1;
			} else if (IDOrName.equalsIgnoreCase("Username")) {
				doWhileLoop = 2;
			} else {
				System.out.println("Invalid input. Type again please.\n");
				doWhileLoop = 0;
			}
		} while (doWhileLoop == 0);
		return doWhileLoop;
	}

	private static int getYesOrNo() {
		String confirmation;
		int indicator;
		do {
			System.out.println("Type [Yes] or [No].");
			confirmation = input.nextLine();
			if (confirmation.equalsIgnoreCase("Yes")) {
				System.out.println("");
				indicator = 1;
			} else if (confirmation.equalsIgnoreCase("No")) {
				System.out.println("");
				indicator = 0;
			} else {
				System.out.println("That was an invalid response, type either 'Yes' or 'No'.");
				indicator = 2;
			}
		} while (indicator == 2);
		return indicator;
	}
	////

	// ADD ACCOUNT METHODS//
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
			String newUsername = usernameChecker();
			String newName = addAccountName(i);
			int newBankBalance = addInitialBankBalance();
			IDNum.add(newUsername);
			username.put(newUsername, new Accounts(newName, newUsername, currentAccountNumber, newBankBalance));
			increaseNumberOfAccounts();
		}
	}

	private static String usernameChecker() {
		int indicator;
		String newUsername;
		do {
			System.out.println("Type in your new username.");
			newUsername = input.nextLine();
			System.out.println("Checking if username is available...");
			if (username.containsKey(newUsername)) {
				System.out.println("ID already exists! try another one");
				indicator = 0;
			} else {
				System.out.println("you're good to go!");
				indicator = 1;
			}
		} while (indicator == 0);
		return newUsername;
	}

	private static String addAccountName(int i) {
		System.out.println("Type in the name of the new account holder. [" + i + "]");
		System.out.print("Name: ");
		String newName = input.nextLine();
		return newName;
	}

	private static int addInitialBankBalance() {
		System.out.println("Type in the balance of this account.");
		System.out.print("Balance: ");
		int newBankBalance = input.nextInt();
		input.nextLine();
		System.out.println("");
		return newBankBalance;
	}
	////

	// DELETE ACCOUNT METHODS//
	public static void deleteAccount() {
		int IDOrName;
		int indicator;
		String accountDeleteName;
		String userKey;
		int accountDeleteID;
		IDOrName = searchByIDOrName();

		switch (IDOrName) {

		case 1:
			do {
				System.out.println("Which account would you like to delete?");
				System.out.print("ID number: ");
				accountDeleteID = input.nextInt();
				input.nextLine();
				System.out.println("Details of account number " + accountDeleteID + " are shown below.\n");
				userKey = IDNum.get(accountDeleteID);
				System.out.println(username.get(userKey).toString());
				System.out.println("Are you sure you want to delete this user?");
				indicator = getYesOrNo();
			} while (indicator == 0);
			IDNum.set(accountDeleteID, null);
			username.remove(userKey);
			reduceNumberOfAccounts();
			System.out.println("Account deleted! Heading back to the main menu..\n");
			break;

		case 2:
			int userID;
			do {
				System.out.println("Which account would you like to delete?");
				System.out.print("Username of account: ");
				accountDeleteName = input.nextLine();
				System.out.println("Details of the account " + accountDeleteName + " are shown below.\n");
				System.out.println(username.get(accountDeleteName).toString());
				System.out.println("Are you sure you want to delete this user?");
				indicator = getYesOrNo();
			} while (indicator == 0);
			userID = username.get(accountDeleteName).getID();
			IDNum.set(userID, null);
			username.remove(accountDeleteName);
			reduceNumberOfAccounts();
			System.out.println("Account deleted! Heading back to the main menu..\n");
			break;
		}
	}

	////

	// MANAGE ACOCUNT METHODS//
	public static void manageAccount() {
		int answer;
		int goBack = 0;
		System.out.println("What would you like to manage?\n");
		System.out.println(
				"1. Add account money.\n" + "2. Remove account money.\n" + "3. Transfer money.\n" + "4. Go back.");
		System.out.println("Enter either '1', '2', '3' or '4' for corresponding action.");
		System.out.print("Input: ");
		answer = input.nextInt();
		input.nextLine();

		if (answer == 1) {
			addMoney();
		} else if (answer == 2) {
			removeMoney();
		} else if (answer == 3) {
			transferMoney();
		} else if (answer == 4) {
			goBack = 1;
		}
	}

	// TRANSFER MONEY METHODS//
	private static void transferMoney() {
		int IDFrom;
		int IDTo;
		int transferAmount;
		int indicator;
		int IDNAME;
		String usernameFrom = null;
		String usernameTo = null;
		IDNAME = searchByIDOrName();
		switch (IDNAME) {

		case 1:
			System.out.println("Which account to transfer money out of?");
			System.out.print("Account ID (From): ");
			IDFrom = input.nextInt();
			input.nextLine();
			usernameFrom = IDNum.get(IDFrom);
			System.out.println("Which account to transfer money to?");
			System.out.print("Account ID (To): ");
			IDTo = input.nextInt();
			input.nextLine();
			usernameTo = IDNum.get(IDTo);
			System.out.println("How much money do you want to transfer?");
			transferAmount = input.nextInt();
			input.nextLine();
			System.out.println("Determining if there are sufficient funds...");
			indicator = username.get(usernameFrom).checkSufficientFunds(transferAmount);
			if (indicator == 1) {
				System.out.println("Transferring funds...");
				username.get(usernameTo).addMoneyToAccount(transferAmount);
				username.get(usernameFrom).removeMoneyAccount(transferAmount);
				System.out.println("Transfer Complete!");
			} else {
				System.out.println("Transaction cancelled!\n");
			}
			break;

		case 2:
			System.out.println("Which account to transfer money out of?");
			System.out.print("Account Username (From): ");
			usernameFrom = input.nextLine();
			System.out.println("Which account to transfer money to?");
			System.out.print("Account Username (To): ");
			usernameTo = input.nextLine();
			System.out.println("How much money do you want to transfer?");
			transferAmount = input.nextInt();
			input.nextLine();
			System.out.println("Determining if there are sufficient funds...");
			indicator = username.get(usernameFrom).checkSufficientFunds(transferAmount);
			if (indicator == 1) {
				System.out.println("Transferring funds...");
				username.get(usernameTo).addMoneyToAccount(transferAmount);
				username.get(usernameFrom).removeMoneyAccount(transferAmount);
				System.out.println("Transfer Complete!");
			} else {
				System.out.println("Transaction cancelled!\n");
			}
			break;
		}
	}

	private int checkSufficientFunds(int transferAmount) {
		int enoughFunds;
		if (bankBalance < transferAmount) {
			int amountNeeded = transferAmount - bankBalance;
			System.out.println("You do not have sufficient funds!");
			System.out.println("You need " + amountNeeded + " more to complete this transaction");
			enoughFunds = 0;
		} else {
			System.out.println("You have sufficient funds!");
			enoughFunds = 1;
		}
		return enoughFunds;
	}

	//
	// REMOVE MONEY METHOD//
	private static void removeMoney() {
		String accountHolder;
		int accountID;
		int removeMoney;
		int IDNAME;
		IDNAME = searchByIDOrName();
		switch (IDNAME) {

		case 1:
			System.out.println("Choose account to remove money from:");
			System.out.print("Enter ID of account: ");
			accountID = input.nextInt();
			input.nextLine();
			accountHolder = IDNum.get(accountID);
			System.out.println("How much do you want to remove?");
			System.out.println("Enter amount to remove: ");
			removeMoney = input.nextInt();
			input.nextLine();
			System.out.println("Removing Money...");
			username.get(accountHolder).removeMoneyAccount(removeMoney);
			break;

		case 2:
			System.out.println("Choose accountholder to remove money from:");
			System.out.print("Enter name of accountholder: ");
			accountHolder = input.nextLine();
			System.out.println("How much do you want to remove?");
			System.out.println("Enter amount to remove: ");
			removeMoney = input.nextInt();
			input.nextLine();
			System.out.println("Removing Money...");
			username.get(accountHolder).removeMoneyAccount(removeMoney);
			break;
		}
	}

	private void removeMoneyAccount(int removeMoney) {
		if (this.bankBalance >= removeMoney) {
			this.bankBalance -= removeMoney;
			System.out.println("Money successfully removed!");
		} else {
			System.out.println("Insufficient funds! Bank balance will go into overdraft.");
			System.out.println("Transaction failed!");
		}
	}
	////

	// ADD MONEY METHOD//
	private static void addMoney() {
		String accountHolder;
		int accountID;
		int addMoney;
		int IDNAME;
		IDNAME = searchByIDOrName();
		switch (IDNAME) {

		case 1:
			System.out.println("Choose account to add money to:");
			System.out.print("Enter ID of account: ");
			accountID = input.nextInt();
			input.nextLine();
			accountHolder = IDNum.get(accountID);
			System.out.println("How much do you want to add?");
			System.out.println("Enter amount to add: ");
			addMoney = input.nextInt();
			input.nextLine();
			System.out.println("Adding Money...");
			username.get(accountHolder).addMoneyToAccount(addMoney);
			System.out.println("Money successfully added!");
			break;

		case 2:
			System.out.print("Enter name of accountholder: ");
			accountHolder = input.nextLine();
			System.out.println("How much do you want to add?");
			System.out.println("Enter amount to add: ");
			addMoney = input.nextInt();
			input.nextLine();
			System.out.println("Adding Money...");
			username.get(accountHolder).addMoneyToAccount(addMoney);
			System.out.println("Money successfully added!");
			break;
		}
	}

	private void addMoneyToAccount(int addMoney) {
		this.bankBalance += addMoney;
	}
	////

	// OTHER SECTION//
	public static void other() {
		int answer;
		do {
			System.out.println("You are in the 'other' menu. What would you like to do?");
			System.out.println("1. Display total number of accounts.\n" + "2. Display next account number.\n"
					+ "3. View account details.\n" + "4. Change account username.\n" + "5. Go back.");
			System.out.println("Enter either '1' , '2' , '3', '4' or '5' for corresponding action.");
			answer = input.nextInt();
			input.nextLine();

			if (answer == 1) {
				int numberOfAccounts = getNumberofAccounts();
				System.out.println("The total number of accounts active are " + numberOfAccounts);
			} else if (answer == 2) {
				int nextAccountNumber = getNumberofAccounts() + 1;
				System.out.println("The next account number is: " + nextAccountNumber);
			} else if (answer == 3) {
				int accountNumber;
				int IDNAME;
				int indicator;
				String accountHolder;
				String accountDetails;
				IDNAME = searchByIDOrName();
				switch (IDNAME) {

				case 1:
					do {
						System.out.println("Which account details would you like to see?");
						accountNumber = input.nextInt();
						input.nextLine();
						accountHolder = IDNum.get(accountNumber);
						if (username.containsKey(accountHolder)) {
							accountDetails = username.get(accountHolder).toString();
							System.out.println(accountDetails);
							indicator = 1;
						} else {
							System.out.println("Account doesn't exist!");
							indicator = 0;
						}
						// retreiveAccountDetails(accountNumber);	
					} while (indicator == 0);
					break;

				case 2:
					do {
						System.out.println("Which account details would you like to see?");
						accountHolder = input.nextLine();
						if (username.containsKey(accountHolder)) {
							accountDetails = username.get(accountHolder).toString();
							System.out.println(accountDetails);
							indicator = 1;
						} else {
							System.out.println("Account doesn't exist!");
							indicator = 0;
						}						
					} while (indicator == 0);					
					// retreiveAccountDetails(accountNumber);
					break;
				}
			} else if (answer == 4) {
				String initialUsername;
				String newUsername = null;
				int indicator;
				do {
					System.out.println("Which account username are you changing?");
					initialUsername = input.nextLine();
					if (username.containsKey(initialUsername)) {
						System.out.println("What ID would you like to change it to?");
						newUsername = input.nextLine();
						System.out.println("Checking if username is available...");
						indicator = usernameChecker(newUsername);
					} else {
						System.out.println("No such user exists! Try again");
						indicator = 0;
					}
				} while (indicator == 0);
				usernameRename(initialUsername, newUsername);
			} else if (answer == 5) {
				System.out.println("Going back to the main menu.\n");
			} else {
				System.out.println("Invalid input. Type again please.\n");
			}
		} while (answer != 5);
	}
	////

	private static void usernameRename(String initialUsername, String newUsername) {
		int userID;
		System.out.println("Updating ID index..");
		userID = username.get(initialUsername).getID();
		IDNum.set(userID, newUsername);    //changes ID arraylist to latest username
		System.out.println("Renaming user..");
		username.get(initialUsername).setUsername(newUsername);//update the users account details
		System.out.println("Updating hashmap..");
		username.put(newUsername, username.get(initialUsername));  //inserts new username entry
		System.out.println("Removing old hashmap entry..");
		username.remove(initialUsername);  //removes initial username key value entry
		System.out.println("Username change complete!");
	}

	private static int usernameChecker(String newUsername) {
		int indicator;
		if (username.containsKey(newUsername)) {
			System.out.println("This usename is already taken! Try again.");
			indicator = 0;
		} else {
			System.out.println("Username is available!");
			indicator = 1;
		}
		return indicator;
	}
}
