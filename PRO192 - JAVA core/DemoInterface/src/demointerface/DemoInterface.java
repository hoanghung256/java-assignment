/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package demointerface;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Predicate;

/**
 *
 * @author hoang
 */
public class DemoInterface {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Student> std_list = new ArrayList<>();

    public static void main(String[] args) {
        // TODO code application logic here
        Student a = new Student(002, "Nguyen Van An", true, 3.8);
        Student b = new Student(005, "Nguyen Binh An", true, 3.5);
        Student c = new Student(004, "Nguyen Van Khanh", true, 3.2);
        Student d = new Student(003, "Nguyen Binh Hung", true, 3.3);        

        std_list.add(a);
        std_list.add(b);
        std_list.add(c);
        std_list.add(d);

        System.out.println("Before sort");
        std_list.forEach(System.out::println);
        System.out.println("After sort");
        
        System.out.println("\nSort with comparable:");
        Collections.sort(std_list);
        std_list.forEach(System.out::println);

        System.out.println("\nSort with comparator (lambda expression):");
        std_list.sort(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return Integer.compare(o1.getId(), o2.getId());
            }
        }
        );
        std_list.forEach(System.out::println);
        
        Predicate<Student> search_name = s -> {
            String[] full_name = s.getName().split(" ");
            return full_name[full_name.length - 1].equals("An");
        };
        ArrayList<Student> std_matched = search(search_name);
        
        System.out.println("\nSearch 'An' (with Predicate<> and lambda expression): ");
        std_matched.forEach(System.out::println);
    }
    
    public static ArrayList<Student> search(Predicate<Student> p) {
        ArrayList<Student> rs = new ArrayList<>();
        for (Student s : std_list) {
            if (p.test(s)) {
                rs.add(s);
            }
        }
        return rs;
    }
}
