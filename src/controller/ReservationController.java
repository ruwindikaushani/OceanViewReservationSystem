package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

import model.Reservation;
import service.ReservationService;

public class ReservationController {

    private final ReservationService service;
    private final DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    public ReservationController(ReservationService service) {
        this.service = service;
    }

    public void addReservation(Scanner sc) {

        System.out.print("Reservation No: ");
        String no = sc.nextLine().trim();

        System.out.print("Guest Name: ");
        String name = sc.nextLine().trim();

        System.out.print("Address: ");
        String address = sc.nextLine().trim();

        System.out.print("Contact No: ");
        String contact = sc.nextLine().trim();

        System.out.print("Room Type (single/double/deluxe): ");
        String type = sc.nextLine().trim();

        LocalDate checkIn = readDate(sc, "Check-in Date (yyyy-MM-dd): ");
        LocalDate checkOut;

        while (true) {
            checkOut = readDate(sc, "Check-out Date (yyyy-MM-dd): ");
            if (checkOut.isAfter(checkIn)) break;
            System.out.println("❌ Check-out must be AFTER check-in. Try again.");
        }

        Reservation r = new Reservation(no, name, address, contact, type, checkIn, checkOut);
        service.addReservation(r);

        System.out.println("✅ Reservation Added! Nights = " + r.getNights());
    }

    public void displayReservation(Scanner sc) {

        System.out.print("Enter Reservation No: ");
        String no = sc.nextLine().trim();

        Reservation r = service.findReservation(no);

        if (r == null) {
            System.out.println("❌ Reservation not found.");
            return;
        }

        System.out.println("\n===== Reservation Details =====");
        System.out.println("Reservation No : " + r.getReservationNo());
        System.out.println("Guest Name     : " + r.getGuestName());
        System.out.println("Address        : " + r.getAddress());
        System.out.println("Contact No     : " + r.getContactNo());
        System.out.println("Room Type      : " + r.getRoomType());
        System.out.println("Check-in       : " + r.getCheckIn());
        System.out.println("Check-out      : " + r.getCheckOut());
        System.out.println("Nights         : " + r.getNights());
        System.out.println("===============================");
    }

    private LocalDate readDate(Scanner sc, String label) {
        while (true) {
            System.out.print(label);
            String input = sc.nextLine().trim();
            try {
                return LocalDate.parse(input, fmt);
            } catch (DateTimeParseException e) {
                System.out.println("❌ Invalid date format. Use yyyy-MM-dd (ex: 2026-02-22)");
            }
        }
    }
}
