package src;

import java.sql.SQLException;
import java.util.List;

public class BankCustomerDTO {


    private static final List<Account> Account = null;
    String firstName;
    String lastName;
    CustomerAddress address;
    List<Account> account;
    
    static BankCustomerDAOConcrete bd = new BankCustomerDAOConcrete();
    
    // creating costructor for BankCustomer class;
    public CustomerAddress(int num, String str, String cty, String st, int z) {

        street = str;
        number = num;
        city = cty;
        state = st;
        zip = z;
    }

    //Creating getter functions for BankCustomer class
    public String getFirstName()
    {
    return this.firstName;
    }
    public String getLastName()
    {
    return this.lastName;
    }
    // Creating setter functions for BankCustomer class
    public void setFirstName(String firstName)
    {
    this.firstName=firstName;
    }
    public void setLastName(String lastName)
    {
    this.lastName=lastName;
    }

    public String getName()
    {
    return this.firstName+","+this.lastName;
    }

    public CustomerAddress getAddress()
    {
    return this.address;
    }
    public List<Account> getAccount() {
        return Account;
    }
   
    public static BankCustomer CustomerByName(int aName) {
        
        BankCustomer anBankCustomer = null;
        
        try {
            anBankCustomer = bd.get(aName);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        if(anBankCustomer != null) System.out.println(anBankCustomer.toString()); 
            
        System.out.println("\nFetched BankCustomer with ID: " + aName + " BankCustomer Details:\n" + anBankCustomer.toString());        
        return anBankCustomer;
        
    }
    
    public static int performUpdate(BankCustomer anBankCustomer) {

        int updateResult = -1;
        
        try {
            updateResult = bd.update(anBankCustomer);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        
        if(updateResult != -1) System.out.println("\nUpdate Successful");
         System.out.println("BankCustomer Details:\n" + anBankCustomer.toString());
        return updateResult;        
    }
}