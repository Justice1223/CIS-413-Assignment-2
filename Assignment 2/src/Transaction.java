package src;

import java.time.LocalDateTime;

public class Transaction {
     String transactionId;
     LocalDateTime timestamp;
     double amount;
     String type; // e.g., "deposit", "withdrawal", "transfer"
     double balance;

    public Transaction(String transactionId, double amount, String type, Account account) {
        this.transactionId = transactionId;
        this.timestamp = LocalDateTime.now();
        this.amount = amount;
        this.type = type;
    }

    // Getters
    public String getTransactionId() {
        return transactionId;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    // Setters
    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setType(String type) {
        this.type = type;
    }
    public void deposit(double amount) {
        // Assume validation and transaction recording is done elsewhere
        this.balance += amount;
    }

    public void withdraw(double amount) {
        // Assume validation and transaction recording is done elsewhere
        this.balance -= amount;
    }
    public static void transfer(Account fromAccount, Account toAccount, double amount) {
        if (fromAccount == null || toAccount == null) {
            throw new IllegalArgumentException("Accounts cannot be null");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }
        if (fromAccount.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds in the source account");
        }
        try {
            // Update the balance of the source account
            fromAccount.updateBalance(fromAccount.getBalance() - amount);
            // Update the balance of the destination account
            toAccount.updateBalance(toAccount.getBalance() + amount);            
            // Log the transaction (optional, for auditing purposes)
            System.out.println("Transferred " + amount + " from account " + fromAccount.getAccountId() + " to account " + toAccount.getAccountId());
            
        } catch (Exception e) {
            // If an error occurs, rollback the transaction to maintain data integrity
            throw new RuntimeException("Failed to complete the transfer", e);
        }
    }
    // To represent Transaction information as a String
    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId='" + transactionId + '\'' +
                ", timestamp=" + timestamp +
                ", amount=" + amount +
                ", type='" + type + '\'' +
                ", account=" + account.getAccountId() + // Assuming Account class has this method
                '}';
    }
}