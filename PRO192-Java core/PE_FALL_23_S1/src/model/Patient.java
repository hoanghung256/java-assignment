/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoang
 */
public class Patient implements Comparable<Patient>{
    private String id;
    private String name;
    private Date dob;
    private String phone;

    public Patient() {
    }

    public Patient(String id, String name, Date dob, String phone) {
        this.id = id;
        this.name = name;
        this.dob = dob;
        this.phone = phone;
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

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        String toString = "";
        try {
            toString += "Patient{" + "id=" + id + ", name=" + name + ", dob=" + Validation.convertDateToString(dob) + ", phone=" + phone + '}';
        } catch (Exception ex) {
            Logger.getLogger(Patient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toString;
    }
    
    
    public void changePhone() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter your old phone: ");
            String old = sc.nextLine();
            if (old.equals(this.getId())) {
                System.out.print("Enter new phone: ");
                String newPhone = sc.nextLine();
                this.setPhone(newPhone);
                break;
            }
            System.out.println("Old phone wrong!");

        }
    }

    @Override
    public int compareTo(Patient o) {
        return this.getDob().compareTo(o.getDob());
    }
    
}
