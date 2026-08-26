package my.exercises.ex02;

import my.exercises.ex02.entities.BankAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("12311", "José Fernando");

        account.deposit(123.2);
        account.withdraw(119.2);

        System.out.println(account);
    }
}
