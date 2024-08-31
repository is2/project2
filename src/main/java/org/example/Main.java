package org.example;

import org.example.dao.UserDao;
import org.example.dao.UserHibernateDaoImpl;
import org.example.model.User;
import org.example.service.UserService;
import org.example.service.UserServiceImpl;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserHibernateDaoImpl();
        UserServiceImpl userService = new UserServiceImpl(userDao);

        userService.createUsersTable();
        userService.saveUser("A", "A", (byte) 25);
        userService.saveUser("B", "B", (byte) 30);
        userService.saveUser("C", "C", (byte) 25);
        userService.saveUser("D", "D", (byte) 30);
        System.out.println("Users in database:");
        for (User user : userService.getAllUsers()) {
            System.out.println(user);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
