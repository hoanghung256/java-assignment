/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.Controller;
import java.util.Scanner;
import models.User;
import services.AuthenticationService;

/**
 *
 * @author hoang hung
 */
public class App {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User loginUser = null;
        
        System.out.println("Welcome...");
        while (true) {
            System.out.print("Enter your username: ");
            String username = sc.nextLine();
            
            System.out.print("Enter your password: ");
            String password = sc.nextLine();
            
            loginUser = AuthenticationService.login(username, password);
            if (loginUser != null) {
                break;
            } else {
                System.out.println("Wrong username or password!");
                continue;
            }
        }
        
        Controller controller = new Controller(loginUser.getLever());
        controller.run();
    }
}
