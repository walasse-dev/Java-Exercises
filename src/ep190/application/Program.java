package ep190.problem1.application;

import ep190.problem1.entities.Circle;
import ep190.problem1.entities.Rectangle;
import ep190.problem1.entities.Shape;

import java.util.ArrayList;
import java.util.List;

public class Program {
    public static void main(String[] args) {
        List<Shape> figures = new ArrayList<>();
        figures.add(new Rectangle(3.0, 2.0));
        figures.add(new Circle(2.0));

        List<Circle> circles = new ArrayList<>();
        circles.add(new Circle(3.0));
        circles.add(new Circle(2.0));

        System.out.println("Total area: " + totalArea(figures));
        System.out.println("Total area of circles: " + totalArea(circles));
    }

    public static double totalArea(List<? extends Shape> list) {
        if (list.isEmpty()) {
            return 0;
        }

        double sum = 0;

        for (Shape figure : list) {
            sum += figure.area();
        }

        return sum;
    }
}
