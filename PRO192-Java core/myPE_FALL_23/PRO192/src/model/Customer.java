/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hoang
 */
public class Customer implements Comparable<Customer>{
    private String id;
    private String name;
    private String phone;
    private Date dob;

    public Customer() {
    }

    public Customer(String id, String name, String phone, Date dob) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.dob = dob;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }
    
    public String getHomeNetwork() {
        String homeNetwork = "";
        switch (phone.charAt(2)) {
            case '8':
                homeNetwork += "Viettel";
                break;
            case '0':
                homeNetwork += "Vinaphone";
                break;
            case '3':
                homeNetwork += "Mobiphone";
                break;
            default:
                break;
        }
        return homeNetwork;
     }

    @Override
    public String toString() {
        String toString = "";
        try {
             toString += id + "  |  " + name + "  |  " + phone + "  |  " + Validation.convertDateToString(dob) + "  |  " + this.getHomeNetwork();
        } catch (Exception ex) {
            Logger.getLogger(Customer.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toString;
    }

    @Override
    public int compareTo(Customer o) {
        return this.getName().compareTo(o.getName());
    }
    
    
}
