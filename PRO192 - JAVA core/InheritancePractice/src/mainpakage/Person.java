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
public class Person {
    protected String name;
    protected int age;
    protected String address;

    public Person() {
    }

    public Person(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return  "name = " + name + ", age = " + age + ", address = " + address;
    }
    
    public void scanInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        this.name = sc.nextLine();
        System.out.print("Enter age: ");
        this.age = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter address: ");
        this.address = sc.nextLine();
    }
}
