package ep155;

import ep155.entity.Reservation;
import ep155.exception.DomainException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            System.out.print("Room number: ");
            int roomNumber = Integer.parseInt(sc.nextLine());

            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date checkInDate = sdf.parse(sc.nextLine());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date checkOutDate = sdf.parse(sc.nextLine());
            Reservation reservation = new Reservation(roomNumber, checkInDate, checkOutDate);
            System.out.println(reservation);

            System.out.println("\nEnter data to update the reservation:");
            System.out.print("Check-in date (dd/MM/yyyy): ");
            Date newCheckInDate = sdf.parse(sc.nextLine());
            System.out.print("Check-out date (dd/MM/yyyy): ");
            Date newCheckOutDate = sdf.parse(sc.nextLine());
            reservation.updateDates(newCheckInDate, newCheckOutDate);
            System.out.println(reservation);
        } catch (ParseException e) {
            System.out.println("Invalid date entered.");
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Invalid room number entered.");
        } catch (RuntimeException e) {
            System.out.println("Unexpected error occured.");
        }

        sc.close();
    }
}
