/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package demointerface;

/**
 *
 * @author hoang
 */
public class Person {
    private int id;
    private String name;
    private boolean gender;
    
    //constructor
    public Person() {
    }
    
    public Person(int id, String name, boolean gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setGender(boolean gender) {
        this.gender = gender;
    }
    
    //getters
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name=" + name + ", gender=" + gender;
    }
    
}