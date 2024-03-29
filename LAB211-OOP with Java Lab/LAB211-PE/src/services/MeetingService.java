/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.TreeSet;

import models.Meeting;
import models.MeetingDetail;
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
    private TreeSet<Meeting> meetingRegisters;

    private MeetingService() {
        meetingDetails = MeetingDetailRepository.getInstance().getMeetingDetails();
        meetingRegisters = RegisterRepository.getInstance().getMeetingRegisters();
    }

    public static MeetingService getInstance() {
        if (instance == null) {
            instance = new MeetingService();
        }
        return instance;
    }

    public void viewAllMeetingSchedule() {
        System.out.println(
                "+-------------+------------+---------------+----------------------+--------------+------------+----------+-------------+");
        System.out.println(String.format("| %-6s | %-5s | %-5s | %-20s | %-5s | %-5s | %-5s | %-5s |",
                "Register ID", "Meeting ID", "Register date", "Description", "Meeting date", "Start time", "End time",
                "Location ID"));
        System.out.println(
                "+-------------+------------+---------------+----------------------+--------------+------------+----------+-------------+");
        meetingRegisters.forEach(System.out::println);
        System.out.println(
                "+-------------+------------+---------------+----------------------+--------------+------------+----------+-------------+");

        while (true) {
            char isViewDetail = Validation.getValue("Want to view meeting detail?(Y/N): ").charAt(0);
            if (isViewDetail == 'Y' || isViewDetail == 'y') {
                String meetingId = Validation.getValue("Enter meeting ID: ");
                viewMeetingDetail(meetingId);
            } else {
                return;
            }
        }
    }

    public void viewAllMeetingSchedule(String staffID) {
        System.out.println(
                "+-------------+------------+---------------+----------------------+--------------+------------+----------+-------------+");
        System.out.println(String.format("| %-6s | %-5s | %-5s | %-20s | %-5s | %-5s | %-5s | %-5s |",
                "Register ID", "Meeting ID", "Register date", "Description", "Meeting date", "Start time", "End time",
                "Location ID"));
        System.out.println(
                "+-------------+------------+---------------+----------------------+--------------+------------+----------+-------------+");
        meetingRegisters.forEach(meeting -> {
            if (meeting.getStaffId().equals(staffID)) {
                System.out.println(meeting);
            }
        });
        System.out.println(
                "+-------------+------------+---------------+----------------------+--------------+------------+----------+-------------+");

        while (true) {
            char isViewDetail = Validation.getValue("Want to view meeting detail?(Y/N): ").charAt(0);
            if (isViewDetail == 'Y' || isViewDetail == 'y') {
                String meetingId = Validation.getValue("Enter meeting ID: ");
                viewMeetingDetail(meetingId);
            } else {
                return;
            }
        }
    }

    public void registerMeetingSchedule() {
        Meeting meeting = null;

        while (true) {
            System.out.println("Entering meeting information.");
            String description = Validation.getValue("Meeting description: ");
            LocalDate meetingDate = Validation.getDate(0, null, "Meeting date: ");
            LocalTime startTime = Validation.getTime(0, null, "Start time: ");
            LocalTime endTime = Validation.getTime(1, startTime, "End time: ");
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
                    IDGenerator.generate("R", RegisterRepository.getInstance().getRegisterIndex() + 1),
                    staffId,
                    LocalDate.now(),
                    description,
                    meetingDate,
                    meetingDate,
                    startTime,
                    endTime,
                    location);
            meetingRegisters.add(meeting);
            RegisterRepository.getInstance().increaseRegisterIndex();
            break;
        }

        while (true) {
            System.out.println("Entering detail for meeting.");
            String staffId = Validation.getAndValidateStaffId(1, "Enter participant ID: ");
            String reason = Validation.getValue("Reason: ");
            meetingDetails.add(new MeetingDetail(IDGenerator.generate("MD", meetingDetails.size()), meeting.getId(),
                    staffId, reason));

            System.out.println("Want to continue enter participant for meeting(Y/N): ");
            char isContinue = Validation.getValue("Want to continue enter participant for meeting?(Y/N): ").charAt(0);

            if (isContinue == 'N' || isContinue == 'n') {
                break;
            }
        }
    }

    private void viewMeetingDetail(String meetingId) {
        if (containsMeeting(meetingId)) {
            System.out.println("Detail for meeting " + meetingId);

            System.out.println(
                    "+-----------+----------+--------------------------------+");
            System.out.println(String.format("| %-6s | %-5s | %-30s |",
                    "Detail ID", "Staff ID", "Reason"));
                    System.out.println(
                        "+-----------+----------+--------------------------------+");
            meetingDetails.stream()
                    .filter(detail -> detail.getMeetingId().equals(meetingId)) // Filter meeting details match meetingId
                    // that inputted
                    .forEach(System.out::println);
                    System.out.println(
                        "+-----------+----------+--------------------------------+");
        } else {
            System.out.println("Meeting does not exists!");
        }
    }


    private boolean containsMeeting(String meetingId) {
        return meetingDetails.stream().anyMatch(detail -> detail.getMeetingId().equals(meetingId));
    }
}
