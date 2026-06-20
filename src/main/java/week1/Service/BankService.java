package week1.Service;

import week1.Entity.BankAccount;
import week1.Entity.Transaction;
import week1.Entity.User;
import week1.Enum.TransactionType;

import java.math.BigDecimal;
import java.util.List;

public class BankService {
    public BankAccount createAccount(User user, String accountNumber) {
        BankAccount bankAccount = new BankAccount(user, accountNumber);
        user.addAccount(bankAccount);

        return bankAccount;
    }

    public void deposit(
            BankAccount account,
            BigDecimal amount
    ) {
        try {
            account.deposit(amount);

            Transaction transaction = new Transaction(
                    amount,
                    TransactionType.DEPOSIT,
                    null,
                    null
            );
            account.addTransaction(transaction);
        } catch (Exception e) {
            System.out.println(e.getMessage() + ". Транзакция отменена");
        }
    }

    public void withdraw(
            BankAccount account,
            BigDecimal amount
    ) {
        try {
            account.withdraw(amount);

            Transaction transaction = new Transaction(
                    amount,
                    TransactionType.WITHDRAWAL,
                    null,
                    null
            );
            account.addTransaction(transaction);
        } catch (Exception e) {
            System.out.println(e.getMessage() + ". Транзакция отменена");
        }
    }

    public void transfer(
            BankAccount source,
            BankAccount target,
            BigDecimal amount
    ) {
        try {
            source.withdraw(amount);
            target.deposit(amount);

            Transaction transaction = new Transaction(
                    amount,
                    TransactionType.TRANSFER,
                    source,
                    target
            );
            source.addTransaction(transaction);
            target.addTransaction(transaction);
        } catch (Exception e) {
            System.out.println(e.getMessage() + ". Транзакция отменена");
        }
    }

    public List<Transaction> getTransactionHistory(BankAccount account) {
        return account.getTransactions();
    }

    public BigDecimal getTotalBalance(User user) {
        if (user == null || user.getAccounts() == null) {
            return BigDecimal.ZERO;
        }

        BigDecimal total = BigDecimal.ZERO;
        for (BankAccount account : user.getAccounts()) {
            total = total.add(account.getBalance());
        }

        return total;
    }
}
