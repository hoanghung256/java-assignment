package services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.TreeSet;

import models.Vacation;
import repository.RegisterRepository;
import utils.IDGenerator;
import utils.Validation;

/**
 * @author hoang hung
 */
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
        System.out.println(
                "+-------------+-------------+---------------+--------------------------------+--------------+------------+----------+----------------------+-------+");
        System.out.println(String.format("| %-6s | %-5s | %-5s | %-30s | %-5s | %-1s | %-8s | %-20s | %-5s |",
                "Register ID", "Vacation ID", "Register date", "Description", "Meeting date", "Start time", "End time",
                "Location", "Bound"));
        System.out.println(
                "+-------------+-------------+---------------+--------------------------------+--------------+------------+----------+----------------------+-------+");
        vacationRegisters.forEach(System.out::println);
        System.out.println(
                "+-------------+-------------+---------------+--------------------------------+--------------+------------+----------+----------------------+-------+");
    }

    public void viewAllVacationSchedule(String staffId) {
        System.out.println(
                "+-------------+-------------+---------------+--------------------------------+--------------+------------+----------+----------------------+-------+");
        System.out.println(String.format("| %-6s | %-5s | %-5s | %-30s | %-5s | %-1s | %-8s | %-20s | %-5s |",
                "Register ID", "Vacation ID", "Register date", "Description", "Meeting date", "Start time", "End time",
                "Location", "Bound"));
        System.out.println(
                "+-------------+-------------+---------------+--------------------------------+--------------+------------+----------+----------------------+-------+");
        vacationRegisters.forEach(vacation -> {
            if (vacation.getStaffId().equals(staffId)) {
                System.out.println(vacation);
            }
        });
        System.out.println(
                "+-------------+-------------+---------------+--------------------------------+--------------+------------+----------+----------------------+-------+");
    }

    public void registerVacationSchedule() {
        String staffId = Validation.getAndValidateStaffId(1, "Enter staff ID: ");
        String description = Validation.getValue("Enter description: ");
        LocalDate startDate = Validation.getDate(0, null, "Enter start date: ");
        LocalDate endDate = Validation.getDate(1, startDate, "Enter end date: ");
        LocalTime startTime = Validation.getTime(0, null, "Enter start time: ");
        LocalTime endTime = Validation.getTime(1, startTime, "Enter end time: ");
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
