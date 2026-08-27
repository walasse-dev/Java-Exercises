package ep207.application;

import ep207.entities.Product;
import ep207.model.services.ProductService;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.50));
        list.add(new Product("HD Case", 80.90));

        ProductService ps = new ProductService();

        double v = ps.filteredSum(list, p -> p.getName().charAt(0) == 'T');

        System.out.printf("%.2f",v);
    }
}
