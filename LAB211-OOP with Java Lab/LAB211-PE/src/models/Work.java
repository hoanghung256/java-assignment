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
public class Work extends Register {
    private String workId;
    private String transport;

    public Work(String workId, String registerId, String staffId, LocalDate registerDate, String description,
            LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime, String location,
            String transport) {
        super(registerId, staffId, registerDate, description, startDate, endDate, startTime, endTime, location);
        this.workId = workId;
        this.transport = transport;
    }

    public String getWorkId() {
        return workId;
    }

    public void setWorkId(String workId) {
        this.workId = workId;
    }

    public String getTransport() {
        return transport;
    }

    public void setTransport(String transport) {
        this.transport = transport;
    }

    @Override
    public String toString() {
        return "Work [workId=" + workId + ", transport=" + transport + super.toString() + "]";
    }

    public String toFileString() {
        return this.workId + super.toFileString() +  this.transport;
    }
}
