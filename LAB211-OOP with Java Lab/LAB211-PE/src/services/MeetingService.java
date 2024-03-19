/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import models.Meeting;
import models.MeetingDetail;
import repository.MeetingRepository;
import utils.IDGenerator;

/**
 *
 * @author hoang hung
 */
public class MeetingService {
    private static MeetingService instance;
    private ArrayList<MeetingDetail> meetingDetails;
    private HashMap<String, Meeting> meetings;

    private MeetingService() {
    }

    public static MeetingService getInstance() {
        if (instance == null) {
            instance = new MeetingService();
        }
        return instance;
    }

    public void viewAllMeetingSchedule() {
        if (meetingDetails == null) {
            meetingDetails = MeetingRepository.getInstance().getMeetingDetails();
        }
        if (meetings == null) {
            meetings = MeetingRepository.getInstance().getMeetings();
        }

        for (String meetingId : meetings.keySet()) {
            System.out.println(meetings.get(meetingId));
        }
    }

    public void registerMeetingSchedule() {
        Scanner sc = new Scanner(System.in);
        Meeting meeting = null;

        while (true) {
            System.out.println("Entering metting information.");
            System.out.print("Meeting description: ");
            String description = sc.nextLine();
            System.out.print("Meeting date: ");
            String meetingDate = sc.nextLine();
            System.out.print("Start time: ");
            String startTime = sc.nextLine();
            System.out.print("End time: ");
            String endTime = sc.nextLine();
            System.out.print("Location: ");
            String location = sc.nextLine();
            
            meeting = new Meeting(IDGenerator.generate("M", meetings.size()), 0, 0, LocalDate.MIN, description, LocalDate.MAX, LocalDate.MAX, LocalTime.MIN, LocalTime.MIN, 0)
        }
        
        while (true) {
                System.out.println("Entering detail for meeting.");
                System.out.print("Participant name: ");
                String staffName = sc.nextLine();
                System.out.print("Reason: ");
                String reason = sc.nextLine();
                meetingDetails.add(new MeetingDetail());
                
                System.out.println("Want to continue enter participant for meeting(Y/N): ");
                char isContinue = sc.next().charAt(0);
                
                if (isContinue == 'N') {
                    break;
                }
            }
    }
}
