/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainpackage;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Lession_3 {
    public static void main(String[] args) {
        // TODO code application logic here
        int choice;
        int con = 0;
        String input;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("----------MENU----------\n");
            System.out.println("1. Solve quadratic equation.");
            System.out.println("2. Calculate electricity bill.");

            System.out.print("Enter your choice: ");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("Invalid choice, only numbers are allowed.");
                System.out.print("Enter your choice: ");
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter a: ");
                    int a = sc.nextInt();
                    System.out.print("Enter b: ");
                    int b = sc.nextInt();
                    System.out.print("Enter c: ");
                    int c = sc.nextInt();

                    System.out.println("Your equation: " + a + "x^2 + " + b + "x + " + c);
                    Lession_1.printSolution(a, b, c);
                    break;
                case 2:
                    System.out.print("Enter your monthly electricity usage: ");
                    int electric_usage = sc.nextInt();
                    System.out.println("Your electricity bill is: " + Lession_2.calculateBill(electric_usage));
                    break;
                default:
                    System.out.println("Invalid choice, please enter again!");
                    continue;
            }

            System.out.print("Do you want to continue? (y/n): ");
            input = sc.next();

            if (input.charAt(0) == 'y' || input.charAt(0) == 'Y') {
                con = 1;
            } else {
                System.out.println("\nGoodbye!");
                return;
            }
        } while (con == 1);
    }

}
