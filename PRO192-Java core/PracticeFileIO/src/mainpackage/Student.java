/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage;

/**
 *
 * @author hoang
 */
public class Student {
    private String ID;
    private String Name;
    private float aver;

    public Student(String ID, String Name, float aver) {
        this.ID = ID;
        this.Name = Name;
        this.aver = aver;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public float getAver() {
        return aver;
    }

    public void setAver(float aver) {
        this.aver = aver;
    }

    @Override
    public String toString() {
        return "Student{" + "ID=" + ID + ", Name=" + Name + ", aver=" + aver + '}';
    }
    
}
