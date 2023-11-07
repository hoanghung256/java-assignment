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

import model.Company;
import model.Customer;
import model.Validation;
import view.Menu;

/**
 *
 * @author hoang
 */
public class CompanyManagement extends Menu<String> {

    private static final Company model = new Company();
    private static final String menuTitle = "Customer Management System";
    private static final String[] menuOptions = {"List all customers", "Customer Search", "Sort customer by Name", "Statistical homenetwork", "Exit"};
    private static final String subMenuTitle = "Customer Searching";
    private static final String[] subMenuOptions = {"Find by ID", "Find by DOB"};
    private static Menu subMenu;

    public CompanyManagement() {
        super(menuTitle, menuOptions);
        createSubMenu();
        model.loadData();
        model.formatName();
    }

    @Override
    public void execute(int n) {
        switch (n) {
            case 1:
                model.listAllCustomer();
                break;
            case 2:
                subMenu.run();
                break;
            case 3:
                model.sortCustomerByName();
                break;
            case 4:
                model.displayStatisticCustomer();
                break;
            case 5:
                System.out.println("Goodbye");
                System.exit(0);
        }
    }

    private static void createSubMenu() {
        Scanner sc = new Scanner(System.in);
        subMenu = new Menu(subMenuTitle, subMenuOptions) {
            @Override
            public void execute(int n) {
                switch (n) {
                    case 1:
                        while (true) {
                            System.out.print("Enter Customer ID: ");
                            String searchId = sc.nextLine();
                            if (Validation.isValidID(searchId)) {
                                Predicate<Customer> searchById = c -> c.getId().equals(searchId);
                                System.out.println("Searching Result");
                                Company.printSearchingResult(Company.searchByCriteria(searchById));
                                break;
                            }
                        }

                        break;
                    case 2:
                        while (true) {
                            System.out.print("Enter Date: ");
                            String dobString = sc.nextLine();
                            if (Validation.isValidDate(dobString)) {
                                try {
                                    Date searchDob = Validation.convertStringToDate(dobString);
                                    Predicate<Customer> searchByDob = c -> c.getDob().before(searchDob);
                                    System.out.println("Searching Result");
                                    Company.printSearchingResult(Company.searchByCriteria(searchByDob));
                                } catch (Exception ex) {
                                    Logger.getLogger(CompanyManagement.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                break;
                            }
                        }

                        break;

                }
            }
        };
    }

    public static void main(String[] args) {
        CompanyManagement manager = new CompanyManagement();
        manager.run();
    }
}
