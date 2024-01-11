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
public class Lession_1 {
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a: ");
        int a = sc.nextInt();
        System.out.print("Enter b: ");
        int b = sc.nextInt();
        System.out.print("Enter c: ");
        int c = sc.nextInt();
        
        System.out.println("Your equation: " + a + "x^2 + " + b + "x + " + c);
        
        printSolution(a, b, c);
    }
    
    static void printSolution(int a, int b, int c) {
        double discriminant = Math.sqrt(b * b - 4 * a * c);
        if (discriminant == 0) {
            System.out.println("This equation has double solution:");
            System.out.println("x1 = x2 = " + (-b) / (2 * a));
        } else if (discriminant > 0) {
            System.out.println("This equation has two solutions:");
            System.out.println("x1 = " + ((-b) + discriminant) / (2 * a));
            System.out.println("x2 = " + ((-b) - discriminant) / (2 * a));
        } else {
            System.out.println("This equation has no solution!");
        }
    }
}
