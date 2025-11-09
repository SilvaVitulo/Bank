package homework;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class BankAccount {
    //Поля:
    private String accountNumber;             //(String): уникальный номер счета.
    private BigDecimal balance;               //(BigDecimal): текущий баланс счета.
    private User owner;                       //(User): владелец счета.
    private List<Transaction> transactions;   //(List<Transaction>): история транзакций.


    //Методы:
    //- пополнение счета:
    public void deposit(BigDecimal amount) {
//        Scanner console = new Scanner(System.in);
//        System.out.print("Введите сумму пополнения: ");
//        amount = console.nextBigDecimal();
        balance = amount;
        balance = balance.add(amount);
    }

    //- снятие средств со счета (с проверкой на достаточность средств):
    public void withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) >= 0) {
            balance = balance.subtract(amount);
        } else {
            System.out.println("Баланс недостаточен для снятия со счёта! (уменьшите сумму или внесите деньги на счёт)");
        }
    }

    //возвращает текущий баланс:
    public BigDecimal getBalance() {
        return balance;
    }

    //добавляет транзакцию в историю:
    public List<Transaction> addTransaction(Transaction transaction) {
//        Transaction transaction1 = new Transaction(String id, BigDecimal amount, String type, LocalDateTime date, BankAccount sourceAccount, BankAccount targetAccount);
        transactions.add(transaction);
        return List.of();
    }
}
