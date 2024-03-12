package src;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class TransactionDAOConcrete implements TransactionDAO {
    private DataSource dataSource;

    public TransactionDAOConcrete(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public TransactionDTO getTransaction(String transactionId) throws SQLException {
        String sql = "SELECT * FROM Transactions WHERE transactionId = ?";
        TransactionDTO transaction = null;

        try (Connection conn = dataSource.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, transactionId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                transaction = new TransactionDTO(
                    rs.getString("transactionId"),
                    rs.getDouble("amount"),
                    rs.getString("type")
                );
                transaction.setTimestamp(rs.getTimestamp("timestamp").toLocalDateTime());
            }
        }
        return transaction;
    }

    }
