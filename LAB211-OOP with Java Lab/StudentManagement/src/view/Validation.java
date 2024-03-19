/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Validation {
    private final String STRING_REGEX = "[a-zA-Z\\s]+";
    private final String SCORE_REGEX = "(10\\.0|0-9?)";

    public Validation() {
    }
    
    public String getString(String msg) {
        System.out.print(msg);
        
        Scanner sc = new Scanner(System.in);
        return sc.nextLine().trim();
    }
    
    public double getAndValidScore(String msg) {
        String score;
        
        while (true) {
            score = getString(msg);
            
            if (!score.matches(SCORE_REGEX)) {
                System.out.println("Invalid score!");
            } else {
                return Double.parseDouble(score);
            }
        }
    }
    
    public String getAndValidStudentName(String msg) {
        String name;
        
        while (true) {
            name = getString(msg);
            
            if (!name.matches(STRING_REGEX)) {
                System.out.println("Invalid score!");
            } else {
                return name;
            }
        }
    }
    
    
}
