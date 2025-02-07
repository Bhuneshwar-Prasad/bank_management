package bank_management;
import java.math.BigDecimal;

import bank_management.Transactions.TransactionType;

public interface AccountOperations {

	void createAccount(String accountHolderName, String accountHolderAddress); 
	void displayAllAccounts(); 
	void deleteAccount(String accountNumber); 
	void addTransaction(String accountNumber, TransactionType type, BigDecimal amount);
	void displayLastFourTransactions(String accountNumber);
	BigDecimal getAccountBalance(String accountNumber);
}
