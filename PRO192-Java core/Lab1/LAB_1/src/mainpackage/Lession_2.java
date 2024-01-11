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
public class Lession_2 {
    
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your monthly electricity usage: ");
        int electric_usage = sc.nextInt();
        
        System.out.println("Your electricity bill is: " + calculateBill(electric_usage));
    }
    
    static int calculateBill(int usage) {
        int bill;
        if (usage <= 50) {
            bill = usage * 1000;
        } else {
            bill = 50 * 1000 + usage * 1200;
        }
        return bill;
    }
}
