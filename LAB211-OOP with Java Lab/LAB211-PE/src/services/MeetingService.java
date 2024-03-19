/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

import models.Meeting;
import models.MeetingDetail;
import models.Register;
import models.Staff;
import repository.MeetingDetailRepository;
import repository.RegisterRepository;
import utils.IDGenerator;
import utils.Validation;

/**
 *
 * @author hoang hung
 */
public class MeetingService {
    private static MeetingService instance;
    private ArrayList<MeetingDetail> meetingDetails;
    private HashMap<String, Register> registers;

    private MeetingService() {
        meetingDetails = MeetingDetailRepository.getInstance().getMeetingDetails();
        registers = RegisterRepository.getInstance().getRegisters();
    }

    public static MeetingService getInstance() {
        if (instance == null) {
            instance = new MeetingService();
        }
        return instance;
    }

    public void viewAllMeetingSchedule() {
        for (MeetingDetail meetingDetail : meetingDetails) {
            System.out.println(registers.get(meetingDetail.getMeetingId()));
        }
    }

    public void registerMeetingSchedule() {
        Meeting meeting = null;

        while (true) {
            System.out.println("Entering meeting information.");
            String description = Validation.getValue("Meeting description: ");
            LocalDate meetingDate = Validation.getDate("Meeting date: ");
            LocalTime startTime = Validation.getTime("Start time: ");
            LocalTime endTime = Validation.getTime("End time: ");
            String location = Validation.getValue("Location: ");
            String staffId = null;
            while (true) {
                staffId = Validation.getValue("Enter your ID: ");
                if (UserService.getInstance().findById(staffId) == null) {
                    System.out.println("Staff ID not exists!");
                    continue;
                }
                break;
            }
            meeting = new Meeting(IDGenerator.generate("M", meetingDetails.size()),
                    IDGenerator.generate("R", registers.size()),
                    staffId,
                    LocalDate.now(),
                    description,
                    meetingDate,
                    meetingDate,
                    startTime,
                    endTime,
                    location);
            registers.put(meeting.getId(), meeting);
            break;
        }

        while (true) {
            System.out.println("Entering detail for meeting.");
            Staff staff = null;
            while (true) {
                String staffName = Validation.getValue("Participant name: ");
                staff = StaffService.getInstance().findByName(staffName);
                if (staff == null) {
                    System.out.println("Staff not exists!");
                    continue;
                }
                break;
            }
            String reason = Validation.getValue("Reason: ");
            meetingDetails.add(new MeetingDetail(IDGenerator.generate("MD", meetingDetails.size()), meeting.getId(),
                    staff.getStaffId(), reason));

            System.out.println("Want to continue enter participant for meeting(Y/N): ");
            char isContinue = Validation.getValue("Want to continue enter participant for meeting?(Y/N): ").charAt(0);

            if (isContinue == 'N') {
                break;
            }
        }
    }
}
