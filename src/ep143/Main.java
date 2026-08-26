package ep143;

import ep143.entity.Employee;
import ep143.entity.OutsourcedEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        System.out.print("Enter the number of employees: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.printf("Employee #%d data:\n", i);
            System.out.print("Outsourced (y/n)? ");
            char isOutsourced = sc.nextLine().toLowerCase().charAt(0);
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Hours: ");
            Integer hours = Integer.parseInt(sc.nextLine());
            System.out.print("Value per hour: ");
            double valuerPerHour = Double.parseDouble(sc.nextLine());

            if (isOutsourced == 'n') {
                employees.add(new Employee(name, hours, valuerPerHour));
            } else if (isOutsourced == 'y') {
                System.out.print("Additional charge: ");
                double additionalCharge = Double.parseDouble(sc.nextLine());
                employees.add(new OutsourcedEmployee(name, hours, valuerPerHour, additionalCharge));
            }
        }

        System.out.println("Payments: ");
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }

    }
}
