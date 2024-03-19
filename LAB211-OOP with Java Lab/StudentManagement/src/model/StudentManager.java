/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.FileManager;
import java.util.ArrayList;
import java.util.function.Predicate;

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
    
    public void showAllStudent() {
        
    }
    
    public void sortStudentByName() {
        
    }
    
    public void showSameAddressStudent() {
        
    }
    
    public void showReport() {
        
    }
    
    public void updateInfor(Student s) {
        
    }
    
    public void deleteStudent(Student s) {
        
    }
    
    public Student searchStudent(Predicate<Student> criteria) {
        for (Student s : students) {
            if (criteria.test(s)) {
                return s;
            }
        }
        return null;
    }
    
    public void writeStudentsToFile() {
        fileManager.writeIntoFile(students);
    }
}
