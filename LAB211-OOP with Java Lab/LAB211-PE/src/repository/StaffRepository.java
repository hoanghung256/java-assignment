package repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import models.Staff;

public class StaffRepository {
    private static StaffRepository instance;
    private final String srcPath = new File("src").getAbsolutePath();
    final String usersPath = "\\data\\staffs.txt";
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
        try (BufferedReader input = new BufferedReader(new FileReader(srcPath + usersPath))) {
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
}
