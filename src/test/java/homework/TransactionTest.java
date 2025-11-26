package homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class TransactionTest {

    @Test
    @DisplayName("Тест транзакции депозит")
    void testTransactionDeposit() {
        String id = "Q123";
        BigDecimal amount = new BigDecimal("100.00");
        String type = "DEPOSIT";
        LocalDateTime date = LocalDateTime.now();
        BankAccount sourceAccount = new BankAccount("account1");
        BankAccount targetAccount = new BankAccount("account2");
    }
}