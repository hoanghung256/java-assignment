/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;
import static model.Validation.convertStringToDate;

/**
 *
 * @author hoang
 */
public class Company {
    private static final ArrayList<Customer> customers = new ArrayList<>();
    private static final String DATA_FILE_NAME = "customer.txt";
    
    public void listAllCustomer() {
        System.out.println("List of Customers");
        System.out.println("----------------------------------------------------------------------------------------");
        customers.forEach(e -> System.out.println(e.toString()));
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("Total: " + customers.size());
    }
    
    public static ArrayList<Customer> searchByCriteria(Predicate<Customer> criteria) {
        ArrayList<Customer> result = new ArrayList<>();
        for (Customer c : customers) {
            if (criteria.test(c)) {
                result.add(c);
            }
        }
        return result;
    }
    
    public void sortCustomerByName() {
        Collections.sort(customers);
        System.out.println("Sorted Customer");
        printSearchingResult(customers);
    }
    
    public void displayStatisticCustomer() {
        System.out.println("Customer of Viettel");
        Predicate<Customer> viettel = c -> c.getHomeNetwork().equals("Viettel");
        printSearchingResult(searchByCriteria(viettel));
        
        System.out.println("Customer of Vinaphone");
        Predicate<Customer> vinaphone = c -> c.getHomeNetwork().equals("Vinaphone");
        printSearchingResult(searchByCriteria(vinaphone));
        
        System.out.println("Customer of Mobiphone");
        Predicate<Customer> mobi = c -> c.getHomeNetwork().equals("Mobiphone");
        printSearchingResult(searchByCriteria(mobi));
    }
    
    public void loadData() {
        String std;

        try (BufferedReader br = new BufferedReader(new FileReader(DATA_FILE_NAME))) {    //Try with resource
            while ((std = br.readLine()) != null) {
                String[] b = std.split(",");
                try {
                    if (Validation.isValidID(b[0]) && Validation.isValidDate(b[3])) {
                        customers.add(new Customer(b[0], b[1], b[2], Validation.convertStringToDate(b[3])));
                    }
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        } catch (IOException ex) {
            System.out.println("IOException occur");
        }
    }
    
    public static void printSearchingResult(ArrayList<Customer> result) {
        if (result.isEmpty()) {
            System.out.println("No matched!");
        } else {
            System.out.println("----------------------------------------------------------------------------------------");
            result.forEach(b -> System.out.println(b));
            System.out.println("----------------------------------------------------------------------------------------");
            System.out.println("Total: " + result.size());
        }
    }
    
    public void formatName() {
        for (Customer c : customers) {
            if (c.getName().length() < 15) {
                String name = c.getName();
                for (int i = 0; i <= 15-c.getName().length(); i++) {
                    name+= " ";
                }
                c.setName(name + " ");
            }
        }
    }
}
