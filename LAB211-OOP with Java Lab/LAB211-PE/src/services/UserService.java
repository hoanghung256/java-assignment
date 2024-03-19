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
     public static User login(String username, String password) {
        ArrayList<User> users = UserRepository.getInstance().readFile();
        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        
        return null;
    }
}
