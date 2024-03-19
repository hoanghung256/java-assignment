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

    public Work(String workId, String registerId, String staffId, LocalDate registerDate, String description, LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime, String location, String transport) {
        super(registerId, staffId, registerDate, description, startDate, endDate, startTime, endTime, location);
        this.workId = workId;
        this.transport = transport;
    }
    
}