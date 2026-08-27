package ep210.application;

import ep210.entities.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Program {
    public static void main(String[] args) {
        String path = "src/ep210/input.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();
            List<Product> products = new ArrayList<>();

            while (line != null) {
                String[] fields = line.split(",");
                products.add(new Product(fields[0], Double.parseDouble(fields[1])));
                line = br.readLine();
            }

            double avg = products.stream()
                            .collect(Collectors.averagingDouble(Product::getPrice));

            System.out.println("Average price: " + avg);
            products.stream()
                    .filter(p -> p.getPrice() >= avg)
                    .forEach(p -> System.out.println(p.getName()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
