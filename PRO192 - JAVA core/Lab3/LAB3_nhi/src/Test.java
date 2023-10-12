/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab3;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author ASUS
 */
public class Test {

    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {

        ArrayList<ParttimeEmployee> pList = new ArrayList<>();
        ArrayList<OfficialEmployee> oList = new ArrayList<>();

        boolean continueLoop = true;
        Scanner input = new Scanner(System.in);
        int choices = 0;
        while (continueLoop) {
            System.out.println("\nMenu:");
            System.out.println("1.Input employees'information");
            System.out.println("2.Show list of employees");
            System.out.println("3.Sort employees");
            System.out.println("4.Find and delete employees");
            System.out.println("5.Average salary of employee");
            System.out.println("6. Exit");
            System.out.print("Your choice: ");
            choices = input.nextInt();
            input.nextLine();
            switch (choices) {
                case 1:
                    int ip;
                    do {
                        System.out.println("Choose the type of employee to input:");
                        System.out.println("1. Part-time Employee");
                        System.out.println("2. Official Employee");
                        System.out.println("3. Exit");
                        System.out.print("Your choice: ");
                        ip = input.nextInt();
                        input.nextLine();
                        switch (ip) {
                            case 1:
                                ParttimeEmployee p = scanParttimeInfo();
                                pList.add(p);
                                System.out.print("Successful adding!\n");
                                break;
                            case 2:
                                OfficialEmployee o = scanOfficialInfo();
                                oList.add(o);
                                System.out.print("Successful adding!\n");
                                break;
                            case 3:
                                System.out.print("Exit");
                                break;
                            default:
                                System.out.println("Invalid choice");
                        }
                    } while (ip > 3);
                    break;

                case 2:
                    int show;
                    System.out.println("Types of employee you want to show:");
                    System.out.println("1. Part-time Employee");
                    System.out.println("2. Official Employee");
                    System.out.println("3. Exit");
                    System.out.print("Your choice: ");
                    show = input.nextInt();
                    switch (show) {
                        case 1:
                            showParttimeEmployee(pList);
                            break;
                        case 2:
                            showOfficialEmployee(oList);
                            break;
                        case 3:
                            System.out.print("Exit");
                            break;
                        default:
                            System.out.println("Invalid choice");
                    }
                    break;
                case 3:
                    int sortList;
                    do {
                        System.out.println("Sort Employee:");
                        System.out.println("1. Part-time Employee");
                        System.out.println("2. Official Employee");
                        System.out.println("3. Exit");
                        System.out.print("Your choice: ");
                        sortList = input.nextInt();
                        switch (sortList) {
                            case 1:
                                sortParttimeEmployee(pList);
                                for (ParttimeEmployee pEmployee : pList) {
                                    System.out.println(pEmployee);
                                }
                                break;
                            case 2:
                                sortOfficialEmployee(oList);
                                for (OfficialEmployee oEmployee : oList) {
                                    System.out.println(oEmployee);
                                }
                                break;
                            case 3:
                                System.out.print("Exit");
                                break;
                            default:
                                System.out.println("Invalid choice");
                        }
                    } while (sortList > 3);
                    break;

                case 4:
                    int deleteN;
                    do {
                        System.out.println("1. Part-time Employee");
                        System.out.println("2. Official Employee");
                        System.out.println("3. Exit");
                        System.out.print("Your choice: ");
                        deleteN = input.nextInt();
                        input.nextLine();
                        System.out.println("Enter name to delete: ");
                        String dltName = input.nextLine();
                        switch (deleteN) {
                            case 1:
                                deleteParttimeEmployee(dltName, pList);
                                break;
                            case 2:
                                deleteOfficialEmployee(dltName, oList);
                                break;
                            case 3:
                                System.out.print("Exit");
                                break;
                            default:
                                System.out.println("Invalid choice");
                        }
                    } while (deleteN > 3);
                    break;

                case 5:
                    System.out.printf("\nAvarage salary of part-time employees: %.0f", averageSalaryParttimeEmployee(pList));
                    System.out.printf("\nAvarage salary of official employees: %.0f\n", averageSalaryOfficialEmployee(oList));
                    break;
                case 6:
                    System.out.printf("Exit program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid! Retry");
            }
        }
        while (choices > 6);
        input.close();
    }

//------------------------------------------------------------------------------
    //input information of part-time employee
    private static ParttimeEmployee scanParttimeInfo() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter ID:");
        int id = input.nextInt();

