package src;

import java.sql.SQLException;
import java.time.LocalDateTime;

public class TransactionDTO {
     String transactionId;
     LocalDateTime timestamp;
     double amount;
     String type; // e.g., "deposit", "withdrawal", "transfer"
     Account account;
     double balance;

    public TransactionDTO(String transactionId, double amount, String type) {
        this.transactionId = transactionId;
        this.timestamp = LocalDateTime.now();
        this.amount = amount;
        this.type = type;
    }
    static TransactionDAOConcrete Td = new TransactionDAOConcrete(null);
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
    
    public static Transaction TransactionByTransactionID(int anTId) {
        
        Transaction anTransaction = null;
        
        try {
            anTransaction = Td.get(anTId);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        if(anTransaction != null) System.out.println(anTransaction.toString()); 
            
        System.out.println("\nFetched Transaction with ID: " + anTId + " Transaction Details:\n" + anTransaction.toString());        
        return anTransaction;
        
    }
    
    public static int performUpdate(Transaction anTransaction) {

        int updateResult = -1;
        
        try {
            updateResult = Td.update(anTransaction);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        
        if(updateResult != -1) System.out.println("\nUpdate Successful");
         System.out.println("Transaction Details:\n" + anTransaction.toString());
        return updateResult;        
    }

    public void setTimestamp(LocalDateTime localDateTime) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setTimestamp'");
    }
}