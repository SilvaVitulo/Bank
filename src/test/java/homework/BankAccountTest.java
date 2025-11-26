package homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BankAccountTest {

    @Test
    @DisplayName("Тест проверки пополнения счёта")
    public void testAddingSum() {
        //Arrange
        BankAccount bankAccount = new BankAccount("account1");
        bankAccount.deposit(new BigDecimal("10"));
        //Assert
        assertEquals(new BigDecimal("10"), bankAccount.getBalance());
    }

    @Test
    @DisplayName("Тест проверки успешного вывода средств")
    public void testWithdrawSuccess() {
        //Arrange
        BankAccount bankAccount = new BankAccount("account1");
        bankAccount.deposit(new BigDecimal("50"));
        //Act
        bankAccount.withdraw(new BigDecimal("25"));
        //Assert
        assertEquals(new BigDecimal("25"), bankAccount.getBalance());
    }

    @Test
    @DisplayName("Тест проверки вывода средств больше чем есть на депозите")
    public void testWithdrawFailure() {
        //Arrange
        BankAccount bankAccount = new BankAccount("account1");
        bankAccount.deposit(new BigDecimal("50"));
        //Assert
        assertThrows(IllegalArgumentException.class, () -> bankAccount.withdraw(new BigDecimal("100")));
    }

    @Test
    @DisplayName("Тест проверки запроса средств на балансе")
    public void testGetBalance() {
        //Arrange
        BankAccount bankAccount = new BankAccount("account1");
        bankAccount.deposit(new BigDecimal("10"));
        //Assert
        assertEquals(new BigDecimal("10"), bankAccount.getBalance());
    }

    @Test
    @DisplayName("Тест проверки что транзакция корректно сохраняется в истории и баланс не меняется")
    public void testAddTransaction() {
        //Arrange
        BankAccount bankAccount = new BankAccount("account1");
        bankAccount.deposit(new BigDecimal("50"));
        //Act
        Transaction transaction = new Transaction("3", new BigDecimal("50"), "DEPOSIT", LocalDateTime.of(2000,12,1,23,1), new BankAccount("account1"), new BankAccount("account2"));
        bankAccount.addTransaction(transaction);
        //Assert
        assertEquals("Баланс увеличен на сумму 50", new BigDecimal("50"), bankAccount.getBalance());
        List<Transaction> transactions = bankAccount.getTransactions();
        assertEquals("В истории должна быть 1 транзакция", 1, transactions.size());
    }
}
