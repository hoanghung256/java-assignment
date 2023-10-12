/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mainpakage;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class App {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
            Scanner sc = new Scaner(System.in);

        Person a = new Teacher("Nguyen Van A", 25, "Ha Noi", 30000.0);
        Person b = new Teacher("Nguyen Van B", 25, "Ha Noi", 30000.0);
        Person c = new Student("Nguyen Van C", 18, "Ha Noi", 3.2);
        Person d = new Student("Nguyen Van D", 18, "Ha Noi", 2.9);

        ArrayList<Person> list = new ArrayList<>();
//        list.add(a);
//        list.add(b);
//        list.add(c);
//        list.add(d);
        System.out.println("Type of person you want to add ");
        sc.next();
        if ()
        System.out.print("Enter number of student you want to add: " );
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {
            
            list.add(scanInfo());
        }

        for (Person ps : list) {
            System.out.println(ps.toString());
        }
    }
}
