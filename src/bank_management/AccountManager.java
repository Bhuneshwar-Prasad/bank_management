package bank_management;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import bank_management.Transactions.TransactionType;

public class AccountManager implements AccountOperations{
	private static Map<String, Accounts> accountsMap = new HashMap<>();
	

	private String generateAccountNumber() {
		// generates unique account number with given maxDigits length
		Random random = new Random(); 
		StringBuilder accountNumber = new StringBuilder(); 
		int maxDigits = 15;
		for (int i = 0; i < maxDigits; i++) { 
			int digit = random.nextInt(10); 
			accountNumber.append(digit); 
			} 
		return accountNumber.toString();
	}

	@Override
	public void createAccount(String accountHolderName, String accountHolderAddress) {
		// creates account and adds the account to the HashMap for easier searching
		String accountNumber = generateAccountNumber();
		LocalDate openingDate = LocalDate.now();
		BigDecimal initialBalance = BigDecimal.ZERO;
		
		Accounts newAccount = new Accounts(accountNumber, accountHolderName, accountHolderAddress, openingDate, initialBalance);
		
		getAccountsMap().put(accountNumber, newAccount);
		System.out.println("Account has been created successfully");
		System.out.println("Bank Account Number has been generated : " + newAccount.getAccount_Number());
	}

	@Override
	public void displayAllAccounts() {
		// displays all the accounts available in the HashMap
	    if (accountsMap.isEmpty()) {
	        System.out.println("No accounts available.");
	    } else {
	        for (Accounts account : accountsMap.values()) {
	            account.displayAccountDetails();
	            System.out.println("-------------------------------------------");
	        }
	    }
	}

	@Override
	public void deleteAccount(String accountNumber) {
		// deletes the closed account number (Assuming the account has been closed already, so implemented removal of account)
	    if (getAccountsMap().containsKey(accountNumber)) {
	        getAccountsMap().remove(accountNumber);
	        System.out.println("Account deleted successfully.");
	    } else {
	        System.out.println("Account with number " + accountNumber + " does not exist.");
	    }
	}

	@Override
	public void addTransaction(String accountNumber, TransactionType type, BigDecimal amount) 
	{  
		// Fetches the given account number's object and adds the transaction in that account.
		Accounts account = getAccountsMap().get(accountNumber); 
		if (account != null) { 
			Transactions.Transaction transaction = new Transactions().new Transaction(type, amount, LocalDateTime.now()); 
			account.addTransaction(transaction); 
			} 
		else { 
			System.out.println("Account with number " + accountNumber + " does not exist."); 
			}
	}

	@Override
	public void displayLastFourTransactions(String accountNumber) {
		// This displays last four transactions for that account number
	    Accounts account = getAccountsMap().get(accountNumber);
	    if (account != null) {
	        account.displayLastFourTransactions();
	    } else {
	        System.out.println("Account with number " + accountNumber + " does not exist.");
	    }
	}


	public static Map<String, Accounts> getAccountsMap() {
		// getter for HashMap which stores account number and account object
		return accountsMap;
	}

	@Override
	public BigDecimal getAccountBalance(String accountNumber) 
	{ 
		// Fetches the current account balance from the given account number
		if (accountsMap.containsKey(accountNumber)) { 
			return accountsMap.get(accountNumber).getCurrent_Balance(); 
			} else { 
				System.out.println("Account not found."); 
				return BigDecimal.ZERO; 
				} 
	}

}
