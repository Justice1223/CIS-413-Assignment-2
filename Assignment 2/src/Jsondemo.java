import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.time.LocalDateTime;

public class JSONDemo {

    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        
        System.out.println("\nCreating Account object");
        
        // Simulate creating related objects and setting them to the Account
        BankCustomer customer = new BankCustomer("customer123", "John Doe", "john.doe@example.com");
        // Creating an Account object
        Account account = new Account(1000.0, "account123");
        account.setCustomer(customer); // Assuming setCustomer method exists and is correct
        account.setCustomerAddress(address); // Assuming setCustomerAddress method exists and is correct
        account.setCreationDate(LocalDateTime.now()); // Assuming setter exists
        
        String accountJsonString = ""; 
        
        // Serialize Account object to JSON string
        try {
            accountJsonString = objectMapper.writeValueAsString(account);
            System.out.println("\nJSON String version of Account object\n" + accountJsonString);
        } catch (JsonProcessingException e) {
            System.out.println("Error serializing account: " + e.getMessage());
        }
        
        // Deserialize JSON string back to an Account object
        try {
            Account deserializedAccount = objectMapper.readValue(accountJsonString, Account.class);
            System.out.println("\nDeserialized Account object:");
            System.out.println(deserializedAccount);
        } catch (JsonProcessingException e) {
            System.out.println("Error deserializing account: " + e.getMessage());
        }
    }
}