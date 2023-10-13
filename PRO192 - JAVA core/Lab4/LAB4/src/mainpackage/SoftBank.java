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
public class SoftBank {
    private String id;
    private String name;
    private String founding_day;
    private String address;
    private int juniors;
    private int seniors;

    public SoftBank() {
    }

    public SoftBank(String id, String name, String founding_day, String address, int juniors, int seniors) {
        this.id = id;
        this.name = name;
        this.founding_day = founding_day;
        this.address = address;
        this.juniors = juniors;
        this.seniors = seniors;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFounding_day() {
        return founding_day;
    }

    public void setFounding_day(String founding_day) {
        this.founding_day = founding_day;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getJuniors() {
        return juniors;
    }

    public void setJuniors(int juniors) {
        this.juniors = juniors;
    }

    public int getSeniors() {
        return seniors;
    }

    public void setSeniors(int seniors) {
        this.seniors = seniors;
    }
    
    public void scanInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter ID: ");
        this.id = sc.nextLine();
        System.out.print("Enter name: ");
        this.name = sc.nextLine();
        System.out.print("Enter founding day: ");
        this.founding_day = sc.nextLine();
        System.out.print("Enter address: ");
        this.address = sc.nextLine();
        System.out.print("Enter number of senior: ");
        this.seniors = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter number of junior: ");
        this.juniors = sc.nextInt();
        sc.nextLine();
    }

    @Override
    public String toString() {
        return ", id=" + id + ", name=" + name + ", founding_day=" + founding_day + ", address=" + address + ", juniors=" + juniors + ", seniors=" + seniors;
    }
}
