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
public class Staff {
    private String id;
    private String fullName;
    private String department;
    private String password;
    private Date dob;

    public Staff() {
    }

    public Staff(String id, String fullName, String department, String password, Date dob) {
        this.id = id;
        this.fullName = fullName;
        this.department = department;
        this.password = password;
        this.dob = dob;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    @Override
    public String toString() {
        String toString = "";
        try {
            toString += "Staff{" + "id=" + id + ", fullName=" + fullName + ", department=" + department + ", password=" + password + ", dob=" + Validation.convertDateToString(dob) + '}';
        } catch (Exception ex) {
            Logger.getLogger(Staff.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toString;
    }

    public void changePassword() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("Enter your old password: ");
            String old = sc.nextLine();
            if (old.equals(this.getId())) {
                System.out.print("Enter new password: ");
                String newPass = sc.nextLine();
                this.setPassword(newPass);
                break;
            }
            System.out.println("Old password wrong!");

        }
    }
}
