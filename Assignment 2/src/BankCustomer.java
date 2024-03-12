package src;

import java.util.List;

public class BankCustomer {


    String firstName;
    String lastName;
    CustomerAddress address;
    List<Account> accounts;

    // creating costructor for BankCustomer class;
    BankCustomer(String fn, String ln)
    {

        this.firstName = fn;
        this.lastName = ln;
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
    public List<Account> getAccounts() {
        return accounts;
    }
    public String toString() {
        
        String str = "Customer object: \n";
        
        str += "First Name --> " + this.getFirstName() + "\nLast Name --> " + this.getLastName() + this.getAddress().toString()+ accounts();
   }
}
