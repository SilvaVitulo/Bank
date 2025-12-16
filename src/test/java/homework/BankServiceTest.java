package homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BankServiceTest {

    @Test
    @DisplayName("Тест создания нового счета")
    public void testCreateAccount() {
        //Arrange
        User user = new User("U123", "Bob");
        String accountNumber = "acc123";
        String accountNumber1 = "bcc123";
        BankAccount source = new BankAccount(accountNumber, user);
        BankAccount target = new BankAccount(accountNumber1, user);
        BigDecimal amount = new BigDecimal("100.00");
        //Act
        BankService service = new BankService();
        service.createAccount(user, accountNumber);
        source.deposit(amount);
        service.transfer(source, target, amount);
        //Assert
        List<BankAccount> accounts = user.getAccounts();
        assertEquals(1, accounts.size()); // Проверяем, что счет добавился
        assertEquals(accountNumber, accounts.get(0).getAccountNumber()); // Проверяем номер счета
        assertEquals(amount, accounts.get(0).getBalance());
        assertEquals(amount, accounts.get(0).getBalance());
    }

//    @Test
//    void transfer() {
//    }
//
//    @Test
//    @DisplayName("Тест получения истории транзакций")
//    public void testGetTransactionHistory() {
//        //Arrange
//        BankAccount account = new BankAccount("ACC-123");
//        account.deposit(new BigDecimal("100"));
//        account.withdraw(new BigDecimal("50"));
//        //Act
//        BankService service = null;
//        List<Transaction> history = service.getTransactionHistory(account);
//        //Assert
//        assertEquals(2, history.size()); // Было выполнено две транзакции
//    }
//
//    @Test
//    void getTotalBalance() {
//    }
}