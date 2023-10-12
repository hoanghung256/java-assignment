/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage;

/**
 *
 * @author hoang
 */
public class ITStudent extends Student{
    private double java_score;
    private double css_score;

    public ITStudent() {
    }

    public ITStudent(String full_name, String address, int age, double java_score, double css_score) {
        super(full_name, address, age);
        this.java_score = java_score;
        this.css_score = css_score;
    }

    public double getJava_score() {
        return java_score;
    }

    public void setJava_score(double java_score) {
        this.java_score = java_score;
    }

    public double getCss_score() {
        return css_score;
    }

    public void setCss_score(double css_score) {
        this.css_score = css_score;
    }

    public double calculateAverage() {
        return (3 * java_score + css_score)/4;
    }

    @Override
    public String toString() {
        return "ITStudent{Full name: " + this.getFull_name() + ", Java score: " + java_score + ", CSS score: " + css_score + ", Average: " + this.calculateAverage() + "}";
    }
    
    
}
