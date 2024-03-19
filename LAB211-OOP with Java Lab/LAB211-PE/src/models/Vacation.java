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

    public Vacation(String vacationId, String registerId, String staffId, LocalDate registerDate, String description, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime, String location, int bound) {
        super(registerId, staffId, registerDate, description, startDate, endDate, startTime, endTime, location);
        this.vacationId = vacationId;
        this.bound = bound;
    }
}
