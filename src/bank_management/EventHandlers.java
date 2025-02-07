package bank_management;

import java.math.BigDecimal;
import java.util.Scanner;

class EventHandlers {
    static int choice;
	static Scanner sc = new Scanner(System.in); 
	
    public static void promptWelcome() { 
    	showAccountOperations(sc); 
    	}

    public static void showAccountOperations(Scanner sc) {
    	// Main Menu
        System.out.println("\n 1. Create a new account");
        System.out.println("\n 2. Display all accounts");
        System.out.println("\n 3. Delete an account");
        System.out.println("\n 4. Add a transaction");
        System.out.println("\n 5. Display last four transactions");
        System.out.println("\n 6. Exit");

        choice = UtilityMethods.getIntInput(sc, "\nChoice: ");
        selection(choice);
    }

    public static void selection(int choice) {
        switch (choice) {
            case 1: {
                accountCreationPrompt();
                System.out.println("\n[===============] Any other operations? [==================]");
                promptWelcome();
                break;
            }
            case 2: {
                accountDisplayPrompt();
                System.out.println("\n[===============] Any other operations? [==================]");
                promptWelcome();
                break;
            }
            case 3: {
                accountDeletionPrompt();
                System.out.println("\n[===============] Any other operations? [==================]");
                promptWelcome();
                break;
            }
            case 4: {
            	addTransactionPrompt();
            	System.out.println("\n[===============] Any other operations? [==================]");
                promptWelcome();
                break;
            }
            case 5: {
            	displayLastFourTransactionsPrompt(); 
            	System.out.println("\n[===============] Any other operations? [==================]"); 
            	promptWelcome();
                break;
            }
            case 6: {
                System.out.println("\nExiting");
                break;
            }
            default: {
            	System.out.println("\nPlease enter a valid choice"); 
            	showAccountOperations(sc);
                break;
            }
        }
    }
    
    public static void accountCreationPrompt() {
    	// Prompt for account creation
    	Scanner sc = new Scanner(System.in);
    	String fullname;
    	String fulladdress;
    	
    	System.out.println("\nCreating a new Account");
    	System.out.println("=============================================");
    	System.out.println("|| Please enter the details as shown below ||");
    	System.out.println("=============================================");
    	System.out.println("Enter your full name as in your goverment ids");
    	
    	fullname = UtilityMethods.getCharInput(sc, "\nEnter Account Holder Full Name");
    	System.out.print("Enter Account Holder Address: ");
    	fulladdress = sc.nextLine();
    	System.out.println("");
    	AccountManager newAccount = new AccountManager();
    	newAccount.createAccount(fullname, fulladdress);
    }
    
    public static void accountDisplayPrompt() {
    	// Prompt for displaying the account details
    	AccountManager acc = new AccountManager();
    	System.out.println("=============================================");
    	System.out.println("|| Displaying All Bank Accounts Available  ||");
    	System.out.println("=============================================");
    	acc.displayAllAccounts();
    }
    
    public static void accountDeletionPrompt() {
    	// Prompt for deleting the already closed account
    	AccountManager acc = new AccountManager();
    	Scanner sc = new Scanner(System.in);
    	System.out.println("==============================================");
    	System.out.println("|| Deleting the Given Closed Account Number ||");
    	System.out.println("==============================================");
    	String accNum = UtilityMethods.getCharInputAccountNumber(sc, "Enter the account number which you want to delete");
 
    	acc.deleteAccount(accNum);
    }
    
    public static void addTransactionPrompt() { 
    	// Prompt for adding the transaction to the account number
    	AccountManager acc = new AccountManager(); 
    	Scanner sc = new Scanner(System.in); 

    	System.out.println("=======================================================");
    	System.out.println("|| Adding a Transaction for the given Account Number ||");
    	System.out.println("=======================================================");
    	
    	String accNum = UtilityMethods.getCharInputAccountNumber(sc, "\nEnter the account number for the transaction");
    	
    	System.out.println("Enter 1 for Deposit or 2 for Withdrawal"); 
    	int typeChoice = UtilityMethods.getIntInput(sc, "\nChoice: "); 
    	BigDecimal amount = UtilityMethods.getBigDecimalInput(sc, "\nEnter the amount: "); 
    	
    	Transactions.TransactionType type; 
    	if (typeChoice == 1) { 
    			type = Transactions.TransactionType.DEPOSIT; 
    		} 
    	else if (typeChoice == 2) { 
    			type = Transactions.TransactionType.WITHDRAWAL; 
    			} 
    	else { 
    			System.out.println("\nInvalid choice. Transaction cancelled."); 
    			return; 
    		 } 
    	acc.addTransaction(accNum, type, amount); 
    }
    
    public static void displayLastFourTransactionsPrompt() {
    	// Prompt for displaying the last four transactions in a sorted way
    	AccountManager acc = new AccountManager(); 
    	Scanner sc = new Scanner(System.in); 
    	System.out.println("======================================================"); 
    	System.out.println("|| Displaying Last Four Transactions for the Account||"); 
    	System.out.println("======================================================"); 
    	String accNum = UtilityMethods.getCharInputAccountNumber(sc, "Enter the account number to display transactions"); 
    	acc.displayLastFourTransactions(accNum); 
    	}
    
    
    
    }

