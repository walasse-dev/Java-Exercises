package ep147.entity;

public class Company extends Person {
    private int numberOfEmployees;

    public Company(String name, double anualIncome, int numberOfEmployees) {
        super(name, anualIncome);
        this.numberOfEmployees = numberOfEmployees;
    }

    @Override
    public double getTax() {
        double tax = getAnualIncome() * 0.16;

        if (numberOfEmployees > 10) {
            tax = getAnualIncome() * 0.14;
        }

        return tax;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getName()).append(": $ ");
        sb.append(String.format("%.2f", getTax()));

        return sb.toString();
    }
}
