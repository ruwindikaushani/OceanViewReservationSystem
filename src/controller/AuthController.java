package controller;

import java.util.Scanner;
import service.UserService;

public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    public boolean login(Scanner sc) {
        for (int attempts = 1; attempts <= 3; attempts++) {
            System.out.print("Username: ");
            String username = sc.nextLine();

            System.out.print("Password: ");
            String password = sc.nextLine();

            if (userService.validateLogin(username, password)) {
                System.out.println("Login successful ✅");
                return true;
            } else {
                System.out.println("Wrong username/password. Attempt " + attempts + "/3");
            }
        }
        return false;
    }
}
