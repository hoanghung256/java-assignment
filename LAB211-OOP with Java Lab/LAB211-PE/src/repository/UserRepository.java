package repository;

import models.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author hoang hung
 */
public class UserRepository {
    private static UserRepository instance;
    private ArrayList<User> users;
    private final String srcPath = new File("src").getAbsolutePath();
    final String usersPath = "\\data\\users.txt";

    private UserRepository() {
        users = readFile();
    }

    public static UserRepository getInstance() {
        if (instance == null) {
            instance = new UserRepository();
        }
        return instance;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<User> readFile() {
        users = new ArrayList<>();
        String line;
        try (BufferedReader input = new BufferedReader(new FileReader(srcPath + usersPath))) {
            while ((line = input.readLine()) != null) {
                String[] attributes = line.split(";");
                User user = new User(attributes[0], attributes[1], attributes[2], attributes[3], attributes[4]);
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void save() {
        try {
            PrintWriter writer = new PrintWriter(srcPath + usersPath);
            users.forEach(user -> writer.println(user.toFileString()));
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
