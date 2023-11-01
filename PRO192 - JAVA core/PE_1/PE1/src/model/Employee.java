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
public class Employee extends Company{
    private String id;
    private String acc;
    private Date startDate;
    private float productivity;
    private int allowance;

    public Employee() {
    }

    public Employee(String id, String acc, Date startDate, float productivity, int allowance) {
        this.id = id;
        this.acc = acc;
        this.startDate = startDate;
        this.productivity = productivity;
        this.allowance = allowance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAcc() {
        return acc;
    }

    public void setAcc(String acc) {
        this.acc = acc;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public float getProductivity() {
        return productivity;
    }

    public void setProductivity(float productivity) {
        this.productivity = productivity;
    }

    public int getAllowance() {
        return allowance;
    }

    public void setAllowance(int allowance) {
        this.allowance = allowance;
    }
    
    public float calMonthlyIncome() {
        return this.calReward() + allowance;
    }
    
    public float calReward() {
        return productivity * 3000000;
    }

    @Override
    public String toString() {
        String toString = "";
        try {
            toString += id + "     | " + acc + "     | " + Validation.convertDateToString(startDate) + "     | " + productivity + "     | " + this.calMonthlyIncome();
        } catch (Exception ex) {
            Logger.getLogger(Employee.class.getName()).log(Level.SEVERE, null, ex);
        }
        return toString;
    }
}
