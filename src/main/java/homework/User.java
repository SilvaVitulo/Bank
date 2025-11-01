package homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User {
    //Поля:
    private String id;                    //(String): уникальный идентификатор пользователя.
    private String name;                  //(String): имя пользователя.
    private List<BankAccount> accounts;   //(List<BankAccount>): список счетов пользователя.

    //Методы:
    //добавление нового счета пользователю:
    public void addAccount(String account) {
        Scanner console = new Scanner(System.in);
        System.out.print("Введите имя нового пользователя: ");
        name = console.nextLine();
        name = new String(name);
        System.out.println("Введите ID счёта пользователя: ");
        id = console.nextLine();
        id = new String(id);
        addAccount(account);
        accounts = new ArrayList<>(accounts);
    }

    public void deleteAccount(String account) {

    }

    //возвращает список счетов пользователя:
    public void getAccounts(){
        accounts = new ArrayList<BankAccount>();
    }
}
