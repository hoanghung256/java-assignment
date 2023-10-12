/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package maindemo;

/**
 *
 * @author hoang
 */
public class Quiz1 {
    public static void main(String[] args) {
        try {
            demoMethod();
            foobar();
        } catch (NullPointerException e) {
            System.out.println("Hey your pointer is null!!!");
        } catch (Exception e) {
            System.out.println("Hey your code is wrong");
        } finally {
            System.out.println("Execute finally block");
        }
    }

    public static void demoMethod() throws Exception{
        System.out.println("demoMethod() worked");
    }

    public static void foobar() throws NullPointerException {
        System.out.println("foobar() worked");
    }
}


