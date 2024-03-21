package services;

import java.util.ArrayList;

import models.Staff;
import repository.StaffRepository;
import utils.Validation;

public class StaffService {
    private static StaffService instance;
    private static ArrayList<Staff> staffs;

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

    public void viewAllStaff() {
        for (Staff staff : staffs) {
            System.out.println(staff);
        }
    }

    public void addStaff() {
        String staffId = Validation.getAndValidateStaffId(0, "Enter staff ID: ");
        String departmentId = Validation.getValue("Enter department ID: ");
        String staffName = Validation.getValue("Enter staff name: ");

        if (staffs.add(new Staff(staffId, departmentId, staffName))) {
            System.out.println("Add staff successfully!");
        } else {
            System.out.println("Add staff failed!");
        }
    }

    public void deleteStaff() {
        String staffId = Validation.getAndValidateStaffId(1, "Enter staff ID: ");
        if (staffs.removeIf(staff -> staff.getStaffId().equals(staffId))) {
            System.out.println("Delete successfully!");
        } else {
            System.out.println("Delete failed!");
        }
    }

    public void editInformation(Staff staff) {
        while (true) {
            String[] parts = { staff.getStaffId(), staff.getDepartmentId(), staff.getStaffName() };
            for (int i = 1; i <= parts.length; i++) {
                System.out.println(i + ". " + parts[i - 1]);
            }
            int choice = Validation.getInt("Enter the number of the attribute that you want to edit: ");
            switch (choice) {
                case 1 -> {
                    String staffId = Validation.getAndValidateStaffId(0, "Enter staff ID: ");
                    staff.setStaffId(staffId);
                }
                case 2 -> {
                    String departmentId = Validation.getValue("Enter department ID: ");
                    staff.setDepartmentId(departmentId);
                }
                case 3 -> {
                    String staffName = Validation.getValue("Enter staff name: ");
                    staff.setStaffName(staffName);
                }
                default -> {
                    System.out.println("Invalid choice! (Choice from 1 to 3)");
                }
            }
            char isContinue = Validation.getValue("Continue editing?(Y/N): ").charAt(0);
            if (isContinue == 'N' || isContinue == 'n') {
                break;
            }
        }
    }

    public static void main(String[] args) {
        StaffService.getInstance().viewAllStaff();
        StaffService.getInstance().editInformation(staffs.get(1));
        StaffService.getInstance().viewAllStaff();
    }
}
