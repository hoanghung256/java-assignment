package controller;

import models.*;
import services.*;
import utils.Validation;
import view.Menu;

/**
 *
 * @author hoang hung
 */
public class Controller extends Menu<String> {
    private static final String MENU_TITLE = "MENU";
    private static final String[] STAFF_MENU_OPTIONS = {
            "Register a schedule",
            "View schedules",
            "View all notifications",
            "Staff management", "Log out" };
    private Menu<String> registerController;
    private Menu<String> scheduleController;
    private Menu<String> staffController;

    public Controller() {
        super(MENU_TITLE, STAFF_MENU_OPTIONS);
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1 -> this.runRegisterManagementMenu();
            case 2 -> this.runScheduleManagementMenu();
            case 3 -> NotificationService.getInstance().viewAllNoti();
            case 4 -> this.runStaffManagementMenu();
            case 5 -> {
                System.out.println("Goodbye!");
                System.exit(0);
            }
        }
    }

    private void runRegisterManagementMenu() {
        String title = "REGISTER MANAGEMENT";
        String[] options = {
                "Register meeting schedule",
                "Register work schedule",
                "Register vacation schedule",
                "Register study schedule",
                "Return main menu" };

        registerController = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 -> MeetingService.getInstance().registerMeetingSchedule();
                    case 2 -> WorkService.getInstance().registerWorkSchedule();
                    case 3 -> VacationService.getInstance().registerVacationSchedule();
                    case 4 -> StudyService.getInstance().registerStudySchedule();
                    case 5 -> {
                        // new Thread(() -> {
                        // // Save data here
                        // }).start();
                        return;
                    }
                }
            }
        };

        registerController.run();
    }

    private void runScheduleManagementMenu() {
        String title = "SCHEDULE MANAGEMENT";
        String[] options = {
                "View all meeting schedule",
                "View all work schedule",
                "View all vacation schedule",
                "View all study schedule",
                "Return main menu" };

        scheduleController = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 -> MeetingService.getInstance().viewAllMeetingSchedule();
                    case 2 -> WorkService.getInstance().viewAllWorkSchedule();
                    case 3 -> VacationService.getInstance().viewAllVacationSchedule();
                    case 4 -> StudyService.getInstance().viewAllStudySchedule();
                    case 5 -> {
                        return;
                    }
                }
            }
        };

        scheduleController.run();
    }

    private void runStaffManagementMenu() {
        String title = "STAFF MANAGEMENT";
        String[] options = {
                "View all staff",
                "Add new staff",
                "Delete a staff",
                "Update staff information",
                "Return main menu" };
        StaffService staffService = StaffService.getInstance();

        staffController = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 -> staffService.viewAllStaff();
                    case 2 -> staffService.addStaff();
                    case 3 -> staffService.deleteStaff();
                    case 4 -> {
                        String staffId = Validation.getAndValidateStaffId(1, "Enter staff ID: ");
                        Staff staff = staffService.findById(staffId);
                        staffService.editInformation(staff);
                    }
                    case 5 -> {
                        // new Thread(() -> {
                        // // Save data here
                        // }).start();
                        return;
                    }
                }
            }
        };

        staffController.run();
    }
}
