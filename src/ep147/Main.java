package ep147;

import ep147.entity.Company;
import ep147.entity.Individual;
import ep147.entity.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Person> peoples = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        int n = Integer.parseInt(input.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.printf("Tax payer #%d data: \n", i + 1);

            System.out.print("Individual or Company (i/c)? ");
            char s = input.nextLine().toLowerCase().charAt(0);

            System.out.print("Name: ");
            String name = input.nextLine();
            System.out.print("Anual income: ");
            double anualIncome = Double.parseDouble(input.nextLine());

            if (s == 'i') {
                System.out.print("Health expenditures: ");
                double healthExpenditures = Double.parseDouble(input.nextLine());
                peoples.add(new Individual(name, anualIncome, healthExpenditures));
            } else  {
                System.out.print("Number of employees: ");
                int numberOfEmployees = Integer.parseInt(input.nextLine());
                peoples.add(new Company(name, anualIncome, numberOfEmployees));
            }
        }

        double tax = 0.0;
        System.out.println("TAXES PAID:");
        for (Person person : peoples) {
            tax += person.getTax();
            System.out.println(person);
        }

        System.out.printf("\nTOTAL TAXES: $ %.2f", tax);


    }
}
