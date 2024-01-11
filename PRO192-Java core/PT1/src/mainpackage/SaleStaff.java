/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage;

/**
 *
 * @author hoang
 */
public class SaleStaff extends Employee{
    private double allowance = 5000;
    private int sale;
    private double commission;

    public SaleStaff() {
    }

    public SaleStaff(String full_name, String address, int age, int sale, double commission) {
        super(full_name, address, age);
        this.sale = sale;
        this.commission = commission;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return "SaleStaff{Full name: " + this.getFull_name() + ", address: " + this.getAddress() + ", salary: " + this.calculateSalary() +"}";
    }
    
    
    public double calculateSalary() {
        return allowance + (commission/100) * sale;
    }
    
    
}
