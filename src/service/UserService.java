package service;

import java.util.ArrayList;
import java.util.List;
import model.User;

public class UserService {
    private final List<User> users = new ArrayList<>();

    public UserService() {
        // sample users
        users.add(new User("admin", "1234", "admin"));
        users.add(new User("staff", "1111", "staff"));
    }

    public boolean validateLogin(String username, String password) {
        for (User u : users) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
