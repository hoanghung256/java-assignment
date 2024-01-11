package mainpackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
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
        List<SoftBankNorth> sb_norths = new ArrayList<>();
        List<SoftBankCentral> sb_centrals = new ArrayList<>();

        int choice;
        int con = 0;
        String input;
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("\n----------MENU----------");
            System.out.println("1. Enter branch.");
            System.out.println("2. Show total employees.");
            System.out.println("3. Show actual cost.");
            System.out.println("4. Show total employees by branch and position.");
            System.out.println("5. Show salary by position.");

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
                        SoftBankNorth a = new SoftBankNorth();
                        a.scanInfo();
                        sb_norths.add(a);
                    } else {
                        SoftBankCentral a = new SoftBankCentral();
                        a.scanInfo();
                        sb_centrals.add(a);
                    }
                    break;
                case 2:
                    if (classify() == 1) {
                        System.out.println("Total employees of North branch: " + getTotalEmployees(sb_norths));
                    } else {
                        System.out.println("Total employees of Central branch: " + getTotalEmployees(sb_centrals));
                    }
                    break;
                case 3:
                    if (classify() == 1) {
                        System.out.printf("Actual cost of North branch: %.2f\n", getTotalNorthActualCost(sb_norths));
                    } else {
                        System.out.printf("Actual cost of Central branch: %.2f\n", getTotalCentralActualCost(sb_centrals));
                    }
                    break;
                case 4:
                    if (classify() == 1) {
                        printTotalEmployeeByPosition(sb_norths);
                    } else {
                        printTotalEmployeeByPosition(sb_norths);
                    }
                    break;
                case 5:
                    if (classify() == 1) {
                        printTotalNorthSalaryByPosition(sb_norths);
                    } else {
                        printTotalCentralSalaryByPosition(sb_centrals);
                    }
                    break;
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
        System.out.print("Branch (1 for Norths, 0 for Central): ");
        return sc.nextInt();
    }

    public static <T extends SoftBank> int getTotalEmployees(List<T> branches) {
        int sum = 0;
        for (T branch : branches) {
            sum += branch.getJuniors() + branch.getSeniors();
        }
        return sum;
    }

    public static double getTotalNorthActualCost(List<SoftBankNorth> branches) {
        int actual_cost = 0;
        for (SoftBankNorth branch : branches) {
            actual_cost += branch.getContingencyCost();
        }
        return actual_cost;
    }
    
    public static double getTotalCentralActualCost(List<SoftBankCentral> branches) {
        int actual_cost = 0;
        for (SoftBankCentral branch : branches) {
            actual_cost += branch.getContingencyCost();
        }
        return actual_cost;
    }
    
    public static <T extends SoftBank> void printTotalEmployeeByPosition(List<T> branches) {
        int total_seniors = 0;
        int total_juniors = 0;
        
        for (T branch : branches) {
            total_juniors += branch.getJuniors();
            total_seniors += branch.getSeniors();
        }
        System.out.println("Total junior employess: " + total_juniors);
        System.out.println("Total senior employess: " + total_seniors);
    }
    
    public static void printTotalNorthSalaryByPosition(List<SoftBankNorth> branches) {
        double senior_salary = 0;
        double junior_salary = 0;
        
        for (SoftBankNorth branch : branches) {
            senior_salary += branch.getSeniorSalary();
            junior_salary += branch.getJuniorSalary();
        }
        
        System.out.printf("Total junior salary of North branch: %.2f\n", junior_salary);
        System.out.printf("Total senior salary of North branch: %.2f\n", senior_salary);
    }
    
    public static void printTotalCentralSalaryByPosition(List<SoftBankCentral> branches) {
        double senior_salary = 0;
        double junior_salary = 0;
        
        for (SoftBankCentral branch : branches) {
            senior_salary += branch.getSeniorSalary();
            junior_salary += branch.getJuniorSalary();
        }
        
        System.out.printf("Total junior salary of Central branch: %.2f\n", junior_salary);
        System.out.printf("Total senior salary of Central branch: %.2f\n", senior_salary);
    }
}
