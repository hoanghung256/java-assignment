/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maindemo;

/**
 *
 * @author hoang
 */
public class Quiz2 {
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt("1");
            int b = Integer.parseInt("fly");
        } catch (NumberFormatException e) {
            System.out.println("You got number format exception!");
        } finally {
            System.out.println("a = " + a);
            System.out.println("b = " + b);
        }
    }
}
