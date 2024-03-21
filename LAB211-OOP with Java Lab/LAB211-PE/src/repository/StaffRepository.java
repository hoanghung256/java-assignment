package repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;

import models.Staff;

/**
 * @author hoang hung
 */
public class StaffRepository {
    private static StaffRepository instance;
    private final String srcPath = new File("src").getAbsolutePath();
    final String staffsPath = "\\data\\staffs.txt";
    private ArrayList<Staff> staffs;

    private StaffRepository() {
    }

    public static StaffRepository getInstance() {
        if (instance == null) {
            instance = new StaffRepository();
        }
        return instance;
    }

    public ArrayList<Staff> readFile() {
        String line;
        staffs = new ArrayList<>();
        try (BufferedReader input = new BufferedReader(new FileReader(srcPath + staffsPath))) {
            while ((line = input.readLine()) != null) {
                String[] attributes = line.split(";");
                Staff staff = new Staff(attributes[0], attributes[1], attributes[2]);
                staffs.add(staff);
            }
            return staffs;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void save() {
        try {
            PrintWriter writer = new PrintWriter(srcPath + staffsPath);
            staffs.forEach(staff -> writer.println(staff.toFileString()));
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
