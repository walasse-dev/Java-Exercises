package ep147.entity;

public class Individual extends Person {
    private double healthExpenditures;

    public Individual(String name, double anualIncome,  double healthExpenditures) {
        super(name, anualIncome);
        this.healthExpenditures = healthExpenditures;
    }

    @Override
    public double getTax() {
        double tax = getAnualIncome() * 0.15;

        if (getAnualIncome() >= 20000.00) {
            tax = getAnualIncome() * 0.25;
        }

        if (healthExpenditures > 0.0) {
            tax -= healthExpenditures / 2;
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
