/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.ArrayList;

import models.User;
import repository.UserRepository;

/**
 *
 * @author hoang hung
 */
public class UserService {
    private static UserService instance;
    private ArrayList<User> users;

    private UserService() {
        users = UserRepository.getInstance().readFile();
    }

    public static UserService getInstance() {
        if (instance == null) {
            instance = new UserService();
        }
        return instance;
    }

    public User login(String username, String password) {
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public User findById(String staffId) {
        for (User user : users) {
            if (user.getStaffId().equals(staffId)) {
                return user;
            }
        }
        return null;
    }
}
