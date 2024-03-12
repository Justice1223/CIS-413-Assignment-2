package src;
import java.sql.SQLException;
public interface TransactionDAO {
    TransactionDTO getTransaction(String transactionId) throws SQLException;
    }