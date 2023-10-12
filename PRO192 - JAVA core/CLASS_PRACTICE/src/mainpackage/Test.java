/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainpackage;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author hoang
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Fraction a = new Fraction(2, 4);
//        Fraction b = new Fraction(3, 6);
//        System.out.println("a : " + a.getNumerator() + "/" + a.getDenominator());
//        System.out.println("b : " + b.getNumerator() + "/" + b.getDenominator());
//
//        Fraction r1 = a.add(b);
//        Fraction r2 = a.subtract(b);
//        Fraction r3 = a.devide(b);
//        Fraction r4 = a.multiply(b);
//        
//        System.out.println("");
//        
//        a.simplify();
//        b.simplify();
//        System.out.println("a simplify = " + a.getNumerator() + "/" + a.getDenominator());
//        System.out.println("b simplify = " + b.getNumerator() + "/" + b.getDenominator());
//        System.out.println("a + b = " + r1.toString());
//        System.out.println("a - b = " + r2.toString());
//        System.out.println("a * b = " + r4.toString());
//        System.out.println("a / b = " + r3.toString());
//        System.out.println("a compare to b: " + a.equalTo( b));

            Fraction[] fracs = new Fraction[5];
            for (int i = 0; i < 5; i++) {
               Fraction a = new Fraction();
               a.random();
               fracs[i] = a;
           }
            
            System.out.println("After initilize: ");
            for (Fraction f : fracs) {
                System.out.println(f.toString());
            }
            
            for (int i = 0; i < 4; i++) {
                fracs[i] = fracs[i].add(fracs[i+1]);
            }
            System.out.println("Sum of Fractions = " + fracs[3]);
            
            System.out.println("After sort decreasing: ");
            Arrays.sort(fracs);
            for (Fraction f : fracs) {
                System.out.println(f.toString());
            }
    }
    

}
