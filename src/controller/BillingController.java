package controller;

import java.util.Scanner;
import model.Reservation;
import service.BillingService;
import service.ReservationService;

public class BillingController {
    private final ReservationService reservationService;
    private final BillingService billingService;

    public BillingController(ReservationService reservationService, BillingService billingService) {
        this.reservationService = reservationService;
        this.billingService = billingService;
    }

    public void printBill(Scanner sc) {
        System.out.print("Enter Reservation No: ");
        String no = sc.nextLine();

        Reservation r = reservationService.findReservation(no);

        if (r == null) {
            System.out.println("Reservation not found.");
            return;
        }

        double total = billingService.calculateTotal(r);

        System.out.println("\n===== BILL =====");
        System.out.println("Guest : " + r.getGuestName());
        System.out.println("Room  : " + r.getRoomType());
        System.out.println("Check-in : " + r.getCheckIn());
        System.out.println("Check-out: " + r.getCheckOut());
        System.out.println("Nights   : " + r.getNights());
        System.out.println("Total : LKR " + total);
        System.out.println("===============");
    }
}
