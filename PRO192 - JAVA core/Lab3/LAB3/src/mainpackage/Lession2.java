package mainpackage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author hoang
 */
public class Lession2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int choice;
        int con = 0;
        String input;
        Scanner sc = new Scanner(System.in);

        ArrayList<OfficialEmployee> o_list = new ArrayList<>();
        ArrayList<PartTimeEmployee> p_list = new ArrayList<>();

        do {
            System.out.println("----------MENU----------\n");
            System.out.println("1. Enter employee.");
            System.out.println("2. Show employee list.");
            System.out.println("3. Sort decreasing by salary.");
            System.out.println("4. Remove employee.");
            System.out.println("5. Show average salary.");

            System.out.print("Enter your choice: ");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("Invalid choice, only numbers are allowed.");
                System.out.print("Enter your choice: ");
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    if (classify() == 1) {
                        OfficialEmployee a = new OfficialEmployee();
                        a.scanInfo();
                        o_list.add(a);
                    } else {
                        PartTimeEmployee a = new PartTimeEmployee();
                        a.scanInfo();
                        p_list.add(a);
                    }
                    break;
                case 2:
                    if (classify() == 1) {
                        o_list.forEach(o -> System.out.println(o));
                    } else {
                        p_list.forEach(p -> System.out.println(p));
                    }
                    break;
                case 3:
                    if (classify() == 1) {
                        Collections.sort(o_list);
                    } else {
                        Collections.sort(p_list);
                    }
                    break;
                case 4:
                    if (classify() == 1) {
                        System.out.println("Enter name to remove: ");
                        String name = sc.nextLine();
                        o_list.removeIf(o -> o.getName().equals(name));
                    } else {
                        System.out.println("Enter name to remove: ");
                        System.out.println("Enter name to remove: ");
                        String name = sc.nextLine();
                        p_list.removeIf(p -> p.getName().equals(name));
                    }
                    break;
                case 5:
                    if (classify() == 1) {
                        System.out.println("Average salary of Official Employees = " + officialSalaryAver(o_list));
                    } else {
                        System.out.println("Average salary of Part-time Employees = " + partTimeSalaryAver(p_list));
                    }
                default:
                    System.out.println("Invalid choice, please enter again!");
                    continue;
            }

            System.out.print("Do you want to continue? (y/n): ");
            input = sc.next();

            if (input.charAt(0) == 'y' || input.charAt(0) == 'Y') {
                con = 1;
            } else {
                System.out.println("\nGoodbye!");
                return;
            }
        } while (con == 1);
    }

    private static int classify() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Kind of employee (1 for official, 0 for part-time): ");
        return sc.nextInt();
    }

    private static double officialSalaryAver(ArrayList<OfficialEmployee> list) {
        double sum = 0;
        for (OfficialEmployee e : list) {
            sum += e.getSalary();
        }
        return sum / list.size();
    }
    
    private static double partTimeSalaryAver(ArrayList<PartTimeEmployee> list) {
        double sum = 0;
        for (PartTimeEmployee e : list) {
            sum += e.getSalary();
        }
        return sum / list.size();
    }
}
