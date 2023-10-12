/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage;

/**
 *
 * @author hoang
 */
public class BizStudent extends Student{
    private double acc_score;
    private double mkt_score;

    public BizStudent() {
    }

    public BizStudent(String full_name, String address, int age, double acc_score, double mkt_score) {
        super(full_name, address, age);
        this.acc_score = acc_score;
        this.mkt_score = mkt_score;
    }

    public double getAcc_score() {
        return acc_score;
    }

    public void setAcc_score(double acc_score) {
        this.acc_score = acc_score;
    }

    public double getMkt_score() {
        return mkt_score;
    }

    public void setMkt_score(double mkt_score) {
        this.mkt_score = mkt_score;
    }
    
    public double calculateAverage() {
        return (acc_score*2 + mkt_score)/3;
    }

    @Override
    public String toString() {
        return "BizStudent{Full name: " + this.getFull_name() + ", Accounting score: " + acc_score + ", Marketing score: " + mkt_score + ", average: " + this.calculateAverage() + '}';
    }
}
