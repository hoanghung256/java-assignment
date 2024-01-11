/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;

/**
 *
 * @author hoang
 */
public class StaffList {

    private static final ArrayList<Staff> staffs = new ArrayList<>();
    private static final String INPUT_FILE_NAME = "staff.txt";

    public StaffList() {
    }

    public void displayAllStaff() {
        System.out.println("List of Vaccines");
        System.out.println("-----------------------------------");
        staffs.forEach(s -> System.out.println(s.toString()));
        System.out.println("-----------------------------------");
        System.out.println("Total: " + staffs.size() + " staffs");
    }

    public boolean login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter password: ");
        String pass = sc.nextLine();
        Predicate<Staff> validLogin = s -> s.getId().equals(id) && s.getPassword().equals(pass);
        if (searchByCriteria(validLogin).isEmpty()) {
            System.out.println("Login failed!");
            return false;
        }
        System.out.println("Login succeed!");
        return true;
    }

    public boolean changePassword() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter staff's ID that want to change password: ");
        String id = sc.nextLine();
       
        for (Staff s : staffs) {
            if (s.getId().equals(id)) {
                s.changePassword();
                return true;
            } 
        }
        return false;
    }

    public ArrayList<Staff> searchByCriteria(Predicate<Staff> criteria) {
        ArrayList<Staff> result = new ArrayList<>();
        for (Staff e : staffs) {
            if (criteria.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public void removeStaff() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID of staff want to remove: ");
        String removeId = sc.nextLine();
        if (staffs.removeIf(b -> b.getId().equalsIgnoreCase(removeId))) {
            System.out.println("Remove staff succeed!");
        } else {
            System.out.println("Staff ID not found!");
        }
    }

    public static void loadData() {
        String std;
        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME))) {    //try with resource
            while ((std = br.readLine()) != null) {
                String[] b = std.split(",");
                if (Validation.isValidID(b[0].split(":")[1]) && Validation.isValidDate(b[4].split(":")[1])) {
                    try {
                        staffs.add(new Staff(b[0].split(":")[1], b[1].split(":")[1], b[2].split(":")[1], b[3].split(":")[1], Validation.convertStringToDate(b[4].split(":")[1])));
                    } catch (Exception ex) {
                        System.out.println(ex.getMessage());
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void printResult(ArrayList<Staff> result) {
        if (result.isEmpty()) {
            System.out.println("No matched!");
        } else {
            System.out.println("Result");
            System.out.println("-------------------------------------");
            result.forEach(b -> System.out.println(b));
            System.out.println("-------------------------------------");
            System.out.println("Total: " + result.size() + " employees");
        }
    }
}
