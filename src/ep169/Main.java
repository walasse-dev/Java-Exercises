package ep169;

import ep169.entity.Product;

import java.io.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        String path = "/home/walasse/Documents/input.csv";
        String summaryDir = "/home/walasse/Documents/out/";

        new File(summaryDir).mkdir();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] fields = line.split(",");

                if (fields.length < 3) {
                    System.out.println("Linha inválida ignorada: " + line);
                    continue;
                }

                try {
                    String name = fields[0].trim();
                    BigDecimal price = new BigDecimal(fields[1].trim());
                    int quantity = Integer.parseInt(fields[2].trim());

                    products.add(new Product(name, price, quantity));
                } catch (NumberFormatException e) {
                    System.out.println("Erro ao converter dados da linha: " + line);
                }
            }

            try (BufferedWriter bw = new BufferedWriter(new FileWriter(summaryDir + "summary.csv"))) {
                for (Product product : products) {
                    bw.write(product.toString());
                    bw.newLine();
                }
                System.out.println("Arquivo de sumário gerado com sucesso!");
            }

        } catch (IOException e) {
            System.out.println("Erro na manipulação de arquivos: " + e.getMessage());
        }
    }
}