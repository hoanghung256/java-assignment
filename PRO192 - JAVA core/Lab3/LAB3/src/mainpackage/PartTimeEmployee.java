/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage;

/**
 *
 * @author hoang
 */
public class PartTimeEmployee extends Employee implements Comparable<PartTimeEmployee>{

    private final double discount = 0.5;

    public PartTimeEmployee() {
    }

    public PartTimeEmployee(String id, String surname, String name, int age, String dob, int workday) {
        super(id, surname, name, age, dob, workday);
    }

    public double getDiscount() {
        return discount;
    }

    public double getSalary() {
        return this.getWorkday() * 1000 * discount;
    }

    @Override
    public void scanInfo() {
        System.out.println("Scanning part-time employee...");
        super.scanInfo();
    }

    @Override
    public String toString() {
        return "PartTimeEmployee{" + super.toString() + ", discount = " + discount + ", salary = " + this.getSalary() + '}';
    }

    @Override
    public int compareTo(PartTimeEmployee o) {
        return Double.compare(o.getSalary(), this.getSalary());
    }
}
