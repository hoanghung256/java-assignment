package controller;

import repository.RegisterRepository;
import services.MeetingService;
import services.StudyService;
import services.VacationService;
import services.WorkService;
import view.Menu;

public class RegisterScheduleController extends Menu<String> {
    private static RegisterScheduleController instance;
    private static final String TITLE = "REGISTER SCHEDULE";
    private static final String[] OPTIONS = {
            "Register meeting schedule",
            "Register work schedule",
            "Register vacation schedule",
            "Register study schedule",
            "Return main menu" };

    private RegisterScheduleController() {
        super(TITLE, OPTIONS);
    }

    public static RegisterScheduleController getInstance() {
        if (instance == null) {
            instance = new RegisterScheduleController();
        }
        return instance;
    }

    @Override
    public void execute(int choice) {
        switch (choice) {
            case 1 -> MeetingService.getInstance().viewAllMeetingSchedule();
            case 2 -> WorkService.getInstance().viewAllWorkSchedule();
            case 3 -> VacationService.getInstance().viewAllVacationSchedule();
            case 4 -> StudyService.getInstance().viewAllStudySchedule();
            case 5 -> {
                RegisterRepository.getInstance().save();
                return;
            }
        }
    }
}
