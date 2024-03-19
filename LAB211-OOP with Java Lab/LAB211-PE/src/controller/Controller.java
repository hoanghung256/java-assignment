package controller;

import models.*;
import services.*;
import view.Menu;

/**
 *
 * @author hoang hung
 */
public class Controller extends Menu<String> {
    private static final String MENU_TITLE = "MENU";
    // private static final String[] MANAGER_MENU_OPTIONS = { "Register a schedule",
    // "View all notifications", "View all schedules", "Manage staff", "Log out" };
    private static final String[] STAFF_MENU_OPTIONS = { "Register a schedule", "View all notifications",
            "View schedules", "Edit your information", "Log out" };
    private Menu<String> registerController;
    private Menu<String> scheduleController;
    private String userId;

    public Controller(User user) {
        super(MENU_TITLE, STAFF_MENU_OPTIONS);
        userId = user.getStaffId();
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1 -> this.runRegisterManagementMenu();
            case 2 -> NotificationService.getInstance().viewAllNoti();
            case 3 -> this.runScheduleManagementMenu();
            case 4 -> {
            }
            case 5 -> {
                System.out.println("Goodbye!");
                System.exit(0);
            }
        }
    }

    private void runRegisterManagementMenu() {
        String title = "REGISTER MANAGEMENT";
        String[] options = { "Register meeting schedule", "Register work schedule", "Register vacation schedule",
                "Register study schedule", "Return main menu" };

        registerController = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 -> MeetingService.getInstance().registerMeetingSchedule();
                    case 2 -> {
                    }
                    case 3 -> {
                    }
                    case 4 -> {
                        return;
                    }
                }
            }
        };

        registerController.run();
    }

    private void runScheduleManagementMenu() {
        String title = "SCHEDULE MANAGEMENT";
        String[] options = { "View all meeting schedule", "View all work schedule", "View all vacation schedule",
                "View all study schedule", "Return main menu" };
        MeetingService scheduleService = MeetingService.getInstance();

        scheduleController = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 -> scheduleService.viewAllMeetingSchedule();
                    case 2 -> {
                    }
                    case 3 -> {
                    }
                    case 4 -> {
                    }
                    case 5 -> {
                        return;
                    }
                }
            }
        };

        scheduleController.run();
    }
}
