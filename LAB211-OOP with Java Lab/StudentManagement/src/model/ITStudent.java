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

    @Override
    public String toString() {
        return "ITStudent{" + super.toString() + ", javaScore=" + javaScore + ", cssScore=" + cssScore + '}';
    }
}
