package homework;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    @DisplayName("Тест проверки добавления аккаунта")
    public void testAddAccount() {
        //Arrange
        User user = new User("U123", "Bob");
        BankAccount bankAccount = new BankAccount();
        //Act
        user.addAccount(bankAccount);
        //Assert
        assertEquals(1, user.getAccounts().size());
    }

    @Test
    @DisplayName("Тест проверки удаления аккаунта")
    public void testDeleteAccount() {
        //Arrange
        User user = new User("U123", "Bob");
        BankAccount bankAccount = new BankAccount();
        //Act
        user.addAccount(bankAccount);
        user.deleteAccount(bankAccount);
        //Assert
        assertEquals(0, user.getAccounts().size());
    }

    @Test
    @DisplayName("Тест проверки запроса аккаунта")
    public void testGetAccounts() {
        //Arrange
        User user = new User("U123", "Bob");
        BankAccount bankAccount = new BankAccount();
        //Act
        user.addAccount(bankAccount);
        //Assert
        assertEquals(1, user.getAccounts().size());
    }
}