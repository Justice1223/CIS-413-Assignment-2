package src;

import java.sql.SQLException;

public interface AdminDAO {
    AdminDTO getAdmin(String adminId) throws SQLException;
}