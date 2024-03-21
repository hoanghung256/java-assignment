package repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import models.Department;

/**
 * @author hoang hung
 */
public class DepartmentRepository {
    private static DepartmentRepository instance;
    private final String srcPath = new File("src").getAbsolutePath();
    final String departmentPath = "\\data\\departments.txt";
    private HashMap<String, Department> departments;

    private DepartmentRepository() {
        departments = readDepartments();
    }

    public static DepartmentRepository getInstance() {
        if (instance == null) {
            instance = new DepartmentRepository();
        }
        return instance;
    }

    public HashMap<String, Department> getDepartments() {
        return departments;
    }

    private HashMap<String, Department> readDepartments() {
        departments = new HashMap<>();
        String line;

        try (BufferedReader input = new BufferedReader(new FileReader(srcPath + departmentPath))) {
            while ((line = input.readLine()) != null) {
                String[] attributes = line.split(";");
                Department dept = new Department(attributes[0], attributes[1]);
                departments.put(dept.getDepartmentId(), dept);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return departments;
    }
}
