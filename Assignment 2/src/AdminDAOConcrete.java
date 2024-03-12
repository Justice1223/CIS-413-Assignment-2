package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class AdminDAOConcrete implements AdminDAO {
    private DataSource dataSource;

    public AdminDAOConcrete(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public AdminDTO getAdmin(String adminId) throws SQLException {
        String sql = "SELECT * FROM Admins WHERE id = ?";
        AdminDTO admin = null;
        
        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, adminId);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                admin = new AdminDTO(
                    rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password")
                );
            }
        }
        return admin;
    }
}