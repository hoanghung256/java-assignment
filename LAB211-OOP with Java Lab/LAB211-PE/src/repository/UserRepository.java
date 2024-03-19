/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author hoang hung
 */
public class UserRepository {
    private static UserRepository instance;
    private final String srcPath = new File("src").getAbsolutePath();
    final String usersPath = "\\data\\users.txt";
    
    private UserRepository() {
    }
    
    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }
    
    public ArrayList<User> readFile() {
        String line;
        try (BufferedReader input = new BufferedReader(new FileReader(srcPath + usersPath))) {
            ArrayList<User> users = new ArrayList<>();
            while((line = input.readLine())!= null){
                String[] attributes = line.split(";");
                User user = new User(attributes[0], attributes[1], attributes[2], attributes[3], attributes[4]);     
                users.add(user);
            }
            return users;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}