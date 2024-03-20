package services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.TreeSet;

import models.Study;
import repository.RegisterRepository;
import utils.IDGenerator;
import utils.Validation;

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

    public void registerStudySchedule() {
        String staffId = Validation.getAndValidateStaffId("Enter staff ID: ");
        String description = Validation.getValue("Enter description: ");
        LocalDate startDate = Validation.getDate("Enter start date: ");
        LocalDate endDate = Validation.getDate("Enter end date: ");
        LocalTime startTime = Validation.getTime("Enter start time: ");
        LocalTime endTime = Validation.getTime("Enter end time: ");
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
