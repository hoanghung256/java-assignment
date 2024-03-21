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
public class Study extends Register {
    private String studyId;

    public Study(String studyId, String registerId, String staffId, LocalDate registerDate, String description,
            LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime, String location) {
        super(registerId, staffId, registerDate, description, startDate, endDate, startTime, endTime, location);
        this.studyId = studyId;
    }

    public String getStudyId() {
        return studyId;
    }

    public void setStudyId(String studyId) {
        this.studyId = studyId;
    }

    @Override
    public String toString() {
        return "Study [studyId=" + studyId + super.toString() + "]";
    }

    public String toFileString() {
        return this.studyId + super.toFileString();
    }
}
