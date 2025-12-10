package homework;

import java.util.ArrayList;
import java.util.List;

public class User {
    //Поля:
    private String id;                    //(String): уникальный идентификатор пользователя.
    private String name;                  //(String): имя пользователя.
    private List<BankAccount> accounts;   //(List<BankAccount>): список счетов пользователя.

    //Конструктор:
    public User(String id, String name){
        this.id = id;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    //Методы:
    //добавление нового счета пользователю:
    public void addAccount(BankAccount newAccount) {
        accounts.add(newAccount);
    }

    //возвращает список счетов пользователя:
    public List<BankAccount> getAccounts(){
        return accounts; //возврат текущего списка счетов
    }

    //удаление пользователя
    public void deleteAccount(BankAccount account) {
        accounts.remove(account);
    }
}
