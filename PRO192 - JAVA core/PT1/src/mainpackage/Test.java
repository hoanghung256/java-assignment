package mainpackage;

import java.util.ArrayList;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author hoang
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO code application logic here
        ArrayList<OfficalEmployee> o_list = new ArrayList<>();
        ArrayList<SaleStaff> s_list = new ArrayList<>();
        OfficalEmployee a = scanOfficalEmployee();
        OfficalEmployee b = scanOfficalEmployee();
        OfficalEmployee c = scanOfficalEmployee();
        SaleStaff d = scanSaleStaff();
        SaleStaff e = scanSaleStaff();
        
        o_list.add(a);
        o_list.add(b);
        o_list.add(c);
        s_list.add(d);
        s_list.add(e);
        System.out.println("");
        for (OfficalEmployee em : o_list) {
            System.out.println(em.toString());
        }
        for (SaleStaff em : s_list) {
            System.out.println(em.toString());
        }
        System.out.println("");
        System.out.println("Print infor of official have same address with official " + a.getFull_name());
        printOfficialsSameAddress(o_list, a);
        
    }
    
    public static void printOfficialsSameAddress(ArrayList<OfficalEmployee> employees, Employee a) {
        System.out.println("Officials have the same address: ");
        for (OfficalEmployee employee : employees) {
            if (employee.getAddress().equals(a.getAddress())) {
                System.out.println(employee.toString());
            }
        }   
    }
    
    public static void printSalelersSameAddress(ArrayList<SaleStaff> employees, Employee a) {
        System.out.println("Sallers have the same address: ");
        for (SaleStaff employee : employees) {
            if (employee.getAddress().equals(a.getAddress())) {
                System.out.println(employee.toString());
            }
        }   
    }

    public static OfficalEmployee scanOfficalEmployee() {
        System.out.println("\nInput for offical");
        System.out.print("Enter full name: ");
        String full_name = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter salary coefficient: ");
        double coefficient_salary = sc.nextDouble();
        sc.nextLine();
        return new OfficalEmployee(full_name, address, age, coefficient_salary);
    }
    
    public static SaleStaff scanSaleStaff() {
        System.out.println("\nInput for sale satff.");
        System.out.print("Enter full name: ");
        String full_name = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter sales: ");
        int sale = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter commission: ");
        double commission = sc.nextDouble();
        sc.nextLine();
        return new SaleStaff(full_name, address, age, sale, commission);
    }
}
