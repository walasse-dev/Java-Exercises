package my.exercises.ex02.entities;

import my.exercises.ex02.exception.InsufficientBalanceException;

public class BankAccount {
    private String accountNumber;
    private String holder;
    private double balance;

    public BankAccount(String accountNumber, String holder) {
        this.accountNumber = accountNumber;
        this.holder = holder;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientBalanceException {
        if (balance < amount + 5.00) {
            throw new InsufficientBalanceException("Saldo insuficiente para saque + taxa");
        }
        balance -= amount + 5.00;
    }

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "\naccountNumber='" + accountNumber + '\'' +
                ",\nholder='" + holder + '\'' +
                ",\nbalance=" + balance +
                "\n}";
    }
}
