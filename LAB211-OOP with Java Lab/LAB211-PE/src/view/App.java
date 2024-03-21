/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Controller;
import models.User;
import services.UserService;
import utils.Validation;

/**
 * This is an authorization java application with 2 general role: manger, staff
 * 
 * @author hoang hung
 */
public class App {
    /**
     * Account for testing
     * username: emily_davis
     * pass: pass456
     * lever: manager
     */
    /**
     * Account for testing
     * username: mike_jackson
     * pass: secret123
     * lever: staff
     */
    public static void main(String[] args) {
        System.out.println("ACCOUNT FOR TESTING\n"
                + "username: emily_davis\n"
                + "pass: pas456\n"
                + "lever: manager\n"
                + "OR\n"
                + "username: mike_jackson\n"
                + "pass: secret123\n"
                + "lever: staff");
        User loginUser = null;

        System.out.println("Welcome");
        while (true) {
            String username = Validation.getValue("Enter your username: ");
            String password = Validation.getValue("Enter your password: ");

            loginUser = UserService.getInstance().login(username, password);
            if (loginUser != null) {
                Controller controller = Controller.getInstance();
                controller.setLoginStaff(loginUser);
                // Authorization user by lever
                if (loginUser.getLever().equals("manager")) {
                    controller.runMenuForManager();
                } else {
                    controller.runMenuForStaff();
                }
                break;
            } else {
                System.out.println("Wrong username or password!");
                continue;
            }
        }
    }
}
