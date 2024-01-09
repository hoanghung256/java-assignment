/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Validation {
    private final String fruitRegex = "[a-zA-Z]+";
    private final String intRegex = ".*\\d+.*";

    public String getValue(String msg) {
        System.out.print(msg);
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().trim();
    }
    
    public String getAndValidString(String msg) {
        String input;

        while (true) {
            input = getValue(msg);

            if (!input.matches("[a-zA-Z]+")) {
                System.out.println("Input can not contain digit!");
                continue;
            }
            
            return input;
        }
    }
    
    public int getAndValidInt(String msg) {
        String input;

        while (true) {
            input = getValue(msg);

            if (!input.matches(intRegex)) {
                System.out.println("Invalid input enter again");
                continue;
            } 
            return Integer.parseInt(input);
        }
    }
    
    public int getAndValidBuyQuantity(String msg, Fruit buyingFruit) {
        int remain = buyingFruit.getQuantity();
        
        while (true) {
            int input = getAndValidInt(msg);
            
            if (input > remain) {
                System.out.println("Out of remain, remaining " + remain);
                continue;
            }
            return input;
        }
    }
    
//    public boolean isContinue(String msg) {
//        String input;
//        
//        while (true) {
//            input = getValue(msg);
//            
//            if (input)
//        }
//    }
}
