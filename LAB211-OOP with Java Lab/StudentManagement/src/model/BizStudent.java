/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoang
 */
public class BizStudent extends Student {
    private double accScore;
    private double mktScore;

    public BizStudent(double accScore, double mktScore, int Id, String fullName, Address address) {
        super(Id, fullName, address);
        this.accScore = accScore;
        this.mktScore = mktScore;
    }

    public double getAccScore() {
        return accScore;
    }

    public void setAccScore(double accScore) {
        this.accScore = accScore;
    }

    public double getMktScore() {
        return mktScore;
    }

    public void setMktScore(double mktScore) {
        this.mktScore = mktScore;
    }

    @Override
    public String toString() {
        return "BizStudent{" + super.toString() +  "accScore=" + accScore + ", mktScore=" + mktScore + '}';
    }
}
