package src;

public class Admin extends BankCustomer {
    private String id;
    private String name;
    private String email; 
    private String password; // Consider encryption or hashing in real-world applications
    
    public Admin(String id, String name, String email, String password) {
        super(id, name, email); // Assuming BankCustomerDTO has these fields
        this.password = password;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Administrative functions
    public void manageAccount(Account account, String accountId, double newBalance) {
        account.setId(accountId); // Simulate updating the account's Id
        account.setBalance(newBalance); // Simulate updating the account's balance
    }
    // Security-specific methods
    public void delegateSecurityChecks() {
        Security security = new Security();
        security.performSecurityChecks();
    }

    @Override
    public String toString() {
        return "Admin{" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", email='" + email + '\'' +
               ", password='" + password + '\'' +
               '}';
    }
}