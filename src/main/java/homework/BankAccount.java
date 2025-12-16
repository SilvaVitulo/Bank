package homework;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    //Поля:
    private String accountNumber;             //(String): уникальный номер счета.
    private BigDecimal balance = BigDecimal.ZERO;  //(BigDecimal): текущий баланс счета.
    private User owner;                       //(User): владелец счета.
    private List<Transaction> transactions = new ArrayList<>();   //(List<Transaction>): история транзакций.

    public BankAccount(String accountNumber, User owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
    }

    public BankAccount(){
    }


    //Методы:
    //- пополнение счета:
    public void deposit(BigDecimal amount) {
        balance = balance.add(amount);
    }

    //- снятие средств со счета (с проверкой на достаточность средств):
    public void withdraw(BigDecimal amount) {
        if (balance.compareTo(amount) < 0) {
            throw new IllegalArgumentException("Баланс недостаточен для снятия со счёта! (уменьшите сумму или внесите деньги на счёт)");
        }
        balance = balance.subtract(amount);
    }

    //возвращает текущий баланс:
    public BigDecimal getBalance() {
        return balance;
    }

    //добавляет транзакцию в историю:
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    //возвращаем транзакцию:
    public List<Transaction> getTransactions(){
        return transactions;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public User getOwner() {
        return owner;
    }
}
