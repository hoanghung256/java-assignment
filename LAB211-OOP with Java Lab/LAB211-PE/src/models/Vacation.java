/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author hoang hung
 */
public class Vacation extends Register {
    private String vacationId;
    private int bound;

    public Vacation(String vacationId, String registerId, String staffId, LocalDate registerDate, String description,
            LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime, String location,
            int bound) {
        super(registerId, staffId, registerDate, description, startDate, endDate, startTime, endTime, location);
        this.vacationId = vacationId;
        this.bound = bound;
    }

    public String getVacationId() {
        return vacationId;
    }

    public void setVacationId(String vacationId) {
        this.vacationId = vacationId;
    }

    public int getBound() {
        return bound;
    }

    public void setBound(int bound) {
        this.bound = bound;
    }

    @Override
    public String toString() {
        return String.format("| %-11s | %-11s | %-13s | %-30s | %-12s | %-10s | %-8s | %-20s | %-5s |",
        this.getRegisterId(), this.vacationId, this.getRegisterDate(),
        this.getDescription(), this.getStartDate(), this.getStartTime(),
        this.getEndTime(), this.getLocation(), this.bound);
    }

    public String toFileString() {
        return this.vacationId + super.toFileString() + this.bound;
    }
}
