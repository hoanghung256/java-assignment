/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoang
 */
public class PatientList {
    private static final ArrayList<Patient> patients = new ArrayList<>();
    private static final String PATH = new File("src").getAbsolutePath();
    private static final String DATA_FILE_NAME = "\\model\\patient.csv";
    
    public void displayAllPatient() {
        System.out.println("List of Patients");
        System.out.println("----------------------------------------------------------------------------------------");
        patients.forEach(e -> System.out.println(e.toString()));
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Total: " + patients.size());
    }
    
    public static ArrayList<Patient> searchByCriteria(Predicate<Patient> criteria) {
        ArrayList<Patient> result = new ArrayList<>();
        for (Patient c : patients) {
            if (criteria.test(c)) {
                result.add(c);
            }
        }
        return result;
    }
    
    public void addPatient() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        String id = sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        
        String date;
        while (true) {
            System.out.print("Enter date of birth: ");
            date = sc.nextLine();
            if (Validation.isValidDate(date)) {
                break;
            }
        }
        
        String phone;
        while (true) {
            System.out.print("Enter phone: ");
            phone = sc.nextLine();
            if (Validation.isValidPhone(date)) {
                break;
            }
        }

        try {
            patients.add(new Patient(id, name, Validation.convertStringToDate(date), phone));
        } catch (Exception ex) {
            Logger.getLogger(PatientList.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Added new Patient!");
    }
    
    public boolean updatePhoneNumber() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter patient's ID that want to change password: ");
        String id = sc.nextLine();
       
        for (Patient s : patients) {
            if (s.getId().equals(id)) {
                s.changePhone();
                return true;
            } 
        }
        return false;
    }
    
    
    public void loadData() {
        String std;

        try (BufferedReader br = new BufferedReader(new FileReader(PATH + DATA_FILE_NAME))) {    //Try with resource
            while ((std = br.readLine()) != null) {
                String[] b = std.split(",");
                try {
                    if (Validation.isValidPhone(b[3]) && Validation.isValidDate(b[2])) {
                        patients.add(new Patient(b[0], b[1], Validation.convertStringToDate(b[2]), b[3]));
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public static void printSearchingResult(ArrayList<Patient> result) {
        if (result.isEmpty()) {
            System.out.println("No matched!");
        } else {
            System.out.println("----------------------------------------------------------------------------------------");
            result.forEach(b -> System.out.println(b));
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("Total: " + result.size());
        }
    }
}  

