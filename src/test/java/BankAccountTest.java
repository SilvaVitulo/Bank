import homework.BankAccount;
import homework.Transaction;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BankAccountTest {

    @Test       //проверка пополнения счёта
    public void testAddingSum() {
        BankAccount bankAccount = new BankAccount();
//        BigDecimal bigDecimal;
        bankAccount.deposit(new BigDecimal("10"));
        assertEquals(new BigDecimal("10"), bankAccount.getBalance());
    }

    @Test       //проверка успешного вывода средств
    public void testWithdrawSuccess() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(new BigDecimal("50"));
        bankAccount.withdraw(new BigDecimal("25"));
        assertEquals(new BigDecimal("25"), bankAccount.getBalance());
    }

    @Test(expected = IllegalArgumentException.class)       //проверка вывода средств больше чем есть на депозите
    public void testWithdrawFailure() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(new BigDecimal("50"));
        bankAccount.withdraw(new BigDecimal("100"));
    }

    @Test       //проверка запроса средств на балансе
    public void testGetBalance() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(new BigDecimal("10"));
        assertEquals(new BigDecimal("10"), bankAccount.getBalance());
    }

    @Test       //проверка добавления транзакции в историю
    public void testAddTransaction() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(new BigDecimal("50"));
        Transaction transaction = new Transaction("3", "50", "DEPOSIT", 20000120, "account1", "account2");
        bankAccount.addTransaction(transaction);
        assertEquals(new BigDecimal("50"), bankAccount.getBalance());
        List<Transaction> transactions = bankAccount.addTransaction(transaction);
        assertEquals(1, transactions.size());
    }
}