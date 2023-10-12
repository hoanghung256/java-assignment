/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpakage;

import java.util.Scanner;

/**
 *
 * @author hoang
 */
public class Student extends Person{
    private double gpa;

    public Student() {
    }

    public Student(double GPA) {
        this.gpa = gpa;
    }

    public Student(String name, int age, String address, double gpa) {
        super(name, age, address);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public int getAge() {
        return age;
    }

    @Override
    public void setAge(int age) {
        this.age = age;
    }
    
    @Override
    public String getAddress() {
        return address;
    }

    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Student{" + super.toString() + ", GPA =" + gpa + '}';
    }
    
    @Override
    public void scanInfo() {
        super.scanInfo();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        this.gpa= sc.nextDouble();
        sc.nextLine();
    }
}
