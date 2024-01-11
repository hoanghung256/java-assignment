/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view_controller;

import java.util.Arrays;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Patient;
import model.PatientList;
import model.Validation;

/**
 *
 * @author hoang
 */
public class PatientManagement extends Menu<String> {

    private static final PatientList model = new PatientList();
    private static final String menuTitle = "Patients Management";
    private static final String[] menuOptions = {"Display all patients", "Search Patient", "Add Patient", "Update phone", "Exit"};
    private static final String subMenuTitle = "Search Patient Option";
    private static final String[] subMenuOptions = {"Search By ID", "Search By Name", "Search By DOB", "Search By Phone"};
    private static Menu subMenu;

    public PatientManagement() {
        super(menuTitle, menuOptions);
        createSubMenu();
        model.loadData();
    }

    private static void createSubMenu() {
        Scanner sc = new Scanner(System.in);
        subMenu = new Menu(subMenuTitle, subMenuOptions) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        System.out.print("Enter ID: ");
                        String searchID = sc.nextLine();
                        Predicate<Patient> searchByID = s -> s.getId().equals(searchID);
                        PatientList.printSearchingResult(model.searchByCriteria(searchByID));
                        break;
                    case 2:
                        System.out.print("Enter Name: ");
                        String searchName = sc.nextLine();
                        Predicate<Patient> searchByName = s -> s.getName().equals(searchName);
                        PatientList.printSearchingResult(model.searchByCriteria(searchByName));
                        break;
                    case 3:
                        while (true) {
                            System.out.print("Enter Date: ");
                            String dobString = sc.nextLine();
                            if (Validation.isValidDate(dobString)) {
                                try {
                                    Date searchDob = Validation.convertStringToDate(dobString);
                                    Predicate<Patient> searchByDob = c -> c.getDob().before(searchDob);
                                    System.out.println("Searching Result");
                                    PatientList.printSearchingResult(PatientList.searchByCriteria(searchByDob));
                                } catch (Exception ex) {
                                    Logger.getLogger(PatientManagement.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            }
                        }
                        break;
                    case 4:
                        System.out.print("Enter Phone: ");
                        String searchPhone = sc.nextLine();
                        Predicate<Patient> searchByPhone = s -> s.getPhone().equals(searchPhone);
                        PatientList.printSearchingResult(model.searchByCriteria(searchByPhone));
                        break;
                }
            }
        };
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                model.displayAllPatient();
                break;
            case 2:
                subMenu.run();
                break;
            case 3:
                model.addPatient();
                break;
            case 4:
                if (!model.updatePhoneNumber()) {
                    System.out.println("ID not found");
                }
                break;
            case 5:
                System.out.println("Goodbye!");
                System.exit(0);
        }
    }

    public static void main(String[] args) {
//        PatientManagement manager =  new PatientManagement();
//        manager.run();
        Integer[] a = {9, 28, 6, 7, 12};

        String[] b = {"D", "C", "A", "B", "A"};

        TreeMap<String, Integer> maps = new TreeMap<>();

        for (int i = 0; i < a.length; i++) {
            maps.put(b[i], a[i]);
        }

        System.out.println(maps);
    }
}
