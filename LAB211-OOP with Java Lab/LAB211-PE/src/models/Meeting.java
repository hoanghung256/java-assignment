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
public class Meeting extends Register {
    private String id;
    private String locationId;

    public Meeting(String id, String registerId, String staffId, LocalDate registerDate, String description,
            LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime, String locationId) {
        super(registerId, staffId, registerDate, description, startDate, endDate, startTime, endTime, null);
        this.id = id;
        this.locationId = locationId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    @Override
    public String toString() {
        return String.format("| %-11s | %-10s | %-13s | %-20s | %-12s | %-10s | %-8s | %-11s |",
                this.getRegisterId(), this.id, this.getRegisterDate(), this.getDescription(), this.getStartDate(),
                this.getStartTime(), this.getEndTime(), this.getLocationId());
    }

    public String toFileString() {
        return this.id + ";" + this.getRegisterId() + ";" + this.getRegisterDate() + ";" + this.getDescription() + ";"
                + this.getStartDate() + ";" + this.getEndDate() + ";" + this.getStartTime() + ";" + this.getEndTime()
                + this.locationId;
    }
}
