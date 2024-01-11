/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class OfficialEmployee extends Employee implements Comparable<OfficialEmployee>{
    private int ot_hour;

    public OfficialEmployee() {
    }

    public OfficialEmployee(String id, String surname, String name, int age, String dob, int workday, int ot_hour) {
        super(id, surname, name, age, dob, workday);
        this.ot_hour = ot_hour;
    }

    public int getOt_hour() {
        return ot_hour;
    }

    public void setOt_hour(int ot_hour) {
        this.ot_hour = ot_hour;
    }
    
    public double getSalary() {
       return this.getWorkday() * 1000 + this.getOt_hour() * 100;
    } 
    
    @Override
    public void scanInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Scanning official employee...");
        super.scanInfo();
        System.out.print("Enter OT hours: ");
        this.ot_hour = sc.nextInt();
        sc.nextLine();
    }

    @Override
    public String toString() {
        return "OfficialEmployee{" + super.toString() + ", ot_hour = " + ot_hour + ", salary = " + this.getSalary() + '}';
    }

    @Override
    public int compareTo(OfficialEmployee o) {
       return Double.compare(o.getSalary(), this.getSalary());
    }
}
