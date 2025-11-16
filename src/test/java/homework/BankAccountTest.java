package homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    @Test
    @DisplayName("Тест проверки пополнения счёта")
    public void testAddingSum() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(new BigDecimal("10"));
        assertEquals(new BigDecimal("10"), bankAccount.getBalance());
    }

    @Test
    @DisplayName("Тест проверки успешного вывода средств")
    public void testWithdrawSuccess() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(new BigDecimal("50"));
        bankAccount.withdraw(new BigDecimal("25"));
        assertEquals(new BigDecimal("25"), bankAccount.getBalance());
    }

    @Test
    @DisplayName("Тест проверки вывода средств больше чем есть на депозите")
    public void testWithdrawFailure() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(new BigDecimal("50"));
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(new BigDecimal("100")));
    }

    @Test
    @DisplayName("Тест проверки запроса средств на балансе")
    public void testGetBalance() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(new BigDecimal("10"));
        assertEquals(new BigDecimal("10"), bankAccount.getBalance());
    }

    @Test
    @DisplayName("Тест проверки что транзакция корректно сохраняется в истории и баланс не меняется")
    public void testAddTransaction() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(new BigDecimal("50"));
        Transaction transaction = new Transaction(3, new BigDecimal("50"), "DEPOSIT", 20000120, "account1", "account2");
        bankAccount.addTransaction(transaction);
        assertEquals("Баланс увеличен на сумму 50", new BigDecimal("50"), bankAccount.getBalance());
        List<Transaction> transactions = bankAccount.getTransactions();
        assertEquals("В истории должна быть 1 транзакция", 1, transactions.size());
    }
}