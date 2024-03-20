package services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Set;
import java.util.TreeSet;

import models.Work;
import repository.RegisterRepository;
import utils.IDGenerator;
import utils.Validation;

public class WorkService {
    private static WorkService instance;
    private TreeSet<Work> workRegisters;

    private WorkService() {
        workRegisters = RegisterRepository.getInstance().getWorkRegisters();
    }

    public static WorkService getInstance() {
        if (instance == null) {
            instance = new WorkService();
        }
        return instance;
    }

    public void viewAllWorkSchedule() {
        workRegisters.forEach(System.out::println);
    }

    public void registerWorkSchedule() {
        String staffId = Validation.getAndValidateStaffId("Enter staff ID: ");
        String description = Validation.getValue("Enter description: ");
        LocalDate startDate = Validation.getDate("Enter start date: ");
        LocalDate endDate = Validation.getDate("Enter end date: ");
        LocalTime startTime = Validation.getTime("Enter start time: ");
        LocalTime endTime = Validation.getTime("Enter end time: ");
        String location = Validation.getValue("Enter location: ");
        String transport = Validation.getValue("Enter transport: ");

        Work work = new Work(
                IDGenerator.generate("W", workRegisters.size()),
                IDGenerator.generate("R", RegisterRepository.getInstance().getRegisterIndex()), staffId,
                LocalDate.now(),
                description,
                startDate,
                endDate,
                startTime,
                endTime,
                location,
                transport);
        workRegisters.add(work);
        RegisterRepository.getInstance().increaseRegisterIndex();
    }
}
