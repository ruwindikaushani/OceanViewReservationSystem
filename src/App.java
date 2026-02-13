import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;


public class App {

    static List<Reservation> reservations = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1) Login (temporary simple login)
        if (!login(sc)) {
            System.out.println("Too many attempts. Exiting...");
            sc.close();
            return;
        }

        // 2) Menu loop
        int choice;
        do {
            System.out.println("\n=== Ocean View Reservation System ===");
            System.out.println("1. Add New Reservation");
            System.out.println("2. Display Reservation Details");
            System.out.println("3. Calculate and Print Bill");
            System.out.println("4. Help");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Please enter a number (1-5): ");
                sc.next(); // clear wrong input
            }
            choice = sc.nextInt();
            sc.nextLine(); // clear newline

            switch (choice) {
                case 1 -> addReservation(sc);
                case 2 -> displayReservation(sc);
                case 3 -> calculateBill(sc);
                case 4 -> showHelp();
                case 5 -> System.out.println("Goodbye! Exiting safely...");
                default -> System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);

        sc.close();
    }

    // -------- Login (simple version for now) --------
    static boolean login(Scanner sc) {
        final String USERNAME = "admin";
        final String PASSWORD = "1234";

        for (int attempts = 1; attempts <= 3; attempts++) {
            System.out.print("Username: ");
            String u = sc.nextLine();

            System.out.print("Password: ");
            String p = sc.nextLine();

            if (u.equals(USERNAME) && p.equals(PASSWORD)) {
                System.out.println("Login successful ✅");
                return true;
            } else {
                System.out.println("Wrong username/password. Attempt " + attempts + "/3");
            }
        }
        return false;
    }

    // -------- Menu Features (placeholders for now) --------
    static void addReservation(Scanner sc) {
    System.out.println("\n--- Add New Reservation ---");

    System.out.print("Reservation Number: ");
    String resNo = sc.nextLine().trim();

    System.out.print("Guest Name: ");
    String name = sc.nextLine().trim();

    System.out.print("Address: ");
    String address = sc.nextLine().trim();

    System.out.print("Contact Number: ");
    String contact = sc.nextLine().trim();

    System.out.print("Room Type (Single/Double/Deluxe): ");
    String roomType = sc.nextLine().trim();

    int nights;
    while (true) {
        System.out.print("Number of nights: ");
        String input = sc.nextLine().trim();
        try {
            nights = Integer.parseInt(input);
            if (nights <= 0) {
                System.out.println("Nights must be at least 1.");
                continue;
            }
            break;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
    }

    Reservation r = new Reservation(resNo, name, address, contact, roomType, nights);
    reservations.add(r);

    System.out.println("Reservation added successfully!");
}


    static void displayReservation(Scanner sc) {
        System.out.println("[Display Reservation] (We will code this next)");
    }

    static void calculateBill(Scanner sc) {
        System.out.println("[Calculate Bill] (We will code this next)");
    }

    static void showHelp() {
        System.out.println("\n--- Help ---");
        System.out.println("1) Login using your staff account.");
        System.out.println("2) Use menu options 1-5.");
        System.out.println("3) Add reservation with guest details and dates.");
        System.out.println("4) Display reservation by reservation number.");
        System.out.println("5) Calculate bill based on nights and room rate.");
        System.out.println("6) Exit closes the system safely.");
    }
}
