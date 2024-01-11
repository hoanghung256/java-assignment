/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demointerface;

/**
 *
 * @author hoang
 */
public class Student extends Person implements Comparable<Student>{
    private double gpa;

    public Student() {
    }

    public Student(int id, String name, boolean gender, double gpa) {
        super(id, name, gender);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public int compareTo(Student o) {
        return this.getName().compareTo(o.getName());
    }
    
    @Override
    public String toString() {
        return "Student{" + super.toString()+", gpa=" + gpa + '}';
    } 
}
