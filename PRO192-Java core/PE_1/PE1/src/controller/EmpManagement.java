/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.Scanner;
import java.util.function.Predicate;

import model.Company;
import model.Employee;

/**
 *
 * @author hoang
 */
public class EmpManagement extends Menu {
    private static final Company model = new Company();    //model must be ony final not static
    private static final String menuTitle = "Employee mnagement System";
    private static final String[] menuOptions = {"List all employee", "Calculate money", "Sorting employee", "Search employee", "Exit"};
    private static final String subMenuTitle = "Employee Searching";
    private static final String[] subMenuOptions = {"Find by Account", "Find by work start date"};
    private static Menu subMenu;
    
    public EmpManagement() {
        super(menuTitle, menuOptions);
        createSubMenu();
        model.loadData();
    }
    @Override
    public void execute(int n) {
        switch(n) {
            case 1:
                model.listAllEmp();
                break;
            case 2:
                model.calCompanyMonthlyIncome();
                model.listAllEmp();
                break;
            case 3:
                model.sortEmpAscByMonthly();
                model.listAllEmp();
                break;
            case 4:
                subMenu.run();
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
                switch(n) {
                    case 1:
                        System.out.print("Enter account: ");
                        String searchAcc = sc.nextLine();
                        Predicate<Employee> searchByAcc = e -> e.getAcc().equals(searchAcc);
                        Company.printResult(model.searchByCriteria(searchByAcc));
                        break;
                    case 2:
                        System.out.print("Enterwork start date: ");
                        String startDate = sc.nextLine();
                        Predicate<Employee> searchByStartDate = e -> e.getStartDate().equals(startDate);
                        Company.printResult(model.searchByCriteria(searchByStartDate));
                        break;
                }
            }
        };
    }
    
}
