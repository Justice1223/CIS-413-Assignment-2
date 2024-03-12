package src;

import java.time.LocalDateTime;
import java.util.List;

public class Account{
    String accountId;
    double balance;
    LocalDateTime creationDate;
    BankCustomer customer;
    CustomerAddress address;
    List<Transaction> transactions;

    public Account(double initialBalance,String accountId) {
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
    
    @Override
    public int compareTo(Account other) {
        int dateComparison = this.creationDate.compareTo(other.creationDate);
        if (dateComparison != 0) return dateComparison;
        return Double.compare(other.balance, this.balance); // Higher balance has higher priority
    }

    @Override
public String toString() {
    return "Account{" +
           "accountId='" + accountId + '\'' +
           ", balance=" + balance +
           ", creationDate=" + creationDate +
           ", customer=" + (customer != null ? "CustomerID: " + customer.getId() : "No customer assigned") +
           ", address=" + (address != null ? address.toString() : "No address assigned") +
           '}';
    }


    public void setId(String accountId2) {
        
        throw new UnsupportedOperationException("Unimplemented method 'setId'");
    }
}
