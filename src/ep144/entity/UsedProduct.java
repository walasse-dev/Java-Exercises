package ep144.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UsedProduct extends Product {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
    Date manufactureDate;

    public UsedProduct(String name, Double price, Date manufactureDate) {
        super(name, price);
        this.manufactureDate = new Date();
        this.manufactureDate = manufactureDate;
    }

    @Override
    public String priceTag() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.getName());
        sb.append(" (used) $ ");
        sb.append(String.format("%.2f", super.getPrice()));
        sb.append(" (Manufacture date: ");
        sb.append(sdf.format(manufactureDate));

        return sb.toString();
    }
}
