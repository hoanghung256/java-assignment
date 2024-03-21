package services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TreeSet;

import models.Study;
import repository.RegisterRepository;
import utils.IDGenerator;
import utils.Validation;

/**
 * @author hoang hung
 */
public class StudyService {
    private static StudyService instance;
    private TreeSet<Study> studyRegisters;

    private StudyService() {
        studyRegisters = RegisterRepository.getInstance().getStudyRegisters();
    }

    public static StudyService getInstance() {
        if (instance == null) {
            instance = new StudyService();
        }
        return instance;
    }

    public void viewAllStudySchedule() {
        studyRegisters.forEach(System.out::println);
    }

    public void viewAllStudySchedule(String staffId) {
        studyRegisters.forEach(study -> {
            if (study.getStaffId().equals(staffId)) {
                System.out.println(study);
            }
        });
    }

    public void registerStudySchedule() {
        String staffId = Validation.getAndValidateStaffId(1, "Enter staff ID: ");
        String description = Validation.getValue("Enter description: ");
        LocalDate startDate = Validation.getDate(0, null, "Enter start date: ");
        LocalDate endDate = Validation.getDate(1, startDate, "Enter end date: ");
        LocalTime startTime = Validation.getTime(0, null, "Enter start time: ");
        LocalTime endTime = Validation.getTime(1, startTime, "Enter end time: ");
        String location = Validation.getValue("Enter location: ");

        Study study = new Study(
                IDGenerator.generate("ST", studyRegisters.size()),
                IDGenerator.generate("R", RegisterRepository.getInstance().getRegisterIndex()),
                staffId,
                LocalDate.now(),
                description,
                startDate,
                endDate,
                startTime,
                endTime,
                location);
        studyRegisters.add(study);
        RegisterRepository.getInstance().increaseRegisterIndex();
    }
}
