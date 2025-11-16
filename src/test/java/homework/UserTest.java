package homework;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    public void addAccount() {
        User user = new User("U123", "Bob");
        addAccount();
        assertEquals(1, user.getAccounts().size());
    }

//    @Test
//    public void deleteAccount() {
//        User user = new User("U123", "Bob");
//        deleteAccount();
//        assertEquals(0, user.getAccounts().size());
//    }

//    @Test
//    public void getAccounts() {
//        User user = new User("U123", "Bob");
//        assertEquals(1, user.getAccounts().size());
//    }
}