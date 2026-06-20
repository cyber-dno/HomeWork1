package week1;

import week1.Entity.BankAccount;
import week1.Entity.User;
import week1.Service.BankService;

import java.math.BigDecimal;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Создаем пользователя
        User user = new User("user1", "John Doe");

        // Создаем сервис
        BankService bankService = new BankService();

        // Создаем счета
        bankService.createAccount(user, "ACC123");
        bankService.createAccount(user, "ACC456");

        // Получаем счета пользователя
        List<BankAccount> accounts = user.getAccounts();
        BankAccount acc1 = accounts.get(0);
        BankAccount acc2 = accounts.get(1);

        // Пополняем первый счет
        bankService.deposit(acc1, new BigDecimal("1000"));

        // Снимаем средства со счёта
        bankService.withdraw(acc1, new BigDecimal("100"));

        // Переводим средства между счетами
        bankService.transfer(acc1, acc2, new BigDecimal("500"));

        // Выводим балансы
        System.out.println("Balance of ACC123: " + acc1.getBalance());
        System.out.println("Balance of ACC456: " + acc2.getBalance());
        System.out.println("Total balance: " + bankService.getTotalBalance(user));

        // Выводим историю транзакций
        System.out.println("Entity.Transaction history for ACC123:");
        bankService.getTransactionHistory(acc1).forEach(System.out::println);
    }
}
