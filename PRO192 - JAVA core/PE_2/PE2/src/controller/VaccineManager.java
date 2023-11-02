/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.Vaccine;
import model.Validation;

/**
 *
 * @author hoang
 */
public class VaccineManager extends Menu {
    private static List<Vaccine> vaccines = new ArrayList<>();
    private static final String MENU_TITLE = "Vaccine Managerment System";
    private static final String[] MENU_OPTIONS = {"Display all Vaccines from file", "Add a Vaccine", "Delete a Vacine by code", "Sort Vaccine by name", "Save to file", "Exit"};
    private static final String INPUT_FILE_NAME = "vaccines_input.txt";
    private static final String OUTPUT_FILE_NAME = "vaccines_output.txt";

    public VaccineManager() {
        super(MENU_TITLE, MENU_OPTIONS);
        loadData();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                displayAllVaccines();
                break;
            case 2:
                addVaccine();
                break;
            case 3:
                if (deleteVaccineByCode()) {
                    System.out.println("Deleted Vaccine");
                } else {
                    System.out.println("No vaccine match!");
                }
                break;
            case 4:
                sortVaccineByName();
                break;
            case 5:
                saveData();
                break;
            case 6:
                System.out.println("Goodbye");
                System.exit(0);
        }
    }

    //Method to handle vaccines list
    private static void displayAllVaccines() {
        System.out.println("List of Vaccines");
        System.out.println("-----------------------------------");
        vaccines.forEach(v -> System.out.println(v.toString()));
        System.out.println("-----------------------------------");
        System.out.println("Total: " + vaccines.size() + " Vaccines");
    }

    private static void addVaccine() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter code: ");
        String code = sc.nextLine();
        System.out.print("Enter name: ");
        String name = sc.nextLine();

        String quantity;
        while (true) {
            System.out.print("Enter quantity: ");
            quantity = sc.nextLine();
            if (Validation.isValidQuantity(quantity)) {
                break;
            }
        }

        String expirationDate;
        while (true) {
            System.out.print("Enter expiration date: ");
            expirationDate = sc.nextLine();
            if (Validation.isValidDate(expirationDate)) {
                break;
            }
        }

        String price;
        while (true) {
            System.out.print("Enter price: ");
            price = sc.nextLine();
            if (Validation.isValidPrice(price)) {
                break;
            }
        }

        String lastInjectedDate;
        while (true) {
            System.out.print("Enter last injected date: ");
            lastInjectedDate = sc.nextLine();
            if (Validation.isValidDate(lastInjectedDate)) {
                break;
            }
        }

        try {
            vaccines.add(new Vaccine(code, name, Integer.parseInt(quantity), Validation.convertStringToDate(expirationDate), Double.parseDouble(price), Validation.convertStringToDate(lastInjectedDate)));
        } catch (Exception ex) {
            Logger.getLogger(VaccineManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Added new Vacine!");
    }

    private static void sortVaccineByName() {
        Collections.sort(vaccines);
    }

    private static boolean deleteVaccineByCode() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter code: ");
        String code = sc.nextLine();
        return vaccines.removeIf(v -> v.getCode().equals(code));
    }

    private static void saveData() {
        try (PrintWriter pr = new PrintWriter(OUTPUT_FILE_NAME);) {
            for (Vaccine v : vaccines) {
                pr.println(v);
            }
            pr.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("Save data succeed!");
    }

    private static void loadData() {
        String std;
        try (BufferedReader br = new BufferedReader(new FileReader(INPUT_FILE_NAME))) {    //try with resource
            while ((std = br.readLine()) != null) {
                String[] b = std.split(",");
                if (Validation.isValidQuantity(b[2].split("=")[1]) && Validation.isValidDate(b[3].split("=")[1]) && Validation.isValidPrice(b[4].split("=")[1]) && Validation.isValidDate(b[5].split("=")[1])) {
                    try {
                        vaccines.add(new Vaccine(b[0].split("=")[1], b[1].split("=")[1], Integer.parseInt(b[2].split("=")[1]), Validation.convertStringToDate(b[3].split("=")[1]), Double.parseDouble(b[4].split("=")[1]), Validation.convertStringToDate(b[5].split("=")[1])));
                    } catch (Exception ex) {
                        Logger.getLogger(VaccineManager.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
