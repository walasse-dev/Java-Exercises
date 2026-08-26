package ep143.entity;

public class Employee {
    private String name;
    private Integer hours;
    private Double valuePerHour;

    public Employee(String name, Integer hours, Double valuePerHour) {
        this.name = name;
        this.hours = hours;
        this.valuePerHour = valuePerHour;
    }

    public Double payment() {
        return valuePerHour * hours;
    }

    @Override
    public String toString() {
        return String.format("%s - $%.2f", name, payment());
    }
}
