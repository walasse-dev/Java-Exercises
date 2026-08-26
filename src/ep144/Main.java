package ep144;

import ep144.entity.ImportedProduct;
import ep144.entity.Product;
import ep144.entity.UsedProduct;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Scanner sc = new Scanner(System.in);
        List<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            System.out.print("Product #" + (i + 1) + " data: \n");
            System.out.print("Common, used or imported (c/u/i)? ");
            char type = sc.nextLine().toLowerCase().charAt(0);

            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Price: ");
            Double price = Double.parseDouble(sc.nextLine());
            
            if (type == 'c') {
              products.add(new Product(name, price));
            } else if (type == 'u') {
                System.out.print("Manufactured date (DD/MM/YYYY): ");
                Date date = sdf.parse(sc.nextLine());
                products.add(new UsedProduct(name, price, date));
            } else if (type == 'i') {
                System.out.print("Customs fee: ");
                Double fee = Double.parseDouble(sc.nextLine());
                products.add(new ImportedProduct(name, price, fee));
            }
        }

        System.out.println("PRICE TAGS:");
        for (Product p : products) {
            System.out.println(p.priceTag());
        }

    }
}
