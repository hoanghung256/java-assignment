/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Test {

    static int choice;
    static int con = 0;
    static String input;

    public static void main(String[] args) {
        // TODO code application logic here

        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("----------MAIN MENU----------");
            System.out.println("1. Work with Array.");
            System.out.println("2. Work with ArrayList");
            System.out.println("3. Exit.");
            System.out.println("------------------------------");

            System.out.print("Enter your choice: ");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("Invalid choice, only numbers are allowed.");
                System.out.print("Enter your choice: ");
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    arrayMenu(sc);
                    break;
                case 2:
                    arrayListMenu(sc);
                    break;
                case 3:
                    System.out.println("\nGoodbye!");
                    return;
                default:
                    System.out.println("Invalid choice, please enter again!");
                    continue;
            }

            System.out.print("Do you want to continue with main menu? (y/n): ");
            input = sc.next();

            if (input.charAt(0) == 'y' || input.charAt(0) == 'Y') {
                con = 1;
            } else {
                System.out.println("\nGoodbye!");
                return;
            }
        } while (con == 1);
    }

    private static void arrayMenu(Scanner sc) {
        Person a = new Person(1, "Nguyen Van A", true);
        Person b = new Person(2, "Nguyen Van P", true);
        Person[] per_arr = new Person[4];
        per_arr[0] = a;
        per_arr[1] = b;

        do {
            System.out.println("\n----------ARRAY MENU----------");
            System.out.println("1. Add 2 new person.");
            System.out.println("2. Display.");
            System.out.println("3. Sort by name increasing.");
            System.out.println("4. Search by name.");
            System.out.println("------------------------------");

            System.out.print("Enter your choice: ");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("Invalid choice, only numbers are allowed.");
                System.out.print("Enter your choice: ");
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    for (int i = 2; i < per_arr.length; i++) {
                        per_arr[i] = scanInfo();
                        System.out.println("");
                    }
                    break;
                case 2:
                    for (Person ps : per_arr) {
                        printInfo(ps);
                    }
                    break;
                case 3:
                    sortByName(per_arr);
                    System.out.println("Sorted inceasingly");
                    break;
                case 4:
                    System.out.print("Enter name to search: ");
                    String search_name = sc.next();

                    System.out.println("Seaching " + search_name + "...");
                    Person[] searched = searchByName(per_arr, search_name);
                    System.out.println("Found " + searched.length + " person match!");
                    for (Person ps : searched) {
                        printInfo(ps);
                    }
                    break;
                default:
                    System.out.println("Invalid choice, please enter again!");
                    continue;
            }

            System.out.print("Do you want to continue with array menu? (y/n): ");
            input = sc.next();

            if (input.charAt(0) == 'y' || input.charAt(0) == 'Y') {
                con = 1;
            } else {
                System.out.println("\nExited array menu!");
                return;
            }
        } while (con == 1);
    }

    private static void arrayListMenu(Scanner sc) {
        ArrayList<Person> person_list = new ArrayList<>();
        Person e = new Person(5, "Nguyen Van E", true);
        Person f = new Person(6, "Nguyen Van F", true);
        person_list.add(e);
        person_list.add(f);
        Person g = new Person();
        Person h = new Person();

        do {
            System.out.println("\n----------ARRAY-LIST MENU----------");
            System.out.println("1. Add new person.");
            System.out.println("2. Remove a person.");
            System.out.println("3. Display.");
            System.out.println("4. Sort by name.");
            System.out.println("5. Search by name.");
            System.out.println("-----------------------------------");

            System.out.print("Enter your choice: ");
            while (!sc.hasNextInt()) {
                sc.next();
                System.out.println("Invalid choice, only numbers are allowed.");
                System.out.print("Enter your choice: ");
            }
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Number of person you want to add (Added: " + person_list.size() + "): ");
                    int num = sc.nextInt();
                    for (int i = 0; i < num; i++) {
                        person_list.add(scanInfo());
                    }
                    System.out.println("Added " + num + " person.");
                    break;
                case 2:
                    System.out.println("Number of person you want to remove (<= " + person_list.size() + "): ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    removePerson(person_list, n, sc);
                    break;
                case 3:
                    for (Person ps : person_list) {
                        printInfo(ps);
                    }
                    break;
                case 4:
                    sortByName(person_list);
                    System.out.println("Sorted!");
                    break;
                case 5:
                    System.out.print("Enter name want to search: ");
                    String search_name = sc.next();
                    System.out.println("");
                    ArrayList<Person> searched = searchByName(person_list, search_name);
                    System.out.println("Found " + searched.size() + " person match!");
                    for (Person ps : searched) {
                        printInfo(ps);
                    }
                    break;
                default:
                    System.out.println("Invalid choice, please enter again!");
                    continue;
            }

            System.out.print("Do you want to continue with array-list menu? (y/n): ");
            input = sc.next();

            if (input.charAt(0) == 'y' || input.charAt(0) == 'Y') {
                con = 1;
            } else {
                System.out.println("\nExited array-list menu!");
                return;
            }
        } while (con == 1);
    }

        public static Person scanInfo() {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter name: ");
            String name = sc.nextLine();
            System.out.print("Enter gender: ");
            boolean gender = sc.nextBoolean();
            sc.nextLine();
            return new Person(id, name, gender);
        }

    public static void printInfo(Person p) {
        try {
            if (p == null) {
                throw new NullPointerException("Person is null");
            } else {
                System.out.println("-------------------------------");
                System.out.println("| ID | Name | Male |");
                System.out.printf("| %d | %s | %s |\n", p.getId(), p.getName(), p.getGender());
            }
        } catch (Exception e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }
    }

    private static void sortByName(Person[] people) {
        int n = people.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                String[] split_j = people[j].getName().split(" ");
                String[] split_j_plus_1 = people[j + 1].getName().split(" ");
                if (split_j[split_j.length - 1].compareTo(split_j_plus_1[split_j_plus_1.length - 1]) > 0) {
                    // Swap the values of two elements
                    Person temp = people[j];
                    people[j] = people[j + 1];
                    people[j + 1] = temp;
                }
            }
        }
    }

    private static Person[] searchByName(Person[] people, String search_name) {
        Person[] temp = new Person[people.length];
        int count = 0;
        for (int i = 0; i < people.length; i++) {
            Person ps = people[i];
            String[] split_name = ps.getName().split(" ");
            if (split_name[split_name.length - 1].compareToIgnoreCase(search_name) == 0) {
                temp[count] = ps;
                count++;
            }
        }
        Person[] result = Arrays.copyOf(temp, count);
        return result;
    }

    private static void removePerson(ArrayList<Person> person_list, int n, Scanner sc) {
        for (int i = 0; i < n; i++) {
            System.out.print("Index of person you want to remove: ");
            int index = sc.nextInt();
            person_list.remove(index);
            sc.nextLine();
        }
        System.out.println("Removed " + n + " person!");
    }

    private static void sortByName(ArrayList<Person> ps_list) {
        for (int i = 0; i < ps_list.size() - 1; i++) {
            for (int j = i + 1; j < ps_list.size(); j++) {
                Person ps1 = ps_list.get(i);
                Person ps2 = ps_list.get(j);

                String[] split_ps_1 = ps1.getName().split(" ");
                String[] split_ps_2 = ps2.getName().split(" ");

                String last_name_1 = split_ps_1[split_ps_1.length - 1];
                String last_name_2 = split_ps_2[split_ps_2.length - 1];

                // Swap
                if (last_name_1.compareTo(last_name_2) > 0) {
                    ps_list.set(i, ps2);
                    ps_list.set(j, ps1);
                }
            }
        }
    }

    private static ArrayList<Person> searchByName(ArrayList<Person> ps_list, String search_name) {
        ArrayList<Person> result = new ArrayList<>();
        for (Person ps : ps_list) {
            if (ps.getName().endsWith(" " + search_name)) {
                result.add(ps);
            }
        }
        return result;
    }
}
