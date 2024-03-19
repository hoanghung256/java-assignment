package controller;

import services.NotificationService;
import view.Menu;

/**
 *
 * @author hoang hung
 */
public class Controller extends Menu<String> {
    private static final String MENU_TITLE = "MENU";
//    private static final String[] MANAGER_MENU_OPTIONS = { "Register a schedule", "View all notifications", "View all schedules", "Manage staff", "Log out" };
    private static final String[] STAFF_MENU_OPTIONS = { "Register a schedule", "View all notifications", "View all schedules", "Edit your information", "Log out" };
    private Menu<String> registerController;
    
    public Controller(String role) {
        super(MENU_TITLE, STAFF_MENU_OPTIONS);
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1:
                this.runRegisterManagementMenu();
                break;
            case 2:
                NotificationService.getInstance();
                break;
            case 3:
                
                break;
            case 4:
                System.out.println("Goodbye!");
                System.exit(0);
                break;   
        }
    }
    
    private void runRegisterManagementMenu() {
        String title = "EMPLOYEE MANAGEMENT";
        String[] options = { "Display employees list", "Add new employee", "Edit employee information",
                "Return main menu" };

        registerController = new Menu<String>(title, options) {
            @Override
            public void execute(int choice) {
                switch (choice) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        
                        return;
                }
            }
        };

        registerController.run();
    }
}
