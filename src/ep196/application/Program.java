package ep196.application;

import ep196.entities.Student;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Student> students = new HashSet<>();

        System.out.print("How many students for course A? ");
        int courseA = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < courseA; i++) {
            int id = Integer.parseInt(sc.nextLine());
            students.add(new Student(id));
        }

        System.out.print("How many students for course B? ");
        int courseB = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < courseB; i++) {
            int id = Integer.parseInt(sc.nextLine());
            students.add(new Student(id));
        }

        System.out.print("How many students for course C? ");
        int courseC = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < courseC; i++) {
            int id = Integer.parseInt(sc.nextLine());
            students.add(new Student(id));
        }

        System.out.println("Total students: " + students.size());
    }
}
