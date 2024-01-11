/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Date;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Staff;
import model.StaffList;
import model.Validation;
import view.Menu;

/**
 *
 * @author hoang
 */
public class StaffManagement extends Menu {

    private static final StaffList model = new StaffList();
    private static final String MENU_TITLE = "Staff Management";
    private static final String[] MENU_OPTIONS = {"Display all staff", "Search staff", "Login", "Change password", "Remove staff"};
    private static Menu subMenu;
    private static final String SUBMENU_TITLE = "Staff Searching";
    private static final String[] SUBMENU_OPTIONS = {"Find by ID", "Find by name", "Find by department", "Find by date of birth"};

    public StaffManagement() {
        super(MENU_TITLE, MENU_OPTIONS);
        StaffList.loadData();
        createSubMenu();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                model.displayAllStaff();
                break;
            case 2:
                subMenu.run();
                break;
            case 3:
                model.login();
                break;
            case 4:
                if (!model.changePassword()) {
                    System.out.println("ID not found");
                }
                break;
            case 5:
                model.removeStaff();
                break;
        }
    }

    private static void createSubMenu() {
        Scanner sc = new Scanner(System.in);
        subMenu = new Menu(SUBMENU_TITLE, SUBMENU_OPTIONS) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        System.out.print("Enter ID: ");
                        String searchID = sc.nextLine();
                        Predicate<Staff> searchByID = s -> s.getId().equals(searchID);
                        StaffList.printResult(model.searchByCriteria(searchByID));
                        break;
                    case 2:
                        System.out.print("Enter name: ");
                        String startDate = sc.nextLine();
                        Predicate<Staff> searchByStartDate = s -> s.getFullName().equals(startDate);
                        StaffList.printResult(model.searchByCriteria(searchByStartDate));
                        break;
                    case 3:
                        System.out.print("Enter department: ");
                        String depart = sc.nextLine();
                        Predicate<Staff> searchByDepartment = s -> s.getDepartment().equals(depart);
                        StaffList.printResult(model.searchByCriteria(searchByDepartment));
                        break;
                    case 4:
                        System.out.print("Enter date of birth: ");
                        String dob = sc.nextLine();
                        Date searchDob = new Date();
                            try {
                                searchDob = Validation.convertStringToDate(dob);
                            } catch (Exception ex) {
                                Logger.getLogger(StaffManagement.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        Predicate<Staff> searchByDob = e -> e.getDob().equals(dob);
                        StaffList.printResult(model.searchByCriteria(searchByDob));     //doesn't work
                        break;
                }
            }
        };
    }

    public static void main(String[] args) {
        StaffManagement manager = new StaffManagement();
        manager.run();
    }
}
