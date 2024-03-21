package controller;

import models.Staff;
import models.User;
import services.StaffService;
import view.Menu;

/**
 * The main controller of application
 * 
 * @author hoang hung
 */
public class Controller {
    private static Controller instance;
    private Staff currentStaff;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public void setLoginStaff(User loginUser) {
        this.currentStaff = StaffService.getInstance().findById(loginUser.getStaffId());
    }

    public Staff getLoginStaff() {
        return currentStaff;
    }

    public void runMenuForManager() {
        String title = "MANAGER MENU";
        String[] options = {
                "Register a schedule",
                "View schedule",
                "Notifications management",
                "Staff management",
                "Log out" };

        Menu<String> managerMenu = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 -> RegisterScheduleController.getInstance().run();
                    case 2 -> ViewScheduleController.getInstance().runViewScheduleMenuForManager();
                    case 3 -> NotificationController.getInstance().runNotificationMenuForManager();
                    case 4 -> StaffManagementController.getInstance().run();
                    case 5 -> {
                        System.out.println("Goodbye!");
                        System.exit(0);
                    }
                }
            }
        };

        managerMenu.run();
    }

    public void runMenuForStaff() {
        String title = "STAFF MENU";
        String[] options = {
                "Register a schedule",
                "View schedule",
                "Notifications management",
                "Edit your information",
                "Log out" };

        Menu<String> staffMenu = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1 -> RegisterScheduleController.getInstance().run();
                    case 2 -> ViewScheduleController.getInstance().runViewScheduleMenuForStaff();
                    case 3 -> NotificationController.getInstance().runNotificationMenuForStaff();
                    case 4 -> StaffService.getInstance().editInformation(currentStaff);
                    case 5 -> {
                        System.out.println("Goodbye!");
                        System.exit(0);
                    }
                }
            }
        };

        staffMenu.run();
    }
}
