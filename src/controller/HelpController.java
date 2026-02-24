package controller;

public class HelpController {
    public void showHelp() {
        System.out.println("\n--- Help ---");
        System.out.println("1) Login using staff credentials.");
        System.out.println("2) Add reservation with guest info.");
        System.out.println("3) Display reservation by number.");
        System.out.println("4) Print bill based on nights & room rate.");
        System.out.println("5) Exit closes the system safely.");
    }
}
