package ep144.entity;

public class ImportedProduct extends Product {
    Double customsFee;

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    @Override
    public String priceTag() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getName());
        sb.append(" $ ");
        sb.append(totalPrice());
        sb.append(" (Customs fee: $ ");
        sb.append(String.format("%.2f", customsFee));
        sb.append(")");

        return sb.toString();
    }

    public Double totalPrice() {
        return getPrice() + customsFee;
    }
}
