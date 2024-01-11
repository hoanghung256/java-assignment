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
public class Part2_2 {

    private String inputString() throws Exception {
        String pattern = "[A-Z]{2}[0-9]{3}";
        Scanner sc = new Scanner(System.in);
        System.out.print("Input the string: ");
        String s = sc.nextLine();
        if (!s.matches(pattern)) {
            throw new Exception();
        }
        return s;
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        Part2_2 obj = new Part2_2();
        boolean check = false;
        
        do {
            try {
                String s = obj.inputString();
                System.out.println("The string is: ");
                check = false;
            }catch (Exception e) {
                System.out.println("The string is invalid!");
                check = true;
            }
        }while(check);
    }
    
}
