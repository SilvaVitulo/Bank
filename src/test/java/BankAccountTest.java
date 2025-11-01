import homework.BankAccount;
import org.junit.Assert;
import org.junit.Test;
import java.math.BigDecimal;

public class BankAccountTest {

    @Test
    public void addingSum() {
        BankAccount bankAccount = new BankAccount();
        BigDecimal bigDecimal;
        bankAccount.deposit(new BigDecimal(10));
        Assert.assertEquals(new BigDecimal(10), bankAccount.getBalance());
    }


    void withdraw() {
    }


    void getBalance() {
    }


    void addTransaction() {
    }
}