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
public class Employee {
    private String id;
    private String surname;
    private String name;
    private int age;
    private String dob;
    private int workday;

    public Employee() {
    }

    public Employee(String id, String surname, String name, int age, String dob, int workday) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.workday = workday;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getWorkday() {
        return workday;
    }

    public void setWorkday(int workday) {
        this.workday = workday;
    }

    public void scanInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        this.id = sc.nextLine();
        System.out.print("Enter surname: ");
        this.surname = sc.nextLine();
        System.out.print("Enter name: ");
        this.name = sc.nextLine();
        System.out.print("Enter age: ");
        this.age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter date of birth: ");
        this.dob = sc.nextLine();
        System.out.print("Enter work days: ");
        this.workday = sc.nextInt();
        sc.nextLine();
    }
    
    @Override
    public String toString() {
        return "id = " + id + ", surname = " + surname + ", name = " + name + ", dob = " + dob + ", workday = " + workday;
    }
}
