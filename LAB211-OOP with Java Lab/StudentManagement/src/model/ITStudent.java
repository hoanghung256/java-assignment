/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author hoang
 */
public class ITStudent extends Student {
    private double javaScore;
    private double cssScore;

    public ITStudent(int Id, String fullName, Address address, double javaScore, double cssScore) {
        super(Id, fullName, address);
        this.javaScore = javaScore;
        this.cssScore = cssScore;
    }

    public ITStudent(double javaScore, double cssScore, int Id, String fullName, Address address) {
        super(Id, fullName, address);
        this.javaScore = javaScore;
        this.cssScore = cssScore;
    }

    public double getJavaScore() {
        return javaScore;
    }

    public void setJavaScore(double javaScore) {
        this.javaScore = javaScore;
    }

    public double getCssScore() {
        return cssScore;
    }

    public void setCssScore(double cssScore) {
        this.cssScore = cssScore;
    }
    
    public double getAverageScore() {
        return (3 * javaScore + cssScore) / 4;
    }

    @Override
    public String toString() {
        return "ITStudent{Name=" + super.getFullName() +  "GPA=" + this.getAverageScore() + '}';
    }
}
