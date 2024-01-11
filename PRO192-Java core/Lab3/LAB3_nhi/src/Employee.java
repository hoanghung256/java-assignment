/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab3;

import java.text.NumberFormat;

/**
 *
 * @author ASUS
 */
public abstract class Employee {
    protected int ID;
    protected String fullName;
    protected int age;
    protected String birthday;
    protected int workDay;
    protected double salary;
 

    public Employee(int ID, String fullName, int age, String birthday, int workDay, double salary) {
        this.ID = ID;
        this.fullName = fullName;
        this.age = age;
        this.birthday = birthday;
        this.workDay = workDay;
        this.salary = salary;   
    }

    public Employee(){
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    
    public int getWorkDay() {
        return workDay;
    }

    public void setWorkDay(int workDay) {
        this.workDay = workDay;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    
    public abstract double calculateSalary();
    
    
    @Override
    public String toString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String formattedSalary = formatter.format(salary);
        return "ID: " +ID+"\n" + "Full Name: " +fullName+"\n" + "Age: " +age+"\n" + "Birthday: " +birthday+"\n" + "Work days: " +workDay+"\n";
    }
}


