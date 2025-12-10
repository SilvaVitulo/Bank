package homework;

import java.math.BigDecimal;
import java.util.List;

public class BankService {
    //Методы:
    //создает новый счет для пользователя:
    public void createAccount(User user, String accountNumber) {
        // Создаем новый банковский счет
        BankAccount newAccount = new BankAccount(accountNumber);
        // Добавляем новый счет пользователю
        user.addAccount(newAccount);
    }

    //переводит средства между счетами (с проверкой на достаточность средств):
    public void transfer(BankAccount source, BankAccount target, BigDecimal amount) {
    // проверяем, достаточно ли средств на источнике
    if (source.getBalance().compareTo(amount) < 0) {
        throw new IllegalStateException("Недостаточно средств на счете для перевода");
    }
    // Осуществляем перевод
    source.withdraw(amount); // снимаем сумму со счета-отправителя
    target.deposit(amount);  // зачисляем сумму на счет-получателя
    }

    //возвращает историю транзакций для указанного счета:
    public List<Transaction> getTransactionHistory(BankAccount account) {
    return account.getTransactions();
    }

    //возвращает общий баланс всех счетов пользователя:
    public BigDecimal getTotalBalance(User user) {
        BigDecimal totalBalance = BigDecimal.ZERO;
        List<BankAccount> accounts = user.getAccounts();
        for (BankAccount account : accounts) {
            totalBalance = totalBalance.add(account.getBalance());
        }
        return totalBalance;
    }
}
