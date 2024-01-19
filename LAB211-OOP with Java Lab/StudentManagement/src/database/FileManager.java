/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import model.Student;

/**
 *
 * @author hoang
 */
public class FileManager {
    private final String path = new File("src").getAbsolutePath();
    private final String studentsPath = "\\database\\students.txt";
    
    public ArrayList<Student> readFromFile() {
        String line;
        ArrayList<Student> fruits = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(path + studentsPath))) {    //Try with resource
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
//                fruits.add(new Student();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }
        return fruits;
    }
    
    public void writeIntoFile(ArrayList<Student> students) {
        try (PrintWriter pr = new PrintWriter(path + studentsPath);) {
            for (Student student : students) {
                pr.println();
            }
            pr.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
