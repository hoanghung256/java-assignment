/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.FileManager;
import java.util.ArrayList;

/**
 *
 * @author hoang
 */
public class StudentManager {
    ArrayList<Student> students;
    FileManager fileManager;

    public StudentManager() {
        fileManager = new FileManager();
        this.students = fileManager.readFromFile();
    }
}
