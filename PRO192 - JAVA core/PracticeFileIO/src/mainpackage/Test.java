package mainpackage;

import java.io.*;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author hoang
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    static ArrayList<Student> stdList = new ArrayList<>();
    static File file = new File("");
    static String path = file.getAbsolutePath() + "\\src\\";
    
    public static void main(String[] args) {
        // TODO code application logic here
        String fName = "StudentData.txt";
        loadData(fName);
        System.out.println("Load data succeed...");
        
        System.out.println("\nPrint data loaded: ");
        stdList.forEach(System.out::println);   
        
        stdList.add(new Student("005", "Nguyen Van E", 8.5f));
        System.out.println("\nAdded 1 student...");
        
        saveData("StudentDB.txt");
        System.out.println("Save data into DB succceed...");
    }
    
    public static void loadData(String fName) {
        String std = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader(path + fName));
            while ((std = br.readLine()) != null) {
                String[] b = std.split(";");
                stdList.add(new Student(b[0], b[1], Float.parseFloat(b[2])));
            }
            br.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
    //------------------------------------------------------------------
     public static void saveData(String fName) {
        try ( PrintWriter pr = new PrintWriter(path + fName);) {
            for (Student s : stdList) {
                pr.println(s);
            }
            pr.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    
}
