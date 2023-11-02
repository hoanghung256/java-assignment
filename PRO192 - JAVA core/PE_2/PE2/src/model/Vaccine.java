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
public class Vaccine implements Comparable<Vaccine>{
    private String name;
    private String code;
    private int quantity;
    private Date expirationDate;
    private double price;
    private Date lastInjectedDate;

    public Vaccine() {
    }

    public Vaccine(String code, String name, int quantity, Date expirationDate, double price, Date lastInjectedDate) {
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.expirationDate = expirationDate;
        this.price = price;
        this.lastInjectedDate = lastInjectedDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getLastInjectedDate() {
        return lastInjectedDate;
    }

    public void setLastInjectedDate(Date lastInjectedDate) {
        this.lastInjectedDate = lastInjectedDate;
    }

    @Override
    public String toString() {
        String toString = "";
        try {
            toString += "Vaccine{" + "code=" + code + ", name=" + name + ", quantity=" + quantity + ", expirationDate=" + Validation.convertDateToString(expirationDate) + ", price=" + price + ", lastInjectedDate=" + Validation.convertDateToString(lastInjectedDate) + '}';
        } catch (Exception ex) {
            Logger.getLogger(Vaccine.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toString;
    }

    @Override
    public int compareTo(Vaccine o) {
        return this.getName().compareToIgnoreCase(o.getName());
    }

}
