package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class BankCustomerDAOConcrete implements BankCustomerDAO {

    private DataSource dataSource;

    public BankCustomerDAOConcrete() {
        
    }


    @Override
    public BankCustomerDTO getCustomer(String FirstName) {
        BankCustomerDTO customer = null;
        String sql = "SELECT FirstName, Last, FROM BankCustomers WHERE FirstName = ?";
         
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, FirstName);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                customer = new BankCustomerDTO(
                    rs.getString("FirstName"),
                    rs.getString("LastName")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Consider more sophisticated error handling and/or rethrowing a custom exception
        }
        
        return customer;
    }
}