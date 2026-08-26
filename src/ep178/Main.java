package ep178;

import ep178.entity.Contract;
import ep178.entity.Installment;
import ep178.entity.PaypalService;
import ep178.interfaces.ContractService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Entre com os dados do contrato");

        System.out.print("Número: ");
        int number = Integer.parseInt(sc.nextLine());
        System.out.print("Data (dd/MM/yyyy): ");
        LocalDate date = LocalDate.parse(sc.nextLine(), dtf);
        System.out.print("Valor do contrato: ");
        double value = Double.parseDouble(sc.nextLine());
        Contract contract = new Contract(number, date, value);

        System.out.print("Entre com o número de parcelas: ");
        int installments = Integer.parseInt(sc.nextLine());

        ContractService service = new ContractService(new  PaypalService());
        service.processContract(contract, installments);

        System.out.println("Parcelas:");
        for (Installment installment : contract.getInstallments()) {
            System.out.println(installment);
        }
    }
}
