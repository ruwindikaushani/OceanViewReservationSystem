package controller;
import service.DatabaseConnection;
import java.sql.Connection;
import java.util.Scanner;

import service.UserService;
import service.ReservationService;
import service.BillingService;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // -------- SHARED SERVICES --------
        UserService userService = new UserService();
        ReservationService reservationService = new ReservationService();
        BillingService billingService = new BillingService();

        // -------- CONTROLLERS --------
        AuthController authController =
                new AuthController(userService);

        ReservationController reservationController =
                new ReservationController(reservationService);

        BillingController billingController =
                new BillingController(reservationService, billingService);

        HelpController helpController = new HelpController();
        ExitController exitController = new ExitController();

            try (Connection conn = DatabaseConnection.getConnection()) {
          System.out.println("Database Connected Successfully!");
           } catch (Exception e) {
            System.out.println("Connection Failed!");
           e.printStackTrace();
          }

        // -------- LOGIN --------
        if (!authController.login(sc)) {
            System.out.println("Too many attempts. Exiting...");
            sc.close();
            return;
            
        }

        // -------- MENU LOOP --------
        int choice;

        do {
            System.out.println("\n=== Ocean View Reservation System ===");
            System.out.println("1. Add Reservation");
            System.out.println("2. Display Reservation");
            System.out.println("3. Print Bill");
            System.out.println("4. Help");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1 -> reservationController.addReservation(sc);
                case 2 -> reservationController.displayReservation(sc);
                case 3 -> billingController.printBill(sc);
                case 4 -> helpController.showHelp();
                case 5 -> exitController.exitSystem(sc);
                default -> System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }
}
