/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Controller;
import java.util.Scanner;
import models.User;
import services.UserService;
import utils.Validation;

/**
 *
 * @author hoang hung
 */
public class App {
    /**
     * username: emily_davis
     * pass: pass456
     * lever: manager
     */
    public static void main(String[] args) {
        // User loginUser = null;

        // System.out.println("Welcome");
        // while (true) {
        // String username = Validation.getValue("Enter your username: ");

        // String password = Validation.getValue("Enter your password: ");

        // loginUser = UserService.getInstance().login(username, password);
        // if (loginUser != null) {
        // break;
        // } else {
        // System.out.println("Wrong username or password!");
        // continue;
        // }
        // }

        Controller controller = new Controller();
        controller.run();
    }
}
