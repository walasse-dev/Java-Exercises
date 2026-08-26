package ep159;

import ep159.exception.DomainException;
import ep159.entity.Account;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("Enter account data:");
            System.out.print("Number: ");
            int number = Integer.parseInt(sc.nextLine());
            System.out.print("Holder: ");
            String holder = sc.nextLine();
            System.out.print("Initial balance: ");
            double balance = Double.parseDouble(sc.nextLine());
            System.out.print("Withdraw limit: ");
            double withdrawLimit = Double.parseDouble(sc.nextLine());

            Account account = new Account(number, holder, balance, withdrawLimit);

            System.out.print("\nEnter amount for withdraw: ");
            double amount = Double.parseDouble(sc.nextLine());
            account.withdraw(amount);
            System.out.printf("New balance: %.2f\n", account.getBalance());
        } catch (NumberFormatException e) {
            System.out.println("Input error: " + e.getMessage());
        } catch (DomainException e) {
            System.out.println("Withdraw error: " + e.getMessage());
        }
    }
}