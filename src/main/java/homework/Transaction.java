package homework;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    //Поля:
    private String id;                   //(String): уникальный идентификатор транзакции.
    private BigDecimal amount;           //(BigDecimal): сумма транзакции.
    private String type;                 //(String): тип транзакции (`DEPOSIT`, `WITHDRAWAL`, `TRANSFER`).
    private LocalDateTime date;          //(LocalDateTime): дата выполнения транзакции.
    private BankAccount sourceAccount;   //(BankAccount): источник транзакции (если применимо).
    private BankAccount targetAccount;   //(BankAccount): получатель транзакции (если применимо).


    //Методы:
    //- Конструктор для создания транзакции.

}
