package controller;

import services.MeetingService;
import services.StudyService;
import services.VacationService;
import services.WorkService;
import view.Menu;

public class ViewScheduleController {
    private static ViewScheduleController instance;

    private ViewScheduleController() {
    }

    public static ViewScheduleController getInstance() {
        if (instance == null) {
            instance = new ViewScheduleController();
        }
        return instance;
    }

    /**
     * Staff can only view schedule registered by themself
     */
    public void runViewScheduleMenuForStaff() {
        String title = "VIEW SCHEDULE MENU";
        String[] options = {
                "View your meeting schedule",
                "View your work schedule",
                "View your vacation schedule",
                "View your study schedule",
                "Return main menu" };
        String loginStaffId = Controller.getInstance().getLoginStaff().getStaffId();

        Menu<String> viewScheduleMenuForStaff = new Menu<String>(title, options) {
            @Override
            public void execute(int ch) {
                switch (ch) {
                    case 1 -> MeetingService.getInstance().viewAllMeetingSchedule(loginStaffId);
                    case 2 -> WorkService.getInstance().viewAllWorkSchedule(loginStaffId);
                    case 3 -> VacationService.getInstance().viewAllVacationSchedule(loginStaffId);
                    case 4 -> StudyService.getInstance().viewAllStudySchedule(loginStaffId);
                    case 5 -> {
                        return;
                    }
                }
            }

        };

        viewScheduleMenuForStaff.run();
    }

    public void runViewScheduleMenuForManager() {
        String title = "VIEW SCHEDULE MENU";
        String[] options = {
                "View all meeting schedule",
                "View all work schedule",
                "View all vacation schedule",
                "View all study schedule",
                "Return main menu" };

        Menu<String> viewScheduleMenuForManager = new Menu<String>(title, options) {

            @Override
            public void execute(int ch) {
                switch (ch) {
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

        viewScheduleMenuForManager.run();
    }
}
