package week1.Entity;

import week1.Enum.TransactionType;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Transaction {
    private final String id;
    private final BigDecimal amount;
    private final TransactionType type;
    private final LocalDateTime date;
    private final BankAccount sourceAccount;
    private final BankAccount targetAccount ;

    private static int idCounter = 1;

    public Transaction(
            BigDecimal amount,
            TransactionType type,
            BankAccount sourceAccount,
            BankAccount targetAccount
    ) {
        this.id = String.valueOf(idCounter++);
        this.amount = amount;
        this.type = type;
        this.date = LocalDateTime.now();
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
    }

    public String getId() {
        return id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public TransactionType getType() {
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

    @Override
    public String toString() {
        return "Entity.Transaction{" +
                "id='" + id + '\'' +
                ", amount=" + amount +
                ", type=" + type +
                ", date=" + date +
                ", sourceAccount=" + sourceAccount +
                ", targetAccount=" + targetAccount +
                '}';
    }
}
