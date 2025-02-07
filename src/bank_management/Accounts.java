package bank_management;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Accounts {

	private String account_Number;
	private String account_Holder_Name;
	private String account_Holder_Address;
	private LocalDate opening_Date;
	private BigDecimal current_Balance;
	private CustomLinkedList<Transactions.Transaction> transactions;
	
	Accounts(String account_number, String account_holder_name, String account_holder_address, LocalDate account_opening_date, BigDecimal current_balance){
		this.account_Number = account_number;
		this.account_Holder_Name = account_holder_name;
		this.account_Holder_Address = account_holder_address;
		this.opening_Date = account_opening_date;
		this.current_Balance = current_balance;
		this.transactions = new CustomLinkedList<>();
	}
	
	public void displayAccountDetails() {
		// displays account details
		System.out.println("Account Number: " + getAccount_Number()); 
		System.out.println("Account Holder: " + getAccount_Holder_Name()); 
		System.out.println("Address: " + getAccount_Holder_Address()); 
		System.out.println("Opening Date: " + getOpening_Date()); 
		System.out.println("Current Balance: " + getCurrent_Balance());
	}
	
	public void addTransaction(Transactions.Transaction transaction) 
	{ 
		// Validates the transaction and add the Transaction in CustomLinkedList based on DEPOSIT and WITHDRAW
		if(!validateTransaction(transaction)) return;

		if (transaction.getType() == Transactions.TransactionType.DEPOSIT) { 
			current_Balance = current_Balance.add(transaction.getAmount());
			} 
		else if (transaction.getType() == Transactions.TransactionType.WITHDRAWAL) { 
			current_Balance = current_Balance.subtract(transaction.getAmount());
			}
		
		transactions.addFirst(transaction); 
		if (transactions.size() > 4) { 
			transactions.removeLast(); 
			} 
		System.out.println("Transaction successful: " + transaction.getType() + " of " + transaction.getAmount()); 
		}
	
	
	
	private boolean validateTransaction(Transactions.Transaction transaction) {
		// Deposit / Withdrawal amount validation
		if (transaction.getType() == Transactions.TransactionType.WITHDRAWAL && transaction.getAmount().compareTo(current_Balance) > 0) { 
			System.out.println("Transaction failed: Insufficient funds."); 
			return false; 
		} 
		if (transaction.getAmount().compareTo(BigDecimal.ZERO) < 0) { 
			System.out.println("Transaction failed: Transaction amount cannot be negative."); 
			return false; 
			} 
		return true;
	}
	
	public void displayLastFourTransactions() { 
		// displays the last four transactions after the validation
		if (transactions.isEmpty()) { 
			System.out.println("No transactions available."); 
			} 
		else { 
			List<Transactions.Transaction> transactionList = new ArrayList<>(); 
			transactions.forEach(transactionList::add); 
			// Sort transactions using bubble sort 
			bubbleSort(transactionList); 
			
			System.out.println("Last four transactions:"); 
			for (Transactions.Transaction transaction : transactionList) { 
				transaction.displayTransaction(); 
				System.out.println("-------------------------------------------"); 
				} 
			} 
		}
	
	private void bubbleSort(List<Transactions.Transaction> transactionList) { 
		// This method sorts the transactions based on the transaction amount
		int n = transactionList.size(); 
		for (int i = 0; i < n - 1; i++) { 
			for (int j = 0; j < n - i - 1; j++) { 
				if (transactionList.get(j).getAmount().compareTo(transactionList.get(j + 1).getAmount()) > 0) {
					Transactions.Transaction temp = transactionList.get(j); 
					transactionList.set(j, transactionList.get(j + 1)); 
					transactionList.set(j + 1, temp); 
					} 
				} 
			} 
		}
	
	// getters
	public String getAccount_Number() {
		return account_Number;
	}
	
	public String getAccount_Holder_Name() {
		return account_Holder_Name;
	}
	
	public String getAccount_Holder_Address() {
		return account_Holder_Address;
	}
	
	public LocalDate getOpening_Date() {
		return opening_Date;
	}
	
	public BigDecimal getCurrent_Balance() {
		return current_Balance;
	}
	
}
