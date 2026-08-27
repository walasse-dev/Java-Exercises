package ep211.application;

import ep211.entities.Employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        String path = "src/ep211/input.txt";
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();

            while (line != null) {
                String[] fields = line.split(",");
                employees.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
                line = br.readLine();
            }

            Comparator<String> comparator = (x, y) -> x.toUpperCase().compareTo(y.toUpperCase());

            System.out.println("Email of people whose salary is more than 2000.00:");
            employees.stream()
                    .filter(e -> e.getSalary() > 2000.00)
                    .map(Employee::getEmail)
                    .sorted(comparator)
                    .forEach(System.out::println);

            double sum = employees.stream()
                    .filter(e -> e.getName().toUpperCase().charAt(0) == 'M').mapToDouble(Employee::getSalary).sum();
            System.out.println("Sum of salary of people whose name starts with 'M': " + sum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
