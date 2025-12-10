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
        LocalDateTime date = LocalDateTime.of(2020, 1, 1, 1, 1);
        BankAccount sourceAccount = new BankAccount(id);
        BankAccount targetAccount = new BankAccount(id);

        Transaction transaction = new Transaction(id, amount, type, date, sourceAccount, targetAccount);

        // Проверяем, что поля установлены корректно
        assertEquals(id, transaction.getId()); // проверяем идентификатор
        assertEquals(amount, transaction.getAmount()); // проверяем сумму
        assertEquals(type, transaction.getType()); // проверяем тип транзакции
        assertEquals(date, transaction.getDate()); // проверяем дату
        assertEquals(sourceAccount, transaction.getSourceAccount()); // проверяем источник
        assertEquals(targetAccount, transaction.getTargetAccount()); // проверяем адресата
    }
}
