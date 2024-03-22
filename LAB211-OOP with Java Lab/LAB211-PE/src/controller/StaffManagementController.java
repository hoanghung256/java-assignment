package controller;

import models.Staff;
import repository.StaffRepository;
import services.StaffService;
import utils.Validation;
import view.Menu;

/**
 * This controller is for manager can manage all staff information
 * 
 * @author hoang hung
 */
public class StaffManagementController extends Menu<String> {
    private static StaffManagementController instance;
    private StaffService staffService;
    private static final String TITLE = "STAFF MANAGEMENT MENU";
    private static final String[] OPTIONS = {
            "Add new staff",
            "Delete a staff",
            "Edit staff information",
            "Edit your information",
            "Return main menu" };

    private StaffManagementController() {
        super(TITLE, OPTIONS);
        staffService = StaffService.getInstance();
    }

    public static StaffManagementController getInstance() {
        if (instance == null) {
            instance = new StaffManagementController();
        }
        return instance;
    }

    @Override
    public void execute(int ch) {
        switch (ch) {
            case 1 -> staffService.addStaff();
            case 2 -> staffService.deleteStaff();
            case 3 -> {
                String staffId = Validation.getAndValidateStaffId(1, "Enter staff ID: ");
                Staff staff = StaffService.getInstance().findById(staffId);
                staffService.editInformation(staff);
            }
            case 4 -> staffService.editInformation(Controller.getInstance().getLoginStaff());
            case 5 -> {
                new Thread(() -> {
                    StaffRepository.getInstance().save();
                }).start();
                return;
            }
        }
    }

}
