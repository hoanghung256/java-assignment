/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import view.Menu;
import model.StudentManager;

/**
 *
 * @author hoang
 */
public class SchoolManager extends Menu<String> {
    private static final String MENU_TITLE = "MANAGE STUDENT SYSTEM";
    private static final String[] MENU_OPTION = {"Display all student", "Sort student by name", "Display students with sam address", "Update student information", "Display report", "Exit"};
    private StudentManager studentManager;

    public SchoolManager() {
        super(MENU_TITLE, MENU_OPTION);
        studentManager = new StudentManager();
    }

    @Override
    public void execute(int chooice) {
        switch (chooice) {
            case 1:
                studentManager.showAllStudent();
                break;
            case 2:
                studentManager.sortStudentByName();
                break;
            case 3:
                studentManager.showSameAddressStudent();
                break;
            case 4:
                updateStudentInfor();
                break;
            case 5:
                deleteStudent();
                break;
            case 6:
                studentManager.showReport();
            case 7:
                exit();
                break;    
        }
    }
    
    private void updateStudentInfor() {
        
    }
    
    private void deleteStudent() {
        
    }
    
    private void exit() {
        System.out.println("Goodbye");
        System.exit(0);
        studentManager.writeStudentsToFile();
    }
}
