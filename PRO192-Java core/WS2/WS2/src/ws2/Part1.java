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
public class Part1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       boolean check = false;
       do{
           try{
               Scanner sc = new Scanner(System.in);
               System.out.print("Enter the number: ");
               int num = sc.nextInt();
               sc.nextLine();
               if (num < 1) {
                   throw new Exception();
               }
               System.out.println("The number is: " + num);
               check = false;
           } catch (Exception e) {
               System.out.println("The number is invalid!");
               check = true;
           }
       }while (check);
    }
    
}
