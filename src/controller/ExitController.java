package controller;

import java.util.Scanner;

public class ExitController {

    public void exitSystem(Scanner sc) {
        System.out.println("\nClosing resources...");
        sc.close();
        System.out.println("System exited successfully. Goodbye!");
    }
}
