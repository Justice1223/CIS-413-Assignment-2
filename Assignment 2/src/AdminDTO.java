package src;
import java.sql.SQLClientInfoException;
import java.sql.SQLException;
import java.util.List;

public class AdminDTO extends BankCustomerDTO {
    private String id;
    private String name;
    private String email; 
    private String password;
     
    static AdminDAOConcrete ad = new AdminDAOConcrete();

    // Constructor
    public AdminDTO(String id, String name, String email, String password) {
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
    public static Admin AdminByID(int anId) {
        
        Admin anAdmin = null;
        
        try {
            anAdmin = ad.get(anId);
        } catch(SQLClientInfoException se) {
            System.out.println(se.getMessage());
        }
        if(anAdmin != null) System.out.println(anAdmin.toString()); 
            
        System.out.println("\nFetched Admin with ID: " + anId + " Admin Details:\n" + anAdmin.toString());        
        return anAdmin;
        
    }
    
    public static int performUpdate(Admin anAdmin) {

        int updateResult = -1;
        
        try {
            updateResult = ad.update(anAdmin);
        } catch(SQLException se) {
            System.out.println(se.getMessage());
        }
        
        if(updateResult != -1) System.out.println("\nUpdate Successful");
         System.out.println("Admin Details:\n" + anAdmin.toString());
        return updateResult;        
    }
}