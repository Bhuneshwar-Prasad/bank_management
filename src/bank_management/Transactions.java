package bank_management;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transactions {

    public enum TransactionType {
        DEPOSIT, WITHDRAWAL;
    }

    public class Transaction {
        private TransactionType type;
        private BigDecimal amount;
        private LocalDateTime dateTime;

        public Transaction(TransactionType type, BigDecimal amount, LocalDateTime dateTime) {
            this.type = type;
            this.amount = amount;
            this.dateTime = dateTime;
        }

        public TransactionType getType() {
            return type;
        }

        public BigDecimal getAmount() {
            return amount;
        }

        public LocalDateTime getDateTime() {
            return dateTime;
        }

        public void displayTransaction() {
        	// displays the transaction in date and time format
        	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        	String formattedDateTime = dateTime.format(formatter);
        	
            System.out.println("Type: " + type);
            System.out.println("Amount: " + amount);
            System.out.println("Date and Time: " + formattedDateTime);
        }
    }
}
