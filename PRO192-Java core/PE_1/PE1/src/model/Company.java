/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

//import model.Validation;
//import model.Employee;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.function.Predicate;
import static model.Validation.convertStringToDate;

/**
 *
 * @author hoang
 */
public class Company {

    private static final ArrayList<Employee> empList = new ArrayList<>();
    private static final String DATA_FILE_NAME = "employee.txt";

    public Company() {
    }

    public static void listAllEmp() {
        System.out.println("List of Employees");
        System.out.println("--------------------------");
        empList.forEach(e -> System.out.println(e.toString()));
        System.out.println("--------------------------");
        System.out.println("Total: " + empList.size() + " employees.");
    }

    public void calCompanyMonthlyIncome() {
        for (Employee e : empList) {
            e.calMonthlyIncome();
        }
    }

    public void sortEmpAscByMonthly() {
        empList.sort((Employee e1, Employee e2) -> Float.compare(e1.calMonthlyIncome(), e2.calMonthlyIncome()));
    }

    public ArrayList<Employee> searchByCriteria(Predicate<Employee> criteria) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee e : empList) {
            if (criteria.test(e)) {
                result.add(e);
            }
        }
        return result;
    }

    public static void printResult(ArrayList<Employee> result) {
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

    public void loadData() {
        String std;

        try (BufferedReader br = new BufferedReader(new FileReader(DATA_FILE_NAME))) {    //Try with resource
            while ((std = br.readLine()) != null) {
                String[] b = std.split(",");
                try {
                    if (Validation.isValidID(b[0]) && Validation.isValidDate(b[2])) {
                        empList.add(new Employee(b[0], b[1], convertStringToDate(b[2]), Float.parseFloat(b[3]), Integer.parseInt(b[4])));
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println("IOException occur");
        }
    }
}
