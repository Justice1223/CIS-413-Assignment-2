package src;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;

class AccountTest {
    
    @Test
    void testAccountCreation() {
        Account account = new Account(1000.0, null); // Assuming customer and address can be null for this test
        assertEquals("123", account.getAccountId());
        assertEquals(1000.0, account.getBalance(), 0.01);
    }

    private void assertEquals(double d, double balance, double e) {
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }

    private void assertEquals(String string, String accountId) {
        throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
    }

    @Test
    void testDeposit() {
        Account account = new Account(1000.0, null);
        account.deposit(200.0);
        assertEquals(1200.0, account.getBalance(), 0.01);
    }

    @Test
    void testWithdraw() {
        Account account = new Account(1000.0, null);
        account.withdraw(200.0);
        assertEquals(800.0, account.getBalance(), 0.01);
    }

    @Test
    void testCompareTo() {
        Account account1 = new Account(1000.0, null);
        Account account2 = new Account(1500.0, null);
        
        // Assuming account2 was created after account1 and therefore has a "later" LocalDateTime.
        // This might need adjusting depending on how you handle creation dates in your Account constructor.
        
        assertTrue(account1.compareTo(account2) < 0); // account1 has lower priority due to earlier creation or lower balance
    }

    private void assertTrue(boolean b) {
        throw new UnsupportedOperationException("Unimplemented method 'assertTrue'");
    }
}