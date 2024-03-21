package models;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *  An abstract class for 4 schedule types: Meeting, Work, Vacation, Study
 * @author hoang hung
 */
public abstract class Register implements Comparable<Register> {
    private String registerId;
    private String staffId;
    private LocalDate registerDate;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalTime startTime;
    private LocalTime endTime;
    private String location;

    public Register(String registerId, String staffId, LocalDate registerDate, String description, LocalDate startDate,
            LocalDate endDate, LocalTime startTime, LocalTime endTime, String location) {
        this.registerId = registerId;
        this.staffId = staffId;
        this.registerDate = registerDate;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.location = location;
    }

    public String getRegisterId() {
        return registerId;
    }

    public void setRegisterId(String registerId) {
        this.registerId = registerId;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Register{" + "registerId=" + registerId + ", staffId=" + staffId + ", registerDate=" + registerDate
                + ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate + ", startTime="
                + startTime + ", endTime=" + endTime + ", location=" + location + '}';
    }

    @Override
    public int compareTo(Register o) {
        return this.registerDate.compareTo(o.getRegisterDate());
    }

    public String toFileString() {
        return this.registerId + ";" + this.registerDate + ";" + this.description + ";" + this.startDate + ";" + this.endDate + ";" + this.startTime + ";" + this.endTime + ";" + this.location;
    }
}
