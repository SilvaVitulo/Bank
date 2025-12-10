package homework;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    //Поля:
    private final String id;                   //(String): уникальный идентификатор транзакции.
    private final BigDecimal amount;           //(BigDecimal): сумма транзакции.
    private final String type;                 //(String): тип транзакции (`DEPOSIT`, `WITHDRAWAL`, `TRANSFER`).
    private final LocalDateTime date;          //(LocalDateTime): дата выполнения транзакции.
    private final BankAccount sourceAccount;   //(BankAccount): источник транзакции (если применимо).
    private final BankAccount targetAccount;   //(BankAccount): получатель транзакции (если применимо).


    //Методы:
    //- Конструктор для создания транзакции с проверкой на валидные значения в полях.
    public Transaction(String id, BigDecimal amount, String type, LocalDateTime date, BankAccount sourceAccount, BankAccount targetAccount) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("ID транзакции не может быть пустым");
        }

        if (type == null || !type.matches("^(DEPOSIT|WITHDRAWAL|TRANSFER)$")) {
            throw new IllegalArgumentException("Невалидный тип транзакции");
        }

        if (amount == null || amount.signum() <= 0) {
            throw new IllegalArgumentException("Сумма транзакции должна быть положительным числом");
        }

        if (date == null) {
            throw new IllegalArgumentException("Дата транзакции не может быть пустой");
        }

        this.id = id;
        this.amount = amount;
        this.type = type;
        this.date = date;
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public BankAccount getSourceAccount() {
        return sourceAccount;
    }

    public BankAccount getTargetAccount() {
        return targetAccount;
    }
}
