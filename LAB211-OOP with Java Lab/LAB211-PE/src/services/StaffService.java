package services;

import java.util.ArrayList;

import models.Staff;
import repository.StaffRepository;

public class StaffService {
    private static StaffService instance;
    private ArrayList<Staff> staffs;

    private StaffService() {
        staffs = StaffRepository.getInstance().readFile();
    }

    public static StaffService getInstance() {
        if (instance == null) {
            instance = new StaffService();
        }
        return instance;
    }

    public Staff findById(String staffId) {
        for (Staff staff : staffs) {
            if (staff.getStaffId().equals(staffId)) {
                return staff;
            }
        }
        return null;
    }

    public Staff findByName(String staffName) {
        for (Staff staff : staffs) {
            if (staff.getStaffName().equals(staffName)) {
                return staff;
            }
        }
        return null;
    }
}
