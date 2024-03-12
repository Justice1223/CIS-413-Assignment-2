package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class AccountDAOConcrete implements AccountDAO {

    private DataSource dataSource;

    public AccountDAOConcrete(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    @Override
    public AccountDTO getAccount(String accountId) {
        AccountDTO account = null;
        String sql = "SELECT accountId, balance, creationDate, customerId FROM Accounts WHERE accountId = ?";
        
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            
            ps.setString(1, accountId);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                account = new AccountDTO(
                    rs.getString("accountId"),
                    rs.getDouble("balance"),
                    rs.getTimestamp("creationDate").toLocalDateTime() // Assuming 'creationDate' is stored as a timestamp
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return account;
    }
}