/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ws2;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Part2_1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        boolean check = false;
        String pattern = "[A-Z]{2}[0-9]{3}"; //2 first chars is uppercase and 3 ramains is number
        do {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print("Enter the string: ");
                String s = sc.nextLine();
                if (!s.matches(pattern)) {
                    throw new Exception();
                }
                System.out.println("The string is: " + s);
                check = false;
            } catch (Exception e) {
                System.out.println("The number is invalid!");
                check = true;
            }
        } while (check);
    }

}