        input.nextLine();

        System.out.println("Enter full name:");
        String fullName = input.nextLine();

        System.out.println("Enter age:");
        int age = input.nextInt();

        input.nextLine();

        System.out.println("Enter birthday:");
        String birthday = input.nextLine();

        System.out.println("Enter work days:");
        int workDay = input.nextInt();

        System.out.println("Enter salary:");
        double salary = input.nextDouble();

        System.out.println("Enter discount rate:");
        double discountRate = input.nextDouble();

        return new ParttimeEmployee(id, fullName, age, birthday, workDay, salary, discountRate);
    }

    private static OfficialEmployee scanOfficialInfo() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter ID:");
        int id = input.nextInt();

        input.nextLine();

        System.out.println("Enter full name:");
        String fullName = input.nextLine();

        System.out.println("Enter age:");
        int age = input.nextInt();

        input.nextLine();

        System.out.println("Enter birthday:");
        String birthday = input.nextLine();

        System.out.println("Enter work days:");
        int workDay = input.nextInt();

        System.out.println("Enter salary:");
        double salary = input.nextDouble();

        System.out.println("Enter over time:");
        int OTtime = input.nextInt();

        return new OfficialEmployee(id, fullName, age, birthday, workDay, salary, OTtime);
    }

    private static void showParttimeEmployee(ArrayList<ParttimeEmployee> pList) {
        System.out.println("Part-time Employees:");
        for (ParttimeEmployee partTime : pList) {
            System.out.println(partTime.toString());
        }
    }

    private static void showOfficialEmployee(ArrayList<OfficialEmployee> oList) {
        System.out.println("Official Employees:");
        for (OfficialEmployee official : oList) {
            System.out.println(official.toString());
        }
    }

    public static void sortParttimeEmployee(ArrayList<ParttimeEmployee> pList) {
        int n = pList.size();
        boolean swapped;

        do {
            swapped = false;

            for (int i = 0; i < n - 1; i++) {
                Employee emp1 = pList.get(i);
                Employee emp2 = pList.get(i + 1);

                if (emp1.calculateSalary() < emp2.calculateSalary()) {
                    pList.set(i, (ParttimeEmployee) emp2);
                    pList.set(i + 1, (ParttimeEmployee) emp1);
                    swapped = true;
                }
            }

            n--;
        } while (swapped);
    }

    public static void sortOfficialEmployee(ArrayList<OfficialEmployee> oList) {
        int n = oList.size();
        boolean swapped;

        do {
            swapped = false;

            for (int i = 0; i < n - 1; i++) {
                Employee emp1 = oList.get(i);
                Employee emp2 = oList.get(i + 1);

                if (emp1.calculateSalary() < emp2.calculateSalary()) {
                    oList.set(i, (OfficialEmployee) emp2);
                    oList.set(i + 1, (OfficialEmployee) emp1);
                    swapped = true;
                }
            }

            n--;
        } while (swapped);
    }

    public static void deleteParttimeEmployee(String dltName, ArrayList<ParttimeEmployee> pList) {
        for (ParttimeEmployee p : pList) {
            String[] fullName = p.getFullName().split(" ");
            String realName = fullName[fullName.length - 1];
            if (realName.equalsIgnoreCase(dltName)) {
                pList.remove(p);
            }
        }
    }

    public static void deleteOfficialEmployee(String dltName, ArrayList<OfficialEmployee> oList) {
        for (OfficialEmployee p : oList) {
            String[] fullName = p.getFullName().split(" ");
            String realName = fullName[fullName.length - 1];
            if (realName.equalsIgnoreCase(dltName)) {
                oList.remove(p);
            }
        }
    }

    public static double averageSalaryParttimeEmployee(ArrayList<ParttimeEmployee> pList) {
        double sum = 0;
        int count = 0;
        for (ParttimeEmployee parttime : pList) {
            if (parttime instanceof ParttimeEmployee) {
                sum = sum + parttime.calculateSalary();
                count++;
            }
        }
        double average = sum / count;
        return average;
    }

    public static double averageSalaryOfficialEmployee(ArrayList<OfficialEmployee> oList) {
        double sum = 0;
        int count = 0;
        for (OfficialEmployee official : oList) {
            if (official instanceof OfficialEmployee) {
                sum = sum + official.calculateSalary();
                count++;
            }
        }
        double average = sum / count;
        return average;
    }
}
