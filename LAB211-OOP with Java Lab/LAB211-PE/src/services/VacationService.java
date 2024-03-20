package services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TreeSet;

import models.Vacation;
import repository.RegisterRepository;
import utils.IDGenerator;
import utils.Validation;

public class VacationService {
    private static VacationService instance;
    private TreeSet<Vacation> vacationRegisters;

    private VacationService() {
        vacationRegisters = RegisterRepository.getInstance().getVacationRegisters();
    }

    public static VacationService getInstance() {
        if (instance == null) {
            instance = new VacationService();
        }
        return instance;
    }

    public void viewAllVacationSchedule() {
        vacationRegisters.forEach(System.out::println);
    }

    public void registerVacationSchedule() {
        String staffId = Validation.getAndValidateStaffId("Enter staff ID: ");
        String description = Validation.getValue("Enter description: ");
        LocalDate startDate = Validation.getDate("Enter start date: ");
        LocalDate endDate = Validation.getDate("Enter end date: ");
        LocalTime startTime = Validation.getTime("Enter start time: ");
        LocalTime endTime = Validation.getTime("Enter end time: ");
        String location = Validation.getValue("Enter location: ");
        int bound = Validation.getInt("Enter bound: ");

        Vacation vacation = new Vacation(
                IDGenerator.generate("VA", vacationRegisters.size()),
                IDGenerator.generate("R", RegisterRepository.getInstance().getRegisterIndex()),
                staffId,
                LocalDate.now(),
                description,
                startDate,
                endDate,
                startTime,
                endTime,
                location,
                bound);
        vacationRegisters.add(vacation);
        RegisterRepository.getInstance().increaseRegisterIndex();
    }
}
