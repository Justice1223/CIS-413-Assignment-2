package src;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class AccountDTO{
    String accountId;
    double balance;
    LocalDateTime creationDate;
    BankCustomer customer;
    CustomerAddress address;
    List<Transaction> transactions;
    
    static AccountDAOConcrete ed = new AccountDAOConcrete(null);
    
    public AccountDTO(String accountId, double initialBalance, LocalDateTime localDateTime) {
        this.accountId = accountId;
        this.balance = initialBalance;
        this.creationDate = LocalDateTime.now();
    }
   
    // Getters and setters
    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }
    
    public BankCustomer getCustomer() {
        return customer;
    }
    public void setCustomer(BankCustomer customer) {
        this.customer = customer;
    }

    public CustomerAddress getCustomerAddress() {
        return this.address;
    }

    public void setCustomerAddress(CustomerAddress address) {
        this.address = address;
    }

    // Transaction methods (simplified)
    public void updateBalance(double newBalance) {
        this.balance = newBalance;
    }
    public void deleteAccount() {
        accountId = null;
    }
    public static Account fetchAccountData(String accountId) {
        Account fetchedAccount = null;
        return fetchedAccount;
    }
     
    public static Account AccountByID(int anId) {
        
        Account anAccount = null;
        
        try {
            anAccount = ed.get(anId);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        if(anAccount != null) System.out.println(anAccount.toString()); 
            
        System.out.println("\nFetched Account with ID: " + anId + " Account Details:\n" + anAccount.toString());        
        return anAccount;
        
    }

}