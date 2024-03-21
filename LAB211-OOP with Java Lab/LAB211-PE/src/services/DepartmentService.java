package services;

import java.util.HashMap;

import models.Department;
import repository.DepartmentRepository;

/**
 * @author hoang hung
 */
public class DepartmentService {
    private static DepartmentService instance;
    private HashMap<String, Department> departments;

    private DepartmentService() {
        departments = DepartmentRepository.getInstance().getDepartments();
    }

    public static DepartmentService getInstance() {
        if (instance == null) {
            instance = new DepartmentService();
        }
        return instance;
    }

    public Department findById(String departmentId) {
        return departments.get(departmentId);
    }
}
