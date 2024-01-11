/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage;

/**
 *
 * @author hoang
 */
public class OfficalEmployee extends Employee{
    private double basic_salary = 1000000;
    private double coefficient_salary;

    public OfficalEmployee() {
    }

    public OfficalEmployee(String full_name, String address, int age, double coefficient_salary) {
        super(full_name, address, age);
        this.coefficient_salary = coefficient_salary;
    }

    public double getBasic_salary() {
        return basic_salary;
    }

    public void setBasic_salary(double basic_salary) {
        this.basic_salary = basic_salary;
    }

    public double getCoefficient_salary() {
        return coefficient_salary;
    }

    public void setCoefficient_salary(double coefficient_salary) {
        this.coefficient_salary = coefficient_salary;
    }

    @Override
    public String toString() {
        return "OfficalEmployee{Full name: " + this.getFull_name() + ", address: " + this.getAddress() + ", salary: " + this.calculateSalary() +"}";
    }
    
    
    public double calculateSalary() {
        return basic_salary * coefficient_salary;
    }
    
    
}
