package homework;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class BankAccount {
    //Поля:
    private String accountNumber;             //(String): уникальный номер счета.
    private BigDecimal balance;               //(BigDecimal): текущий баланс счета.
    private User owner;                       //(User): владелец счета.
    private List<Transaction> transactions;   //(List<Transaction>): история транзакций.


    //Методы:
    //- пополнение счета:
    public void deposit(BigDecimal amount){
        Scanner console = new Scanner(System.in);
        System.out.print("Введите сумму пополнения: ");
        amount = console.nextBigDecimal();
        balance = amount;
    }




    //- снятие средств со счета (с проверкой на достаточность средств):
    public void withdraw(BigDecimal amount){
        balance = balance.subtract(amount);
    }

    //возвращает текущий баланс:
    public BigDecimal getBalance(){
        return balance;
    }

    //добавляет транзакцию в историю:
    public void addTransaction(Transaction transaction){
        transactions.add(transaction);
    }
}
